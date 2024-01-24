package com.crudproject.crudproject.repository;

import com.crudproject.crudproject.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepo extends JpaRepository<UserLogin, Long> {

}
