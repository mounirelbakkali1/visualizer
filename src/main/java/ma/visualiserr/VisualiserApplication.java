package ma.visualiserr;

import ma.visualiserr.entities.Admin;
import ma.visualiserr.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class VisualiserApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisualiserApplication.class, args);
    }
    @Autowired
    AdminRepository repository ;

    @Autowired
    PasswordEncoder encoder ;

    /*@Bean
    CommandLineRunner runner(){
        return args -> {
          repository.save(new Admin(null,"admin",encoder.encode("admin")));
        };
    }*/
}
