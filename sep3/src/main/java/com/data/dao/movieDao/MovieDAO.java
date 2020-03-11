package com.data.dao.movieDao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.data.model.movie.AbstractMovie;

public interface MovieDAO extends Remote {

	public AbstractMovie create(AbstractMovie movie) throws RemoteException;

	public AbstractMovie read(String name) throws RemoteException;

	public void delete(AbstractMovie movie) throws RemoteException;

	public ArrayList<AbstractMovie> getAllMovies()throws RemoteException, ClassNotFoundException, SQLException;

}