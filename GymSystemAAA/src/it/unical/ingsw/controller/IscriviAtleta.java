package it.unical.ingsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.mat.unical.ingsw.model.Atleta;
import it.mat.unical.ingsw.model.Corso;
import it.mat.unical.ingsw.model.Trainer;
import it.mat.unical.ingsw.model.Utente;
import it.mat.unical.persistence.DBManager;


@WebServlet("/IscriviAtleta")
public class IscriviAtleta extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Corso> corsi = DBManager.getInstance().getCorsi();
		List<Trainer> trainer = DBManager.getInstance().getTrainer();
		List<Atleta> iscritti = DBManager.getInstance().getRegistrati();
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		Boolean atletaEsiste = false;
		
		for (int i = 0; i < trainer.size(); i++) {
			
			String mailAtletaParam = mail;
			String mailTrainerArray = trainer.get(i).getMail();
			
			//trasformo le due stringhe in minuscolo per fare il confronto
			
			mailAtletaParam = mailAtletaParam.toLowerCase();
			mailTrainerArray = mailTrainerArray.toLowerCase();
		
			
			if (mailAtletaParam.equals(mailTrainerArray)) {
				atletaEsiste = true;
				
			}
				
		}
		
		for (int i = 0; i < iscritti.size(); i++) {
			
			String mailAteltaParam = mail;
			String mailAteltaArray = iscritti.get(i).getMail();
			
			//trasformo le due stringhe in minuscolo per fare il confronto
			
			mailAteltaParam = mailAteltaParam.toLowerCase();
			mailAteltaArray = mailAteltaArray.toLowerCase();
		
			
			if (mailAteltaParam.equals(mailAteltaArray)) {
				atletaEsiste = true;
				
			}
				
		}

		
		if (!atletaEsiste) {
			
			Atleta atleta = new Atleta (nome,cognome,mail,password);
			
			DBManager.getInstance().registraUtente(atleta);
			
			request.getSession().setAttribute("utente", atleta);
			
			RequestDispatcher view = request.getRequestDispatcher("iscritto.jsp");
			view.forward(request, response);
		}
		else {
			
			request.setAttribute("mailErrore","Mail gia' presente, e' pregato di scegliere un' altra mail.");
			RequestDispatcher rd = request.getRequestDispatcher("registrazione.jsp");
			
			rd.forward(request, response);
		}
	}

}
