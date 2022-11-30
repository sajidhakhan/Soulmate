package com.soulmatebackend.soulmateuserService.repository;

import com.soulmatebackend.soulmateuserService.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findUserByEmailAndPassword(String email, String password);
}
