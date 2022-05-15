package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Attachment;
import com.example.demo.repository.AttachementRepository;


@CrossOrigin("*")
@RequestMapping("/iso/api/v1/Attachements")
@RestController
public class AttachementController {

	@Autowired
	private AttachementRepository attachementRepository;
	
	@PostMapping("/")
	public Attachment create(@RequestBody Attachment attachment) {
		return  attachementRepository.save(attachment);
	}
	
	
	@GetMapping("/{id}")
	public List<Attachment> retreiveAll(@PathVariable int id) {
		return attachementRepository.findByMessageId(id);
	}
	
}
