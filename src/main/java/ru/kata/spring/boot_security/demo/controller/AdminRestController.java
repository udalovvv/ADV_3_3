package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminRestController {

    private final UserServiceImpl userServiceImpl;


    private final UserService userService;

    public AdminRestController(UserServiceImpl userServiceImpl, UserService userService) {
        this.userServiceImpl = userServiceImpl;
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<User> showUserInfo(@RequestParam("id") long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUsers() {
        return new ResponseEntity<>(userServiceImpl.findAll(), HttpStatus.OK);
    }


    @PostMapping("/users")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        userServiceImpl.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) {
        userServiceImpl.updateUser(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        userServiceImpl.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
