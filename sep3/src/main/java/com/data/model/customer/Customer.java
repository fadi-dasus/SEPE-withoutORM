package com.data.model.customer;

import java.io.Serializable;

public class Customer implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private String name;
   private String address;
   private String cpr;

   public Customer(String name, String address, String cpr)
   {
      this.name = name;
      this.address = address;
      this.cpr = cpr;

   }

   public String getName()
   {
      return name;
   }

   public String getAddress()
   {
      return address;
   }

   public String getCpr()
   {
      return cpr;
   }

   @Override
   public String toString()
   {
      return "Customer [name=" + name + ", address=" + address + ", cpr=" + cpr
            + "]";
   }

}
