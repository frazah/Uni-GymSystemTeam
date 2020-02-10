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

@WebServlet("/RimuoviTrainerCorso")
public class RimuoviTrainerCorso extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Corso> corsi = DBManager.getInstance().getCorsi();
		List<Trainer> trainer = DBManager.getInstance().getTrainer();
		Corso corsoAssegnato;
	
	
		request.getSession().setAttribute("corsi", corsi);
		request.getSession().setAttribute("trainer", trainer);
		
		String emailTrainer = request.getParameter("trainer");
		
		//System.out.println(emailTrainer);
		
		
		for (int i = 0; i < trainer.size(); i++)
			if (emailTrainer.contentEquals(trainer.get(i).getMail()))
			{
				corsoAssegnato = trainer.get(i).getCorso();
				trainer.get(i).setCorso(null);
			}
				
		
		
		
		Utente utente = DBManager.getInstance().login("admin@admin.com", "admin");
		
		RequestDispatcher rd = request.getRequestDispatcher("gestioneCorsiAdmin.jsp");
		rd.forward(request, response);

	}

}
