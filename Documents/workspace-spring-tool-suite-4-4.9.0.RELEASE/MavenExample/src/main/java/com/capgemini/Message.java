package com.capgemini;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="message")
@NamedQuery(name = "Message.getText", query = "Select m.text from Message m where m.id=:id")
public class Message {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	//@Basic(fetch = FetchType.LAZY)
	@Column(name="message_name", length= 20, nullable=false)
	private String text;

	
	public Message() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
		
	}
	

