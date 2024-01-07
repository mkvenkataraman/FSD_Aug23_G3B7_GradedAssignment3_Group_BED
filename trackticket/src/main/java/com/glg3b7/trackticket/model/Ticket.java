package com.glg3b7.trackticket.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// The Entity annotation marks this class as a JPA entity (i.e., a persistent Java class)
@Entity
public class Ticket {
	// The Id annotation marks the 'id' field as the primary key
	// The GeneratedValue annotation specifies how the primary key should be
	// generated
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Fields to store ticket information
	private String title;
	private String shortdescription;
	private String content;
	private LocalDateTime created;
	private LocalDateTime updated;

	// Default constructor for JPA
	public Ticket() {
		super();
		// The 'super()' call is optional and can be omitted
	}

	// Constructor with all fields
	public Ticket(String title, String shortdescription, String content, LocalDateTime created, LocalDateTime updated) {
		super(); // Calling the Object class constructor is optional
		this.title = title;
		this.shortdescription = shortdescription;
		this.content = content;
		this.created = created;
		this.updated = updated;
	}

	// Getters and setters for accessing the fields

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortdescription() {
		return shortdescription;
	}

	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

}
