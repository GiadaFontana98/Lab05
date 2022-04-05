package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectdb {
	//Pattern ''simp..."
	public static Connection getConnection()
	{
		String url ="jdbc:mysql://localhost/iscritticorsi?user=root&password=root";
		try {
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("Ho un errore di connessione!");
			e.printStackTrace();//Dettaglio errori che sono capitati
			return null;
			//nel nostro database
		}
	}

}
