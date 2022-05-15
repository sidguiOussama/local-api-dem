package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Attachment;

public interface AttachementRepository extends JpaRepository<Attachment, Integer> {

	List<Attachment> findByIdAndMessageId(int Id,int MessageId);
	
	List<Attachment> findByMessageId(int id);
}
