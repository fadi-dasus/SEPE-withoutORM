package com.data.dao.customerDao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

import com.data.model.customer.Customer;

public interface CustomerDAO extends Remote {
	public Customer create(String cpr, String name, String address) throws RemoteException;

	public Customer read(String cpr) throws RemoteException, SQLException;

	public void delete(Customer customer) throws RemoteException;

	public void update(Customer customer) throws RemoteException;

}
