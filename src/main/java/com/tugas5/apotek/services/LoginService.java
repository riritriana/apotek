package com.tugas5.apotek.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas5.apotek.models.Login;
import com.tugas5.apotek.repositories.LoginRepository;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public void save(Login login){
        loginRepository.save(login);
    }
    
    public Login findByUsernameAndPassword(String username, String password){
        List <Login> login = loginRepository.findByUsernameAndPassword(username, password);
        return login.stream()
                    .findFirst()
                    .orElse(null);
    }
    public List<Login> getAllLogin(){
        return loginRepository.findAll();
    }
}
