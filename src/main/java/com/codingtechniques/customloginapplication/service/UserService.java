package com.codingtechniques.customloginapplication.service;

import com.codingtechniques.customloginapplication.dto.UserDto;
import com.codingtechniques.customloginapplication.model.User;

public interface UserService {
    User findByUsrname(String username);
    User save(UserDto userDto);
}
