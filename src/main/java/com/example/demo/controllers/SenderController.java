package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Attachment;
import com.example.demo.models.Sender;
import com.example.demo.repository.AttachementRepository;
import com.example.demo.repository.SenderRepository;


@CrossOrigin("*")
@RequestMapping("/iso/api/v1/Senders")
@RestController
public class SenderController {

	@Autowired
	private SenderRepository senderRepository;
	
	
	@PostMapping("/")
	public Sender create(@RequestBody Sender sender) {
		return  senderRepository.save(sender);
	}
	
	
}
