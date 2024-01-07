package com.glg3b7.trackticket.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glg3b7.trackticket.model.Ticket;
import com.glg3b7.trackticket.repository.TicketRepository;

// Service annotation indicates that this class is part of the service layer,
// responsible for business logic and interactions with the repository layer
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository; // Injecting the TicketRepository

	@Override
	public List<Ticket> findAll() {
		return ticketRepository.findAll(); // Fetches all tickets from the repository
	}

	@Override
	public void saveTicket(Ticket theTicket) {

		if (theTicket.getId() == 0) {
			// New ticket
			LocalDateTime createdDateUtc = LocalDateTime.now();
			theTicket.setCreated(createdDateUtc);
		} else {
			// Existing ticket
			Ticket existingTicket = findById(theTicket.getId());
			theTicket.setCreated(existingTicket.getCreated()); // Retain original created date

			LocalDateTime updatedDateUtc = LocalDateTime.now(); // Update to current date
			theTicket.setUpdated(updatedDateUtc);
		}

		ticketRepository.save(theTicket); // Saves the ticket to the repository
	}

	@Override
	public Ticket findById(int id) {
		Optional<Ticket> result = ticketRepository.findById(id);
		if (result.isPresent()) {
			return result.get(); // Returns the found ticket
		} else {
			throw new RuntimeException("Ticket not found for ID: " + id); // Throws exception if ticket not found
		}
	}

	@Override
	public void deleteById(int id) {
		ticketRepository.deleteById(id); // Deletes the ticket by ID
	}

	@Override
	public List<Ticket> searchTickets(String searchTerm) {
		// Searches for tickets based on the search term in the title or short
		// description
		return ticketRepository.findByTitleContainingOrShortdescriptionContaining(searchTerm, searchTerm);
	}
}
