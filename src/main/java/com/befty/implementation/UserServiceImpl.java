package com.befty.implementation;

import com.befty.dto.UserDTO;
import com.befty.entity.User;
import com.befty.mapper.UserMapper;
import com.befty.repository.UserRepositroy;
import com.befty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepositroy userRepositroy;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserDTO> listAllUsers() {
        List<User> list = userRepositroy.findAll(Sort.by("firstName"));

        return list.stream().map(obj -> {return userMapper.convertToDto(obj);}).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String userName) {
        return null;
    }

    @Override
    public void save(UserDTO dto) {

        User obj = userMapper.convertToEntity(dto);
        userRepositroy.save(obj);
    }

    @Override
    public UserDTO update(UserDTO dto) {
        return null;
    }

    @Override
    public void delete(String username) {

    }
}
