package com.example.ProductAuth.repository;

import com.example.ProductAuth.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData,Integer> {
    UserData findByusername(String username);
}
