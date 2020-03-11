package com.data.connection;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseHelper<T> {
	private static Connection connection = null;

	public DatabaseHelper() throws RemoteException, SQLException {

		connection = ConnectionManager.getInstance().getConnection();
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		} catch (SQLException e) {
			throw new RemoteException("No JDBC driver", e);
		}
	}

	private static PreparedStatement prepare(String sql, Object... parameters) throws SQLException {

		PreparedStatement stat = connection.prepareStatement(sql);
		for (int i = 0; i < parameters.length; i++) {
			stat.setObject(i + 1, parameters[i]);
		}
		return stat;
	}

	public ResultSet executeQuery(String sql, Object... parameters) throws SQLException {
		PreparedStatement stat = prepare(sql, parameters);
		return stat.executeQuery();
	}

	public int executeUpdate(String sql, Object... parameters) throws RemoteException {
		try {
			PreparedStatement stat = prepare(sql, parameters);
			return stat.executeUpdate();
		} catch (SQLException e) {
			throw new RemoteException(e.getMessage(), e);
		}
	}

	public T getSingle(DataMapper<T> mapper, String sql, Object... parameters) throws RemoteException {
		try {
			ResultSet rs = executeQuery(sql, parameters);
			if (rs.next()) {

				return mapper.create(rs);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RemoteException(e.getMessage(), e);
		}
	}
// take the security in consideration 

//	public ArrayList<T> executeQueryforList(DataMapper<T> mapper ,String sql) throws SQLException, RemoteException {
//		ArrayList<T> list = new ArrayList<>();
//		try {
//			PreparedStatement stat = preparefortheList(sql);
//
//			ResultSet rs = stat.executeQuery(sql);
//			while (rs.next()) {
//
//				list.add(mapper.create(rs));			
//			}}
//		catch (SQLException e) {}
//		System.out.println(list.size());
//		return list;
//		
//	}

	public ArrayList<T> getAll(DataMapper<T> mapper, String sql)
			throws ClassNotFoundException, SQLException, RemoteException {
		ArrayList<T> list = new ArrayList<>();

		try {

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(mapper.create(rs));
			}
		} catch (SQLException e) {
		}
		System.out.println(list.size());
		return list;
	}

}