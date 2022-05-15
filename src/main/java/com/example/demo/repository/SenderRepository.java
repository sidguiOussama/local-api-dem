package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Sender;

public interface SenderRepository extends JpaRepository<Sender, Integer> {

}
