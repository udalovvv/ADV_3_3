package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminRestController {

    private final UserServiceImpl userServiceImpl;

    private final RoleServiceImpl roleService;

    public AdminRestController(UserServiceImpl userServiceImpl, RoleServiceImpl roleService) {
        this.userServiceImpl = userServiceImpl;
        this.roleService = roleService;
    }

//    @GetMapping("/roles")
//    public ResponseEntity<List<Role>> getAllRoles() {
//        return new ResponseEntity<>(roleService.findAllRole(), HttpStatus.OK);
//    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUsers() {
        return new ResponseEntity<>(userServiceImpl.findAll(), HttpStatus.OK);
    }

//    @GetMapping("/users/{id}")
//    public ResponseEntity<User> getUser(@PathVariable(name = "id") Long id) {
//        return new ResponseEntity<>(userServiceImpl.findById(id), HttpStatus.OK);
//    }
//
//    @PostMapping("/users")
//    public ResponseEntity<User> addNewUser(@RequestBody User user) {
//        userServiceImpl.save(user);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @GetMapping("/users/current_user")
//    public ResponseEntity <User> showCurrentUser(@AuthenticationPrincipal User user) {
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @PutMapping("/users/{id}")
//    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) {
//        userServiceImpl.updateUser(id, user);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
//        userServiceImpl.deleteById(id);
//        return new ResponseEntity<>(id, HttpStatus.OK);
//    }
}
