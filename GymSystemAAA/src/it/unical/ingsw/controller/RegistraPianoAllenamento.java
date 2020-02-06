package it.unical.ingsw.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.mat.unical.ingsw.model.Atleta;
import it.mat.unical.ingsw.model.Corso;
import it.mat.unical.ingsw.model.Tessera;
import it.mat.unical.persistence.DBManager;

/**
 * Servlet implementation class RegistraPianoAllenamento
 */
@WebServlet("/RegistraPianoAllenamento")
public class RegistraPianoAllenamento extends HttpServlet {
	
	DBManager db = DBManager.getInstance();
	ArrayList<Corso> corsi = db.getCorsi();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Atleta utente = (Atleta) request.getSession().getAttribute("utente");
		ArrayList<String> list = new ArrayList<String>();
		
		String[] scelti = request.getParameterValues("boxes");
		Collections.addAll(list, scelti);
	    
	    if(list.size() != 3) {
	    	RequestDispatcher rd = request.getRequestDispatcher("choiceError.jsp");
			rd.forward(request, response);
	    }
	    else {
	    	ArrayList<Corso> corsiInserire = new ArrayList<Corso>();
		    
		    int x = 0;
		    for(Corso c : corsi) {
		    	if(x==3) {
		    		break;
		    	}
		    	
		    	for(String s : list) {
		    		System.out.println(s);
		    		if(s.contentEquals(c.getNome())) {
		    			corsiInserire.add(c);
		    			x++;
		    		}
		    	}
		    }
		    
		    LocalDateTime today =  LocalDateTime.now();
		    LocalDateTime scadenza = LocalDateTime.now();
		    if (utente.getTipoTessera().equals("mensile"))
		    	scadenza = today.plusMonths(1);
		    else if (utente.getTipoTessera().equals("semestrale"))
		    	scadenza = today.plusMonths(6);
		    else if (utente.getTipoTessera().equals("annuale"))
		    	scadenza = today.plusYears(1);
		    //scadenza = today.minusDays(10);
		    Tessera tessera = new Tessera(today, scadenza, corsiInserire);
		    utente.setTessera(tessera);
		    
		    RequestDispatcher rd = request.getRequestDispatcher("profilo.jsp");
			rd.forward(request, response);
	    }
	}

}