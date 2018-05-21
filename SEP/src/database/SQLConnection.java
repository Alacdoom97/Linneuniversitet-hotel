package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.Main;
import model.Guest;

public class SQLConnection {

	private Connection conn;
	Statement stmt = null;
	DatabaseMetaData meta;


	public SQLConnection() {
		DBConnector();

		try {
			meta = conn.getMetaData();
			ResultSet tables = meta.getTables(null, null, "GuestList", null);
			if (tables.next()) {
				// System.out.println("already exists");
			} else {
				createTable();
			}
		} catch (SQLException e) {
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
		DBDisconnector();
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
		DBDisconnector();
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

	public ArrayList<Guest> getGuestList() {
		String query = "SELECT * FROM GuestList";
		ArrayList<Guest> tempGuestList = new ArrayList<Guest>();
		Guest guest = null;
		ResultSet res = null;

		try {
			if (conn == null) {
				DBConnector();
			}

			Statement stat = conn.createStatement();
			res = stat.executeQuery(query);

			while (res.next()) {
				guest = new Guest();

				guest.setName(res.getString("companyName"));
				guest.setName(res.getString("name"));
				guest.setLastName(res.getString("lastname"));
				guest.setAdress(res.getString("adress"));
				guest.setPhone(res.getString("phoneNumber"));
				guest.setBirthday(res.getString("dateOfBirth"));
				Boolean boolean1 = Boolean.parseBoolean(res.getString("businessCheck"));
				guest.setBusiness(boolean1);
				Boolean boolean2 = Boolean.parseBoolean(res.getString("checkedIn"));
				guest.setCheckedIn(boolean2);

				tempGuestList.add(guest);
				
				DBDisconnector();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempGuestList;
	}

	private void DBConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:HotelDatabase.db");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void DBDisconnector() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void CheckConnection() {
		if (conn == null) {
			System.out.println("Not working!");
			System.exit(1);
		} else
			System.out.println("Working!");
	}

	private void createTable() {
		try {
			stmt = conn.createStatement();
			String table = "CREATE TABLE `GuestList` (\r\n" + "	`companyName`	TEXT NOT NULL,\r\n"
					+ "	`name`	TEXT NOT NULL,\r\n" + "	`lastname`	TEXT NOT NULL,\r\n"
					+ "	`adress`	TEXT NOT NULL,\r\n" + "	`phoneNumber`	TEXT NOT NULL,\r\n"
					+ "	`dateOfBirth`		TEXT NOT NULL,\r\n" + "	`businessCheck`		TEXT NOT NULL,\r\n"
					+ "	`checkedIn`		TEXT NOT NULL\r\n" + ")";
			stmt.executeUpdate(table);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
