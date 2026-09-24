package com.smartcanteen.home.service;


import com.smartcanteen.home.Controller.UserLoginController;
import com.smartcanteen.home.Entity.UserLogin;
import com.smartcanteen.home.Repository.UserLoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserLoginService {
    private final UserLoginRepository userLoginRepository;
    public String signup(UserLogin userLogin)
    {
        if(userLoginRepository.findByEmail(userLogin.getEmail()).isPresent())
        {
            throw new RuntimeException("Email Already exists");
        }
        userLogin.setRole("USER");
        userLoginRepository.save(userLogin);

        return "User registered Successfully";
    }
    public String login(String email, String password)
    {
        UserLogin userLogin = userLoginRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!userLogin.getPassword().equals(password)) {
            throw new RuntimeException("Invalid Password");
        }

        return "Login Successful";
    }


}
