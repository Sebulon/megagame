package com.chalmersmegagame.game.users.controller;

import com.chalmersmegagame.game.players.Player;
import com.chalmersmegagame.game.players.PlayerService;
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

    @Autowired
    private PlayerService playerService;

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id) {

        //TODO: Probably should do something about how we store players and users
        User user = usersService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user.getRole());
        }
        Player player = playerService.getPlayer(id);
        if (player != null) {
            return ResponseEntity.ok("player");
        }
        return ResponseEntity.ok("");
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return ResponseEntity.ok(usersService.addUser(user));
    }

}
