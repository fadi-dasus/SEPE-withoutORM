package com.data.dao.customerDao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.data.connection.DataMapper;
import com.data.connection.DatabaseHelper;
import com.data.model.customer.Customer;

import ch.qos.logback.core.net.SyslogOutputStream;




public class CustomerDAOService extends UnicastRemoteObject
      implements CustomerDAO
{
   /**
    *  
    */
   private static final long serialVersionUID = 1L;
   private DatabaseHelper<Customer> helper;

   public CustomerDAOService()
         throws RemoteException, SQLException
   {

      this.helper = new DatabaseHelper<Customer>();
   }

   private static class CustomerMapper implements DataMapper<Customer>
   {
     
      public Customer create(ResultSet rs) throws SQLException
      {
         String cpr = rs.getString("cpr");
         String name = rs.getString("name");
         String address = rs.getString("address");
         return new Customer(cpr, name, address);
      }
   }

   public Customer create(String cpr, String name, String address)
         throws RemoteException
   {
	   
      helper.executeUpdate("INSERT INTO Customer VALUES (?, ?, ?)", cpr, name,
            address);
      
      
      return new Customer(cpr, name, address);
   }

   public Customer read(String name) throws RemoteException, SQLException
   {
      CustomerMapper mapper = new CustomerMapper();
      Customer cust = helper.getSingle(mapper,
            "SELECT * FROM Customer WHERE name = ?;", name);


      return cust;
   
   }
   public void delete(Customer customer) throws RemoteException
   {
      helper.executeUpdate("DELETE FROM Customer WHERE cpr = ?",
            customer.getCpr());
   }

 
   public void update(Customer customer) throws RemoteException
   {
      helper.executeUpdate(
            "UPDATE Customer set name = ?, address = ? WHERE cpr = ?",
            customer.getName(), customer.getAddress(), customer.getCpr());
   }

}
