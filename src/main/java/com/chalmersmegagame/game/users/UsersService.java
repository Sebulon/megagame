package com.chalmersmegagame.game.users;

import com.chalmersmegagame.game.players.Player;
import com.chalmersmegagame.game.roles.UserRole;
import com.chalmersmegagame.game.teams.Team;
import com.chalmersmegagame.game.users.repository.UsersRepository;
import com.chalmersmegagame.game.users.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The class other classes are supposed to talk to when backend need to access users.
 */
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    public User addUser(User user) {
        return usersRepository.save(user);
    }

    public List<User> getUsersBasedOnRole(UserRole role) {
        return usersRepository.findAll((user, cq, cb) -> cb.equal(user.get("role"), role.name));
    }

    public List<Player> createPlayers() {
        List<User> players = getUsersBasedOnRole(UserRole.PLAYER);
        List<Player> returnList = new ArrayList<>();
        players.forEach(p -> returnList.add(new Player(p.getId())));
        return returnList;
    }
}
