package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DizionarioDao {
	
     List<String>parolesbagliate = new ArrayList<String>();

	public List <String>getParolegiuste(List<String>parola)   //Pattern orm , per ogni tabella oltre ad avere un dao avro una classe java che modella il nostro programma 
	{ 
		
		String sql = "SELECT nome "
				+ "FROM dizionario.parola "
				+ "WHERE nome= ? ;";   
		
		List<String>result= new ArrayList<String>();
		try {
			Connection conn= Connectdb.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
		     for(String par : parola)
		     {
		     st.setString(1, par);
		     ResultSet rs= st.executeQuery();
		     if(rs.next())
			{
			     result.add(par);
			}
			else
			{
				parolesbagliate.add(par);
			}
			    
		     }
		     
		     
			st.close();
		
			conn.close();
		     
			return result;
			
		}
		catch(SQLException e)
		{
			System.err.println("Errore nel Dao ");
			e.printStackTrace();
			return null;
		}
		
		
	}

	public List<String> getParolesbagliate() {
		return parolesbagliate;
	}

	public void setParolesbagliate(List<String> parolesbagliate) {
		this.parolesbagliate = parolesbagliate;
	}
	
	
}

