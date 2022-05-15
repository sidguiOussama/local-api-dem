package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Attachment  implements Serializable{
	@Id @GeneratedValue
	private int id;
 	private String content;
    private String attachmentName;
    private String fileFormat;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Message message;
    
    public Attachment(int id,String content, String attachmentName, String fileFormat) {
		super();
		this.id = id;
		this.content = content;
		this.attachmentName = attachmentName;
		this.fileFormat = fileFormat;
	}
    
    public Attachment(int id,String content, String attachmentName, String fileFormat,Message message) {
		super();
		this.id = id;
		this.content = content;
		this.attachmentName = attachmentName;
		this.fileFormat = fileFormat;
		this.message = message;
	}
	public Attachment() {}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAttachmentName() {
		return attachmentName;
	}
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	public String getFileFormat() {
		return fileFormat;
	}
	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Attachment [id=" + id + ", content=" + content + ", attachmentName=" + attachmentName + ", fileFormat="
				+ fileFormat + ", message=" + message + "]";
	}
	
	
}