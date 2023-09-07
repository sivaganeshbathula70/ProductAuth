package com.example.ProductAuth.controller;
import com.example.ProductAuth.model.UserData;
import com.example.ProductAuth.service.JwtService;
import com.example.ProductAuth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/products")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    JwtService jwtService;

    @GetMapping("/displayall")
    public List<UserData> displayall()
    {
        return userService.display();
    }

    @PostMapping("/addUser")
    public UserData addUser(@RequestBody UserData userData) {
        return userService.createUser(userData);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateAndGetToken(@RequestBody UserData userData) {
        boolean isAuthenticated = userService.findByUsername(userData.getUsername(), userData.getPassword());

        if (isAuthenticated) {
            String token = jwtService.generateToken(userData.getUsername());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user credentials");
        }
    }
}