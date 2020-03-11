package com.web.controller;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.model.ticket.Ticket;
import com.web.BrokerClient;

@RestController
@RequestMapping("/sep3/ticket")
public class TicketController {
	private BrokerClient brokerClient;

	@Autowired
	public TicketController(BrokerClient brokerClient) {

		this.brokerClient = brokerClient;

	}

	@GetMapping("/{ticketNumber}")

	public Ticket readTicket(@PathVariable String ticketNumber) throws RemoteException {

		Ticket ticket = brokerClient.readTicket(ticketNumber);
		return ticket;

	}

	@PostMapping()
	public Ticket createTicket(@RequestBody Ticket ticket) throws RemoteException {
		Ticket createdticket = brokerClient.createTicket(ticket.getTicketNumber(), ticket.getCustoemrName(), ticket.getMovieName());
		return createdticket;

	}

	@DeleteMapping("/{ticketNumber}")
	public Ticket deleteTicket(@PathVariable String ticketNumber) throws RemoteException {

		Ticket ticket = brokerClient.readTicket(ticketNumber);
		brokerClient.deleteTicket(ticket);
		
		return ticket;
	}

}
