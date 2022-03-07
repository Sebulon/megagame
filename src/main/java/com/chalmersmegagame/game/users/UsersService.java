package com.chalmersmegagame.game.users;

import com.chalmersmegagame.game.users.repository.UsersRepository;
import com.chalmersmegagame.game.users.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The class other classes are supposed to talk to when backend need to access users.
 */
@Component
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

}
