package com.backendbudgettracker.backendbudgettracker.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendbudgettracker.backendbudgettracker.entity.Image;
import com.backendbudgettracker.backendbudgettracker.dto.LoginReturnDTO;
import com.backendbudgettracker.backendbudgettracker.entity.User;
import com.backendbudgettracker.backendbudgettracker.repository.ImageRepository;
import com.backendbudgettracker.backendbudgettracker.repository.UserRepository;
import com.backendbudgettracker.backendbudgettracker.request.AuthRequest;
import com.backendbudgettracker.backendbudgettracker.security.JwtHelper;
import com.backendbudgettracker.backendbudgettracker.security.JwtTokenProvider;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;

    private JwtTokenProvider tokenProvider;

    @Autowired
    private JwtHelper jwtHelper;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    @GetMapping("/getById")
    public User getById(@RequestBody Map<String, String> body, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // check if userid matches
        if (jwtHelper.getUserIdFromRequest(request) == Long.parseLong(body.get("id"))) {
            Optional<User> user = userRepository.findById(Long.parseLong(body.get("id")));
            if (user.isPresent()) {
                return user.get();
            }
        }
        response.sendError(401);
        return null;
    }

    @GetMapping("/getUser")
    public User getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long userId = jwtHelper.getUserIdFromRequest(request);
        if (userId != null) {
            Optional<User> user = userRepository.findById(userId);
            if (user.isPresent()) {
                return user.get();
            }
        }
        response.sendError(401);
        return null;
    }

    @GetMapping("")
    public List<User> getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (jwtHelper.getAdminFromRequest(request)) {
            List<User> users = new ArrayList<>();
            userRepository.findAll().forEach(users::add);
            return users;
        }
        response.sendError(401);
        return null;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@RequestBody AuthRequest authRequest) {
        Optional<User> userOptional = userRepository.findByEmail(authRequest.getEmail());

        if (userOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        if (authRequest.getEmail() == null
                || authRequest.getEmail().isEmpty()
                || authRequest.getPassword() == null
                || authRequest.getPassword().isEmpty()
                || authRequest.getFirstName() == null
                || authRequest.getFirstName().isEmpty()
                || authRequest.getLastName() == null
                || authRequest.getLastName().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        User user = new User();
        user.setEmail(authRequest.getEmail());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        user.setFirstName(authRequest.getFirstName());
        user.setLastName(authRequest.getLastName());

        User created = userRepository.save(user);

        return ResponseEntity.ok(created);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginReturnDTO> login(@RequestBody AuthRequest authRequest, HttpServletResponse response)
            throws IOException {
        Optional<User> userOptional = userRepository.findByEmail(authRequest.getEmail());
        if (!userOptional.isPresent()) {
            response.sendError(404, "user not found");
            return ResponseEntity.badRequest().build();
        }
        if (!userOptional.get().getActive()) {
            response.sendError(401, "User inactive");
            return ResponseEntity.badRequest().build();
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        LoginReturnDTO loginReturn = new LoginReturnDTO();
        loginReturn.setToken(tokenProvider.generateToken(authentication));
        loginReturn.setUserType(userOptional.get().getAdmin() ? "admin" : "user");
        loginReturn.setUserId(userOptional.get().getId());
        return ResponseEntity.ok(loginReturn);
    }

    @PostMapping(value = "/updatePassword")
    public ResponseEntity<User> updatePassword(@RequestBody Map<String, String> params, HttpServletRequest request) {
        Long userId = jwtHelper.getUserIdFromRequest(request);
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(params.get("oldPassword"), user.getPassword())) {
                user.setPassword(passwordEncoder.encode(params.get("newPassword")));
                User updated = userRepository.save(user);
                return ResponseEntity.ok(updated);
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping(value = "/setUserActive")
    public ResponseEntity<User> setUserActive(@RequestBody Map<String, String> params, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        if (jwtHelper.getAdminFromRequest(request)) {
            Optional<User> userOptional = userRepository.findByEmail(params.get("email"));
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                if (params.get("active").equals("true") || params.get("active").equals("TRUE")) {
                    user.setActive(true);
                } else {
                    user.setActive(false);
                }
                User updated = userRepository.save(user);
                return ResponseEntity.ok(updated);
            }
            return ResponseEntity.badRequest().build();
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping(value = "/updateUserAsAdmin")
    public ResponseEntity<User> updateUserAsAdmin(@RequestBody Map<String, String> params, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        if (jwtHelper.getAdminFromRequest(request)) {
            Optional<User> userOptional = userRepository.findByEmail(params.get("id-email"));
            if (userOptional.isPresent()) {
                User userToUpdate = userOptional.get();
                userToUpdate.setEmail(params.get("email"));
                userToUpdate.setFirstName(params.get("firstName"));
                userToUpdate.setLastName(params.get("lastName"));
                User updated = userRepository.save(userToUpdate);
                return ResponseEntity.ok(updated);
            }
            return ResponseEntity.badRequest().build();
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping(value = "/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody Map<String, String> params, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        Long userId = jwtHelper.getUserIdFromRequest(request);
        if (params.get("email").isEmpty() || params.get("firstName").isEmpty() || params.get("lastName").isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return ResponseEntity.badRequest().build();
        }
        User userToUpdate = userRepository.findById(userId).get();
        userToUpdate.setEmail(params.get("email"));
        userToUpdate.setFirstName(params.get("firstName"));
        userToUpdate.setLastName(params.get("lastName"));
        User updated = userRepository.save(userToUpdate);

        return ResponseEntity.ok(updated);
    }

    @PostMapping(value = "/setUserAdmin")
    public ResponseEntity<User> setUserAdmin(@RequestBody Map<String, String> params, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        if (jwtHelper.getAdminFromRequest(request)) {
            Optional<User> userOptional = userRepository.findByEmail(params.get("email"));
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                if (params.get("admin").equals("true") || params.get("active").equals("TRUE")) {
                    user.setAdmin(true);
                } else {
                    user.setAdmin(false);
                }
                User updated = userRepository.save(user);
                return ResponseEntity.ok(updated);
            }
            return ResponseEntity.badRequest().build();
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        return ResponseEntity.badRequest().build();
    }
}