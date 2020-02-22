package it.unical.ingsw.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import it.mat.unical.ingsw.model.Corso;
import it.mat.unical.ingsw.model.Trainer;
import it.mat.unical.ingsw.model.Utente;
import it.mat.unical.persistence.DBManager;

@WebServlet("/InfoCorso")
public class InfoCorso extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		    throws IOException{
		        resp.setContentType("text/html");
		        
		        String nomeCorso = req.getParameter("corso");
		        //System.out.println(nomeCorso);
		        
		        Corso corso = DBManager.getInstance().getCorsoDAO().findByPrimaryKey(nomeCorso);
		        //System.out.println(corso.getFasciaOraria());
		       
			    resp.getWriter().println("<div>");
			    resp.getWriter().println("<a style = \"color: white\">Giorni: " + mostraGiorni(corso.getGiorni()) + "</a>\n");
			    resp.getWriter().println("<br>");
			    resp.getWriter().println("<a style = \"color: white\">Fascia oraria: " + mostraOrario(corso.getFasciaOraria()) + "</a>\n");
			    resp.getWriter().println("</div>");
		        
		        
		    }

	private String mostraOrario(String fasciaOraria) {
		
		String orario = null;
		
		if (fasciaOraria.equals("1"))
			orario = "8.00-10.00";
		if (fasciaOraria.equals("2"))
			orario = "10.00-12.00";
		if (fasciaOraria.equals("3"))
			orario = "14.00-16.00";
		if (fasciaOraria.equals("4"))
			orario = "16.00-18.00";
		if (fasciaOraria.equals("5"))
			orario = "18.00-20.00";
		
		return orario;
	}

	private String mostraGiorni(String[] giorni) {
		String giornate = "";
		
		for (int i = 0; i < giorni.length; i++) {
			
			String giorno = null;
			
			if (giorni[i].equals("1"))
				giorno = "Lunedi'";
			if (giorni[i].equals("2"))
				giorno = "Martedi'";
			if (giorni[i].equals("3"))
				giorno = "Mercoledi'";
			if (giorni[i].equals("4"))
				giorno = "Giovedi'";
			if (giorni[i].equals("5"))
				giorno = "Venerdi'";
			if (giorni[i].equals("6"))
				giorno = "Sabato";
			
			
			giornate = giornate + " " + giorno;
			
		}
			
		
		return giornate;
		
	}
}

