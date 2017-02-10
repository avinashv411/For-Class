package com.jspiders.myjdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPoolManager 
{
	private Vector<Connection> pool = new Vector<Connection>();
	private String driverClass = "com.mysql.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost:3306/BJM27_DB";
	private String userNM = "j2ee";
	private String password = "j2ee";
	private int pool_size = 10;
	public static ConnectionPoolManager instance = null;
	
	public static ConnectionPoolManager getInstance() 
	throws Exception
	{
		if(instance==null){
			instance = new ConnectionPoolManager();
		}
		
		return instance;
	}
	
	private ConnectionPoolManager() 
	throws Exception
	{
		System.out.println("Creating the Connection Pool for the First Time ...");
		
		//1. Load the Driver
		Class.forName(driverClass).newInstance();
		
		for(int i=0; i<pool_size; i++){
			//2. Get the DB Connection via Driver
			Connection con = DriverManager.getConnection(dbUrl, userNM, password);
			pool.add(con);
		}//End of for
	}//End of Constructor
	
	public Connection getConnectionFromPool() 
	throws SQLException
	{
		System.out.println("Pool Size Before Getting the Connection : "+pool.size());
		
		Connection con = null;
		if(pool.size()>0){
			con = pool.get(0);
			pool.remove(0);
		}else{
			System.out.println("Opening new Connection");
			con = DriverManager.getConnection(dbUrl, userNM, password);
		}
		
		System.out.println("Pool Size After Getting the Connection : "+pool.size());
		return con;
	}
	
	public void returnConnectionToPool(Connection con) 
	throws SQLException
	{
		System.out.println("Pool Size Before Returning the Connection : "+pool.size());
		if(pool.size() < pool_size){
			pool.add(con);
		}else{
			System.out.println("Closing  the Connection");
			con.close();
		}
		
		System.out.println("Pool Size After Returning the Connection : "+pool.size());
	}
	
}//End of Class
