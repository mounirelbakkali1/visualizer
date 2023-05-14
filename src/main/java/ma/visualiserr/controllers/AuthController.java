package ma.visualiserr.controllers;

import jakarta.validation.Valid;
import ma.visualiserr.configurations.AdminRepositoryDetailsService;
import ma.visualiserr.repositories.AdminRepository;
import ma.visualiserr.requests.LoginRequest;
import ma.visualiserr.requests.PasswordResetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserDetailsService detailsService;
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    AdminRepository adminRepository ;

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login(){
        return "/login";
    }

    @PostMapping("/process_login")
    public ModelAndView proccessLogin(@ModelAttribute("request") @Valid LoginRequest request,
                              BindingResult bindingResult){
        var vm = new ModelAndView("/");
        return vm;
    }
    
    @GetMapping(value = "/change-password")
    public ModelAndView changePassword(){
        ModelAndView vm = new ModelAndView("/change-password");
        vm.addObject("password",new PasswordResetRequest("","",""));
        return  vm ;
    }

    @PostMapping("/reset_password")
    @Transactional
    public String saveNewPassword(@ModelAttribute("password") @Valid PasswordResetRequest password, Authentication auth, RedirectAttributes redirectAttributes){
        System.out.println(password);
        System.out.println(password.currentPassword());
        String username = auth.getName();
        UserDetails user = detailsService.loadUserByUsername(username);
        String encoded = encoder.encode(password.currentPassword());
        System.out.println("encoded : "+encoded);
        System.out.println("current encoded :"+user.getPassword());
        System.out.println(encoder.matches(encoded,user.getPassword()));
        if(!encoder.matches(password.currentPassword(),user.getPassword()))
        {
            redirectAttributes.addFlashAttribute("errorMessage", "Error updating password. Incorrect current password.");
            return "redirect:change-password?reset=false";
        }
        try {
            adminRepository.updatePasswordBy(encoder.encode(password.newPassword()));
            redirectAttributes.addFlashAttribute("successMessage", "Password updated successfully!");
            return "redirect:change-password?reset=true";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error updating password. Please try again.");
            return "redirect:change-password?reset=false";
        }
    }
}
