package com.smartcanteen.home.Controller;


import com.smartcanteen.home.Entity.UserLogin;
import com.smartcanteen.home.service.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class UserLoginController {
    private final UserLoginService userLoginService;

    @PostMapping("/signup")
    public String signup(@RequestBody UserLogin userLogin)
    {
        return userLoginService.signup(userLogin);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin) {
        try {
            String message = userLoginService.login(userLogin.getEmail(), userLogin.getPassword());
            // Return a JSON object so React can read it easily
            return ResponseEntity.ok().body(java.util.Map.of("message", message, "email", userLogin.getEmail()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }



}
