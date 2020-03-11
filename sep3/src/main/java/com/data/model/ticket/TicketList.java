package com.data.model.ticket;

import java.io.Serializable;
import java.util.ArrayList;

public class TicketList implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   ArrayList<Ticket> tickets;

   public TicketList()
   {
      tickets = new ArrayList<>();
   }

   public void addTicket(Ticket ticket)
   {
      tickets.add(ticket);
   }

   public void removeTicket(Ticket ticket)
   {
      tickets.remove(ticket);
   }

   public Ticket getTicketNumber(Ticket ticket)
   {
      Ticket temp = null;

      for (int i = 0; i < tickets.size(); i++)
      {
         if (ticket.getTicketNumber().equals(tickets.get(i).getTicketNumber()))
         {
            temp = tickets.get(i);
         }
      }

      return temp;

   }

}
