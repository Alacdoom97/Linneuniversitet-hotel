package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLConnection 
{
	
	private Connection conn;
	Statement stmt = null;
	DatabaseMetaData meta;
	
	public static void main (String[] args)
	{
		SQLConnection sq = new SQLConnection();
		
		sq.CheckConnection();
	}
	
	public SQLConnection()
	{
		DBConnector();
		
		try {
			meta = conn.getMetaData();
			ResultSet tables = meta.getTables(null, null, "HotelDatabase", null);
			if(tables.next())
			{
				System.out.println("already exists");
			}
			else
			{
				createTable();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	 public ResultSet execute(String sqlQuery) {
	        if (conn == null)
	            DBConnector();
	        ResultSet rs = null;
	        try {
	            PreparedStatement stat = conn.prepareStatement(sqlQuery);
	            stat.execute();
	            rs = stat.getResultSet();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return rs;
	    }

	    public ResultSet executeWithParameters(String sqlQuery, ArrayList parameters) {
	        if (conn == null)
	            DBConnector();
	        ResultSet rs = null;
	        try {
	            PreparedStatement stat = conn.prepareStatement(sqlQuery);
	            for (int i = 1; i <= parameters.size(); i++) {
	                stat.setString(i, parameters.get(i - 1).toString());
	            }
	            stat.execute();
	            rs = stat.getResultSet();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return rs;
	    }

	    public ResultSet update(String sqlQuery) {
	        if (conn == null)
	            DBConnector();
	        ResultSet rs = null;
	        try {
	            PreparedStatement stat = conn.prepareStatement(sqlQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
	                    ResultSet.CONCUR_UPDATABLE);
	            stat.execute();
	            rs = stat.getResultSet();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return rs;
	    }
	
	private void DBConnector()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:HotelDatabase.db");		
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}  
	
	public void DBDisconnector()
	{
		try
		{
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void CheckConnection()
	{
		if(conn == null)
		{
			System.out.println("Not working!");
			System.exit(1);
		}
		else
			System.out.println("Working!");
	}
	
	private void createTable() 
	{
		try
		{
			stmt = conn.createStatement();
			String table = "CREATE TABLE `HotelDatabase` (\r\n" + 
					"	`companyName`	TEXT NOT NULL,\r\n" + 
					"	`name`	TEXT NOT NULL,\r\n" + 
					"	`lastname`	TEXT NOT NULL,\r\n" + 
					"	`adress`	TEXT NOT NULL\r\n" + 
					"	`dob`		TEXT NOT NULL\r\n" +
					")";
			stmt.executeUpdate(table);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
