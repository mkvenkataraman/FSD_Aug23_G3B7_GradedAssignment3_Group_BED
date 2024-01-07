package com.glg3b7.trackticket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.glg3b7.trackticket.model.Ticket;

// Service annotation indicates that this interface is part of the service layer,
// which contains business logic and calls methods defined in the repository layer
@Service
public interface TicketService {

	// Method to find and return all Ticket entities
	// This method will retrieve all the tickets available in the database
	public List<Ticket> findAll();

	// Method to find a Ticket by its ID
	// This method will retrieve a specific ticket based on its unique ID
	public Ticket findById(int id);

	// Method to delete a Ticket by its ID
	// This method will remove a specific ticket from the database based on its ID
	public void deleteById(int id);

	// Method to search for Tickets based on a query string
	// This method is typically used to implement search functionality,
	// where 'query' can be part of the ticket's title or description
	public List<Ticket> searchTickets(String query);

	// Method to save a Ticket entity
	// This method will either create a new ticket or update an existing one,
	// depending on whether the ticket already exists (determined by its ID)
	public void saveTicket(Ticket theTicket);

}
