package com.chalmersmegagame.users.service;

import java.util.List;

import com.chalmersmegagame.users.entity.Users;
import com.chalmersmegagame.users.repository.UsersRepository;
import org.springframework.stereotype.Component;

@Component
public class UsersService {
	
	private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }
    
    public Users saveUser(Users users) {
    	return usersRepository.save(users);
    }

}
