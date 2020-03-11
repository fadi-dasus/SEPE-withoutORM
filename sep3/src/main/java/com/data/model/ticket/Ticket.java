package com.data.model.ticket;

import java.io.Serializable;

public class Ticket implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private String ticketNumber;
   private String movieName;
   private String customerName;
  
   
 
   
   public Ticket(String ticketNumber, String customerName,String movieName) {
      this.ticketNumber = ticketNumber;
      this.movieName = movieName;
      this.customerName  = customerName;
   }

   public String getTicketNumber()
   {
      return ticketNumber;
   }
   
   public String  getMovieName()
   {
      return movieName;
   }
   public String getCustoemrName() {
      return customerName;
   }

   @Override
   public String toString()
   {
      return "Tickt [ticketNumber=" + ticketNumber + ", movie=" + movieName
            + ", customer=" + customerName + "]";
   }

  
   

}
