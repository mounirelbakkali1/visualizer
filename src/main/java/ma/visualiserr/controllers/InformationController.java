package ma.visualiserr.controllers;


import jakarta.validation.Valid;
import ma.visualiserr.requests.StatistiqueRequest;
import ma.visualiserr.services.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class InformationController {

    @Autowired
    InformationService service ;

    @RequestMapping("/")
    public ModelAndView index(){
        return  new ModelAndView("/index");
    }

    @RequestMapping("/features")
    public ModelAndView statistics(){
        ModelAndView vm = new ModelAndView("/features");
        vm.addObject("request", new StatistiqueRequest("(15-20)","Female", LocalDate.parse("2023-05-09")));
        return vm;
    }

    @RequestMapping(value = "/features",method = POST)
    public ModelAndView findStatistics(@ModelAttribute("request") @Valid StatistiqueRequest request,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
        }
        var statistics = service.findStatistic(request);
        var vm = new ModelAndView("/features");
        vm.addObject("statistics",statistics);
        return vm ;
    }
}
