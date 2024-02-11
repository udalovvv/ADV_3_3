package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final String AUTHUSER = "authUser";
    private static final String AUTHENTICATION = "authentication";

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String index(Model userModel,
                        Authentication authentication) {
        userModel.addAttribute("users", userService.findAll());
        userModel.addAttribute("newUser", new User());
        userModel.addAttribute(AUTHENTICATION, authentication);
        userModel.addAttribute(AUTHUSER, authentication.getPrincipal());
        userModel.addAttribute("rolesList", roleService.findAllRole());
        userModel.addAttribute("admin", userService.findByEmail(authentication.getName()));
        return "adminpanel/admin";
    }
}
