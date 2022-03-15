package com.chalmersmegagame.game.users.controller;

import com.chalmersmegagame.game.roles.UserRole;
import com.chalmersmegagame.game.users.UsersService;
import com.chalmersmegagame.game.users.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The controller that talks to the frontend about the users.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @GetMapping("/users/{role}")
    public ResponseEntity<?> getUsersBasedOnRole(@PathVariable String role) {
        UserRole currentRole = UserRole.findRole(role);
        if (currentRole == null) {
            return ResponseEntity.badRequest().body("The role " + "'" + role + "' does not exist");
        }
        return ResponseEntity.ok(usersService.getUsersBasedOnRole(currentRole));
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return ResponseEntity.ok(usersService.addUser(user));
    }

}
