package com.example.midscheduleapp.user.Repository;


import com.example.midscheduleapp.user.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);


}
