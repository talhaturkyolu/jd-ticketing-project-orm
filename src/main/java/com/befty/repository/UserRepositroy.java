package com.befty.repository;

import com.befty.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositroy extends JpaRepository<User, Long> {

    User findByUserName(String username);

}
