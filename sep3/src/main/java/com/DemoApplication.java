package com;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws RemoteException, SQLException, NotBoundException {

		SpringApplication.run(DemoApplication.class, args);
	}
	

	    
}
