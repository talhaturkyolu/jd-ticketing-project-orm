package com.befty.implementation;

import com.befty.dto.RoleDTO;
import com.befty.entity.Role;
import com.befty.repository.RoleRepository;
import com.befty.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleDTO> listAllRoles() {

        List<Role> list = roleRepository.findAll();

        //convert to DTO and return it - why we need mapper

        return null;
    }

    @Override
    public RoleDTO findById(Long id) {
        return null;
    }
}
