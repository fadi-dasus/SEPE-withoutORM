package com.web;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.RMIserver.ServerRemote;
import com.data.model.customer.Customer;
import com.data.model.movie.AbstractMovie;
import com.data.model.ticket.Ticket;
import com.data.model.user.User;

@Service
public class BrokerClient extends UnicastRemoteObject {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	private ServerRemote server;

	@Autowired
	public BrokerClient() throws RemoteException, NotBoundException, SQLException, ClassNotFoundException {
		super();
		Registry registry = LocateRegistry.getRegistry(1099);
		this.server = (ServerRemote) registry.lookup("SR");
		System.out.println(" client is ready");
		System.out.println(server.getCustomerDAO().read("Me"));
		System.out.println(server.getMovieDAO().read("once"));
		ArrayList<AbstractMovie> list = new ArrayList<AbstractMovie>();
		list = 	server.getMovieDAO().getAllMovies();
		System.out.println(list.toString());

	}

	public Customer createCustomer(String cpr, String name, String address) throws RemoteException {
		return server.getCustomerDAO().create(cpr, name, address);
	}

	public Customer readCustomer(String cpr) throws RemoteException, SQLException {
		return server.getCustomerDAO().read(cpr);
	}

	public void deleteCustomer(Customer customer) throws RemoteException {

		server.getCustomerDAO().delete(customer);
	}

	public void updateCustomer(Customer customer) throws RemoteException {
		server.getCustomerDAO().update(customer);
	}

	public AbstractMovie createMovie(AbstractMovie movie) throws RemoteException {
		return server.getMovieDAO().create(movie);

	}

	public AbstractMovie readMovie(String name) throws RemoteException {
		return server.getMovieDAO().read(name);
	}

	public void deleteMovie(AbstractMovie movie) throws RemoteException {
		server.getMovieDAO().delete(movie);

	}

	public User createUser(String cpr, String name, String address) throws RemoteException {
		return server.getUserDAO().create(cpr, name, address);

	}

	public User readUser(String cpr) throws RemoteException {
		return server.getUserDAO().read(cpr);
	}

	public void deleteUser(User user) throws RemoteException {
		server.getUserDAO().delete(user);
	}

	public void updateUser(User user) throws RemoteException {
		server.getUserDAO().update(user);

	}

	public Ticket createTicket(String ticketNumber, String customerName, String movieName) throws RemoteException {
		return server.getTicketDAO().create(ticketNumber, customerName, movieName);
	}

	public Ticket readTicket(String ticketNumber) throws RemoteException {
		return server.getTicketDAO().read(ticketNumber);
	}

	public void deleteTicket(Ticket ticket) throws RemoteException {
		server.getTicketDAO().delete(ticket);
	}

	public ArrayList<AbstractMovie> getAllMovies() throws RemoteException, ClassNotFoundException, SQLException {
		 
		return server.getMovieDAO().getAllMovies();
	}

}