package com.client.Project.packageName;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn;
	public void ConnectToDB(String url,String username,String password) {
		try{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url,username,password);
		}catch(Exception e) {}
		}
	
	public ResultSet executeSelectQuery(String query) {
		ResultSet result=null;
		try {
			Statement stat=conn.createStatement();
			result=stat.executeQuery(query);
		}catch(Exception e) {}
		 return result;
	}

     public void CloseDB() {
	  try{
		conn.close();
	}catch(Exception e) {
	
	}
     }
}

