package com.data.model.user;

import java.io.Serializable;

public class User implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private String name;
   private String address;
   private String cpr;

   public User(String name, String address, String cpr)
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
      return "User [name=" + name + ", address=" + address + ", cpr=" + cpr
            + "]";
   }

}
