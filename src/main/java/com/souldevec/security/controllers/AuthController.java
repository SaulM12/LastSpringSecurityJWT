package com.souldevec.security.controllers;

import com.souldevec.security.dtos.ApiMessage;
import com.souldevec.security.dtos.LoginUserDto;
import com.souldevec.security.dtos.NewUserDto;
import com.souldevec.security.entities.User;
import com.souldevec.security.services.AuthService;
import com.souldevec.security.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @Autowired
    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiMessage> login(@Valid @RequestBody LoginUserDto loginUserDto, BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new ApiMessage("Revise sus credenciales"));
        }
        try {
            String roleName = authService.authenticate(loginUserDto.getUserName(), loginUserDto.getPassword(), response);
            return ResponseEntity.ok(new ApiMessage(roleName));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiMessage(e.getMessage()));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ApiMessage> register(@Valid @RequestBody NewUserDto newUserDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new ApiMessage("Revise los campos"));
        }
        try {
            authService.registerUser(newUserDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiMessage("Registrado"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiMessage(e.getMessage()));
        }
    }

    @GetMapping("/check-auth")
    public ResponseEntity<String> checkAuth() {
        return ResponseEntity.ok().body("Autenticado");
    }

    @GetMapping("/user/details")
    public ResponseEntity<User> getAuthenticatedUser() {
        User user = userService.getUserDetails();
        return ResponseEntity.ok(user);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response){
        authService.logout(response);
        return ResponseEntity.ok(new ApiMessage("Sesión finalizada"));
    }
}
