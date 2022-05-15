package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Discussion;

public interface DiscussionRepository extends JpaRepository<Discussion, Integer> {

}
