package com.glg3b7.trackticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glg3b7.trackticket.model.Ticket;
import com.glg3b7.trackticket.service.TicketService;

// Controller annotation indicates that this class is a Spring MVC Controller
@Controller
// RequestMapping at the class level specifies a common path prefix for all handler methods in this controller
@RequestMapping("/ticketrack")
public class TicketController {

	@Autowired
	private TicketService ticketService; // Injecting the TicketService

	// Method to handle requests to the home page
	@GetMapping("/home")
	public String homeTicket() {
		return "tracksys/home"; // Returns the home view
	}

	// Method to handle requests to list all tickets
	@GetMapping("/list")
	public String listTickets(Model model) {
		List<Ticket> tickets = ticketService.findAll(); // Fetches all tickets
		model.addAttribute("tickets", tickets); // Adds tickets to the model
		return "tracksys/list-ticket"; // Returns the list ticket view
	}

	// Method to show the form for adding a new ticket
	@GetMapping("/showTicketFormForAdd")
	public String showTicketFormForAdd(Model model) {
		Ticket theTicket = new Ticket(); // Creates a new ticket object
		model.addAttribute("ticket", theTicket); // Adds the ticket to the model
		return "tracksys/form-ticket"; // Returns the form view for adding a ticket
	}

	// Method to handle the submission of the ticket form
	@PostMapping("/saveTicket")
	public String saveTicket(Model model, @ModelAttribute Ticket ticket) {
		ticketService.saveTicket(ticket); // Saves the ticket
		return "redirect:/ticketrack/list"; // Redirects to the list view after saving the ticket
	}

	// Method to handle requests to view a specific ticket
	@GetMapping("/ticketFormForView/{id}")
	public String ticketFormForView(@PathVariable int id, Model model) {
		Ticket ticket = ticketService.findById(id); // Finds the ticket by ID
		model.addAttribute("ticket", ticket); // Adds the found ticket to the model
		return "tracksys/view-ticket"; // Returns the view ticket form
	}

	// Method to handle requests to edit a specific ticket
	@GetMapping("/ticketFormForEdit/{id}")
	public String ticketFormForEdit(@PathVariable int id, Model model) {
		Ticket ticket = ticketService.findById(id); // Finds the ticket by ID
		model.addAttribute("ticket", ticket); // Adds the found ticket to the model
		return "tracksys/edit-ticket"; // Returns the edit ticket form
	}

	// Method to handle the deletion of a ticket
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		ticketService.deleteById(id); // Deletes the ticket by ID
		return "redirect:/ticketrack/list"; // Redirects to the list view after deletion
	}

	// Method to handle search requests for tickets
	@GetMapping("/search")
	public String searchTickets(@RequestParam String query, Model model) {
		model.addAttribute("tickets", ticketService.searchTickets(query)); // Searches tickets based on the query and
																			// adds them to the model
		return "tracksys/list-ticket"; // Returns the list ticket view with the search results
	}
}
