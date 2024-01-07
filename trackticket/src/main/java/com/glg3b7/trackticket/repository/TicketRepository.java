package com.glg3b7.trackticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glg3b7.trackticket.model.Ticket;

// TicketRepository interface extending JpaRepository for basic CRUD operations and more
// JpaRepository<Ticket, Integer> indicates that this repository is for the Ticket entity
// and the primary key (id) of Ticket is of type Integer
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	// Custom query method to find tickets by title or short description
	// This method will be automatically implemented by Spring Data JPA based on its name
	// findByTitleContainingOrShortdescriptionContaining is a query creation method that will
	// search for tickets where the title contains the specified string or
	// the short description contains the specified string
	public List<Ticket> findByTitleContainingOrShortdescriptionContaining(String title, String shortdescription);
}
