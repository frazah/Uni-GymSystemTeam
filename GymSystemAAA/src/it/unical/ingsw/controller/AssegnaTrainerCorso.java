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

@WebServlet("/AssegnaTrainerCorso")
public class AssegnaTrainerCorso extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Corso> corsi = DBManager.getInstance().getCorsi();
		List<Trainer> trainer = DBManager.getInstance().getTrainer();
		ArrayList<Trainer> trainerDisponibili = new ArrayList<Trainer>();
		
		
		for(Trainer t : trainer)
		{
			if(t.getCorso() == null)
				trainerDisponibili.add(t);
		}
		
		Trainer trainerAssegnato;
		Corso corsoDaAssegnare = null;
	
	
		request.getSession().setAttribute("corsi", corsi);
		request.getSession().setAttribute("trainer", trainer);
		request.getSession().setAttribute("trainerDisponibili", trainerDisponibili);

		
		
		String trainerI = request.getParameter("trainer");
		String nomeCorso = request.getParameter("corso");
		
		//System.out.println(trainerI + " " + nomeCorso);
		
		for (int i = 0; i < corsi.size(); i++)
			if (nomeCorso.equals(corsi.get(i).getNome()))
					corsoDaAssegnare = corsi.get(i);
		
		if (trainerI == null)
			trainerAssegnato = null;
		else {
			int trainerIndex = Integer.parseInt(trainerI);
			trainerAssegnato = trainer.get(trainerIndex);
			trainerAssegnato.setCorso(corsoDaAssegnare);
			
		}
		
		
				
		
		
		
		Utente utente = DBManager.getInstance().login("admin@admin.com", "admin");
		
		RequestDispatcher rd = request.getRequestDispatcher("gestioneCorsiAdmin.jsp");
		rd.forward(request, response);

	}

}
