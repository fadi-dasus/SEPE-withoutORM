package com.data.dao.userDao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.data.model.user.User;





public interface UserDAO extends Remote
{
   
   public User create(String cpr, String name, String address)
         throws RemoteException;

   public User read(String cpr) throws RemoteException;

   public void delete(User user) throws RemoteException;

   public void update(User user) throws RemoteException;

}
