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

        User user = userRepositroy.findByUserName(userName);
        return userMapper.convertToDto(user);
    }

    @Override
    public void save(UserDTO dto) {

        User obj = userMapper.convertToEntity(dto);
        userRepositroy.save(obj);
    }

    @Override
    public UserDTO update(UserDTO dto) {
        //Find current user
        User user = userRepositroy.findByUserName(dto.getUserName());
        //Map update user dto to entity object
        User convertedUser = userMapper.convertToEntity(dto);
        //set id to the converted object
        convertedUser.setId(user.getId());
        //save updated user
        userRepositroy.save(convertedUser);

        return findByUserName(dto.getUserName());
    }

    @Override
    public void delete(String username) {
        User user = userRepositroy.findByUserName(username);
        user.setIsDeleted(true);
        userRepositroy.save(user);
    }

    //hard delete
    @Override
    public void deleteByUserName(String username) {
        userRepositroy.deleteByUserName(username);
    }
}
