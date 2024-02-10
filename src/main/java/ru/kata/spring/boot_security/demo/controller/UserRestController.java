package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@RequestMapping("/api")
//@CrossOrigin
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping("/users")
    public ResponseEntity<User> showUserInfo(@RequestParam("id") long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
}
