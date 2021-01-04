package com.befty.mapper;

import com.befty.dto.RoleDTO;
import com.befty.dto.UserDTO;
import com.befty.entity.Role;
import com.befty.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User convertToEntity(UserDTO dto){
        return modelMapper.map(dto,User.class);
    }

    public UserDTO convertToDto(User entity){
        return modelMapper.map(entity,UserDTO.class);
    }
}
