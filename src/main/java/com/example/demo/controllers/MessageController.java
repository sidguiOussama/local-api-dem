package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
@RequestMapping("/iso/api/v1/messages")
@RestController
public class MessageController {

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
	
	
	@PostMapping("/{id}")
	public Message create(@RequestBody Message message,@PathVariable int id) {
		
		Discussion discussion = discussionRepository.getById(id);
		message.setDiscussion(discussion);
		
		/*----*/
		Sender sender = senderRepository.getById(Integer.parseInt(message.getSender().getUserId()));
		message.setSender(sender);
		/*----*/
		List<Receiver>receivers = new ArrayList<Receiver>();
		message.getReceivers().forEach(rec -> {
			Receiver r = receiverRepository.getById(Integer.parseInt(rec.getUserId()));
			receivers.add(r);
		});
		message.setReceivers(receivers);
		
		/*----*/
		List<Attachment>attachments = new ArrayList<Attachment>();
		message.getAttachments().forEach(att -> {
					Attachment a = attachementRepository.save(att);
					attachments.add(a);
		});
		message.setAttachments(attachments);
		
		/*----*/
		return  messageRepository.save(message);
	}
	
	@GetMapping("/{id}")
	public List<Message> retreiveAll(int id) {
		return messageRepository.findByDiscussionId(id);
	}
	
}
