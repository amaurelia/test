package com.dragondevelopers.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dragondevelopers.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    
}
