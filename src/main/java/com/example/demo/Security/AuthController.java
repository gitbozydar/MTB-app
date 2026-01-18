package com.example.demo.Security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/Quiz")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "Quiz/login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "Quiz/register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
        if (userRepository.findByUsername(username).isPresent()) {
            model.addAttribute("error", "Taki użytkownik już istnieje!");
            return "Quiz/register";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);

        return "redirect:/Quiz/login";
    }

    // --- NOWE METODY DO ZMIANY HASŁA ---

    @GetMapping("/change-password")
    public String changePasswordPage() {
        return "Quiz/change_password";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestParam String newPassword, Principal principal) {
        // Principal to aktualnie zalogowany użytkownik
        String username = principal.getName();

        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
        }

        return "redirect:/Quiz/categories";
    }
}