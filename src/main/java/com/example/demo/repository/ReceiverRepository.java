package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Receiver;

public interface ReceiverRepository extends JpaRepository<Receiver, Integer> {

}
