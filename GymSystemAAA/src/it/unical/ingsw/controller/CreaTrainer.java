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

import it.mat.unical.ingsw.model.Atleta;
import it.mat.unical.ingsw.model.Corso;
import it.mat.unical.ingsw.model.Trainer;
import it.mat.unical.ingsw.model.Utente;
import it.mat.unical.persistence.DBManager;

@WebServlet("/CreaTrainer")
public class CreaTrainer extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Corso> corsi = DBManager.getInstance().getCorsi();
		List<Trainer> trainer = DBManager.getInstance().getTrainer();
		List<Atleta> iscritti = DBManager.getInstance().getRegistrati();

		Boolean trainerEsiste = false;
	
	
		request.getSession().setAttribute("corsi", corsi);
		request.getSession().setAttribute("trainer", trainer);
		
		String nomeTrainer = request.getParameter("nome");
		String cognomeTrainer = request.getParameter("cognome");
		String mailTrainer = request.getParameter("mail");
		String passTrainer = request.getParameter("password");
		
		
		for (int i = 0; i < trainer.size(); i++) {
			
			String mailTrainerParam = mailTrainer;
			String mailTrainerArray = trainer.get(i).getMail();
			
			//trasformo le due stringhe in minuscolo per fare il confronto
			
			mailTrainerParam = mailTrainerParam.toLowerCase();
			mailTrainerArray = mailTrainerArray.toLowerCase();
		
			
			if (mailTrainerParam.equals(mailTrainerArray)) {
				trainerEsiste = true;
				
			}
				
		}
		
		for (int i = 0; i < iscritti.size(); i++) {
			
			String mailTrainerParam = mailTrainer;
			String mailTrainerArray = iscritti.get(i).getMail();
			
			//trasformo le due stringhe in minuscolo per fare il confronto
			
			mailTrainerParam = mailTrainerParam.toLowerCase();
			mailTrainerArray = mailTrainerArray.toLowerCase();
		
			
			if (mailTrainerParam.equals(mailTrainerArray)) {
				trainerEsiste = true;
				
			}
				
		}
						
		if (!trainerEsiste) {
			
			Trainer trainerRegistrato = new Trainer(nomeTrainer, cognomeTrainer, mailTrainer, passTrainer);
			
			DBManager.getInstance().getTrainerDAO().save(trainerRegistrato);
			Utente utente = DBManager.getInstance().login("admin@admin.com", "admin");
			RequestDispatcher rd = request.getRequestDispatcher("GestioneCorsiAdmin");
			response.sendRedirect("GestioneCorsiAdmin");
		}
		else {
			Utente utente = DBManager.getInstance().login("admin@admin.com", "admin");
			request.setAttribute("mailErrore","Mail gia' presente, e' pregato di scegliere un' altra mail.");
			RequestDispatcher rd = request.getRequestDispatcher("creaTrainer.jsp");
			
			rd.forward(request, response);
		}
		
		
		

	}

}
