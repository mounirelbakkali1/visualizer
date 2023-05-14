package ma.visualiserr.services;


import ma.visualiserr.requests.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public class AdminService {



    public boolean login(LoginRequest request){
        return true ;
    }
}
