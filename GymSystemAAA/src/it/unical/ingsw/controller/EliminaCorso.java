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

import it.mat.unical.ingsw.model.Atleta;
import it.mat.unical.ingsw.model.Corso;
import it.mat.unical.ingsw.model.Trainer;
import it.mat.unical.ingsw.model.Utente;
import it.mat.unical.persistence.DBManager;

@WebServlet("/EliminaCorso")
public class EliminaCorso extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Corso> corsi = DBManager.getInstance().getCorsi();
		ArrayList<Trainer> trainer = DBManager.getInstance().getTrainer();
		Trainer trainerAssegnato;
		ArrayList<Atleta> iscritti = DBManager.getInstance().getRegistrati();
		
		Corso corsoDaEliminare = null;
	
		request.getSession().setAttribute("corsi", corsi);
		request.getSession().setAttribute("trainer", trainer);
		
		String nomeCorso = request.getParameter("nome");
		
		//System.out.println(nomeCorso);
		
		for (int i = 0; i < corsi.size(); i++)
			if (nomeCorso.contentEquals(corsi.get(i).getNome()))
			{
				if (corsi.get(i).getTrainer() != null) {
					trainerAssegnato = corsi.get(i).getTrainer();
					trainerAssegnato.setCorso(null);
					corsi.get(i).setTrainer(null);
				}
					
				
				corsoDaEliminare = corsi.get(i);
				corsi.remove(i);
			}
		
		for(Atleta a : iscritti)
		{
			if(a.getTessera()!=null && corsoDaEliminare != null)
			{
				a.getTessera().getCorsi().remove(corsoDaEliminare);
				/*
				for(int i = 0; i < a.getTessera().getCorsi().size(); i++)
				{
					if(a.getTessera().getCorsi().get(i) == corsoDaEliminare)
					a.getTessera().getCorsi().remove(i);
				
				}
				*/
			}
		}
		
		
		
				
		
		
		
		Utente utente = DBManager.getInstance().login("admin@admin.com", "admin");
		
		RequestDispatcher rd = request.getRequestDispatcher("gestioneCorsiAdmin.jsp");
		rd.forward(request, response);

	}

}
