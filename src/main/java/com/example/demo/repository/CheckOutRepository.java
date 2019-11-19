package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CheckOut;

public interface CheckOutRepository extends JpaRepository<CheckOut, Integer> {

}
