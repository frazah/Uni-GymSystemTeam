package it.unical.ingsw.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

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

@WebServlet("/CreaCorso")
public class CreaCorso extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Corso> corsi = DBManager.getInstance().getCorsi();
		ArrayList<Trainer> trainer = DBManager.getInstance().getTrainer();
		Trainer trainerAssegnato;
		Boolean corsoEsiste = false;
	
	
		request.getSession().setAttribute("corsi", corsi);
		request.getSession().setAttribute("trainer", trainer);
		
		String nomeCorso = request.getParameter("nome");
		String descCorso = request.getParameter("descrizione");
		String videoCorso = request.getParameter("linkVideo");
		String giorni [] = request.getParameterValues("giorno");
		String fasciaOraria = request.getParameter("fasciaOra");
		String trainerI = request.getParameter("trainer");
		Corso corsoCreato = new Corso(nomeCorso, null, null, fasciaOraria, giorni, descCorso, videoCorso, null);
		
		for (int i = 0; i < corsi.size(); i++) {
			
			String nomeCorsoParam = nomeCorso;
			String nomeCorsoArray = corsi.get(i).getNome();
			
			//trasformo le due stringhe in minuscolo per fare il confronto
			
			nomeCorsoParam = nomeCorsoParam.toLowerCase();
			nomeCorsoArray = nomeCorsoArray.toLowerCase();
			
			//System.out.println(nomeCorsoArray + " " + nomeCorsoParam);
			
			if (nomeCorsoArray.equals(nomeCorsoParam)) {
				corsoEsiste = true;
				
			}
				
		}
			
					
			
		if (!corsoEsiste) {
			
			if (trainerI == null)
				trainerAssegnato = null;
			else {
				int trainerIndex = Integer.parseInt(trainerI);
				trainerAssegnato = trainer.get(trainerIndex);
				trainerAssegnato.setCorso(corsoCreato);
				corsoCreato.setTrainer(trainerAssegnato);
			}

			corsi.add(corsoCreato);
			Utente utente = DBManager.getInstance().login("admin@admin.com", "admin");
			RequestDispatcher rd = request.getRequestDispatcher("gestioneCorsiAdmin.jsp");
			rd.forward(request, response);
		}
		else {
			Utente utente = DBManager.getInstance().login("admin@admin.com", "admin");
			request.setAttribute("nomeErrore","Corso già presente, è pregato di scegliere un altro nome.");
			RequestDispatcher rd = request.getRequestDispatcher("creaCorso.jsp");
			rd.forward(request, response);
		}
		
		/*for (int i = 0; i < giorni.length; i++)
			System.out.println(giorni[i]);
		
		System.out.println(nomeCorso + " " + descCorso + " " + videoCorso + " " + fasciaOraria + " " + trainerAssegnato);*/
		
		
		
		
		

	}

}
