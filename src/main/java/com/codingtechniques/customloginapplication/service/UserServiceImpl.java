package com.codingtechniques.customloginapplication.service;

import com.codingtechniques.customloginapplication.dto.UserDto;
import com.codingtechniques.customloginapplication.model.User;
import com.codingtechniques.customloginapplication.repositories.UserRepository;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsrname(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getUsername(), userDto.getPassword(), userDto.getFullname());
        return userRepository.save(user);
    }
}
