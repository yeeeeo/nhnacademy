package com.nhnacademy.residentmanage.repository;


import com.nhnacademy.residentmanage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}