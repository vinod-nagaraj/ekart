package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	Optional<List<User>> findBymobNum(String getmobNum);
	Optional<List<User>> findBymobNumandPassword(String mobNum, String password );

}
