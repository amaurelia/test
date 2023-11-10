package com.dragondevelopers.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dragondevelopers.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    
}
