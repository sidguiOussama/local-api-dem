package com.example.demo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Message implements Serializable {
	
	@Id @GeneratedValue
	private int id;
 	private String body;
    private String discussionTypeChange;
    
    @ManyToOne
    @JoinColumn
    private Discussion discussion;
    
    private String externalReference;
    private String salesChannel;
    
    @ManyToOne
    @JoinColumn
    private Sender sender;
    
    @OneToMany(mappedBy="message")
    private List<Receiver> receivers = null;
    
    @OneToMany(mappedBy="message")
    private List<Attachment> attachments = null;
	    
	
	public Message() {
		super();
	}
	public Message(int id, String body, String discussionTypeChange, Discussion discussion, String externalReference,
				String salesChannel, Sender sender, List<Receiver> receivers, List<Attachment> attachments) {
			super();
			this.id = id;
			this.body = body;
			this.discussionTypeChange = discussionTypeChange;
			this.discussion = discussion;
			this.externalReference = externalReference;
			this.salesChannel = salesChannel;
			this.sender = sender;
			this.receivers = receivers;
			this.attachments = attachments;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDiscussionTypeChange() {
		return discussionTypeChange;
	}

	public void setDiscussionTypeChange(String discussionTypeChange) {
		this.discussionTypeChange = discussionTypeChange;
	}

	

	public Discussion getDiscussion() {
		return discussion;
	}
	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}
	
	public String getExternalReference() {
		return externalReference;
	}

	public void setExternalReference(String externalReference) {
		this.externalReference = externalReference;
	}

	public String getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}

	public Sender getSender() {
		return sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public List<Receiver> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<Receiver> receivers) {
		this.receivers = receivers;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", body=" + body + ", discussionTypeChange=" + discussionTypeChange
				+ ", discussion=" + discussion + ", externalReference=" + externalReference + ", salesChannel="
				+ salesChannel + ", sender=" + sender + ", receivers=" + receivers + ", attachments=" + attachments
				+ "]";
	}

	
	

}

