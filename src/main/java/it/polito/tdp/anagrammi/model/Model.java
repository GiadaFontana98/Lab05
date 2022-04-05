package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.db.DizionarioDao;

public class Model {
	DizionarioDao diz= new DizionarioDao();
	
	List<String>anagrammi= new LinkedList<>();
    public void anagramma(String s)
    {   anagrammi.clear();
    	anagrammaRicorsiva("",0,s);
    }

	public void anagrammaRicorsiva(String parziale, int l, String rimanenti) {
		// prima caso terminale 
		
		if(rimanenti.length()==0)
		{
			System.out.println(parziale);
			anagrammi.add(parziale);
		}
		else
		{
			//caso normale 
			//es:parziale="AC" , livello = 2, rimamenti "BD" dovrò costruire due sotto_parti parziali , i livelli sono per la posizione nei caratteri.
		     for(int pos=0;pos<rimanenti.length();pos++)
		     {
		    	 anagrammaRicorsiva(parziale+rimanenti.charAt(pos),l+1,rimanenti.substring(0,pos)+rimanenti.substring(pos+1));
		     }
		}
	}
	public List<String> parolegiuste(String s)
	{
		this.anagramma(s);
		return diz.getParolegiuste(anagrammi);
		
	}
	public List<String> parolesbagliate(String s)
	{
		this.anagramma(s);
		return diz.getParolesbagliate();
	}
}
