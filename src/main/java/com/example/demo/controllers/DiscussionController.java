package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Attachment;
import com.example.demo.models.Discussion;
import com.example.demo.models.Message;
import com.example.demo.models.Receiver;
import com.example.demo.models.Sender;
import com.example.demo.repository.AttachementRepository;
import com.example.demo.repository.DiscussionRepository;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.ReceiverRepository;
import com.example.demo.repository.SenderRepository;


@CrossOrigin("*")
@RequestMapping("/iso/api/v1/Discussions")
@RestController
public class DiscussionController {

	@Autowired
	private AttachementRepository attachementRepository;
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private DiscussionRepository discussionRepository;
	
	@Autowired
	private SenderRepository senderRepository;
	
	@Autowired
	private ReceiverRepository receiverRepository;
	
	
	@PostMapping("/")
	public Discussion create(@RequestBody Discussion discussion) {
		
		
		Message message = discussion.getMessage();
		/*----*/
		Sender sender = senderRepository.getById(Integer.parseInt(message.getSender().getUserId()));
		message.setSender(sender);
		/*----*/
		
		/*----*/
		List<Attachment>attachments = new ArrayList<Attachment>();
		message.getAttachments().forEach(att -> {
					Attachment a = attachementRepository.save(att);
					attachments.add(a);
		});
		message.setAttachments(attachments);
		
		/*----*/
		Message m = messageRepository.save(message);
		
		List<Receiver>receivers = new ArrayList<Receiver>();
		message.getReceivers().forEach(rec -> {
			Receiver r = receiverRepository.getById(Integer.parseInt(rec.getUserId()));
			r.setMessage(message);
			receivers.add(r);
		});
		message.setReceivers(receivers);
		discussion.setMessage(m);
		return  discussionRepository.save(discussion);
	}
	
	
	@GetMapping("/")
	public List<Discussion>  retreiveAll(){
		return discussionRepository.findAll();
	}
	
	
}
