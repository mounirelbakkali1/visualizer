package ma.visualiserr.configurations;


import ma.visualiserr.entities.Admin;
import ma.visualiserr.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Stream;

@Component
public class AdminRepositoryDetailsService implements UserDetailsService {

    @Autowired
    AdminRepository repository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .map(BridgeAdmin::new)
                .orElseThrow(()-> new  UsernameNotFoundException("username "+username+" not found in our records"));
    }

    private static class BridgeAdmin extends Admin implements UserDetails{
        public BridgeAdmin(Admin admin){
            super(admin);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Stream.of("WRITE","READ")
                    .map(o-> new SimpleGrantedAuthority(o))
                    .toList();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
