package Tut2_3_4_5.controller;

import Tut2_3_4_5.model.User;
import Tut2_3_4_5.repository.RoleRepository;
import Tut2_3_4_5.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @GetMapping(value = "/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping(value = "/register")
    public String registerForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping(value = "/register")
    public String register(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        user.addRole(roleRepository.getReferenceById(Long.valueOf(2)));
        user.setEnabled(true);
        userRepository.save(user);
        return "redirect:/";
    }
}

