package com.data.model.customer;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerList implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   ArrayList<Customer> customers;

   public CustomerList()
   {
      customers = new ArrayList<Customer>();
   }

   public void addCustomer(Customer customer)
   {
      customers.add(customer);
   }

   public void removeCustomer(Customer customer)
   {
      customers.remove(customer);
   }

   public Customer getCustomreByName(Customer customer)
   {
      Customer temp = null;

      for (int i = 0; i < customers.size(); i++)
      {
         if (customer.getName().equals(customers.get(i).getName()))
         {
            temp = customers.get(i);
         }
      }

      return temp;

   }

}
