package com.crudproject.crudproject.repository;

import com.crudproject.crudproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



    // Find user by username (note: this is just an example, not for production)
    User findByUsername(String username);

    // Find user by username and password (not recommended for production, use hashed passwords)
    User findByUsernameAndPassword(String username, String password);
}
