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

@WebServlet("/GestioneCorsiAdmin")
public class GestioneCorsiAdmin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Corso> corsi = DBManager.getInstance().getCorsi();
		List<Trainer> trainer = DBManager.getInstance().getTrainer();
		request.getSession().setAttribute("trainer", trainer);
		request.getSession().setAttribute("corsi", corsi);
		
			RequestDispatcher rd = request.getRequestDispatcher("gestioneCorsiAdmin.jsp");
			rd.forward(request, response);
		
	
		
		
		
		

	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Corso> corsi = DBManager.getInstance().getCorsi();
		List<Trainer> trainer = DBManager.getInstance().getTrainer();
		request.getSession().setAttribute("trainer", trainer);
		request.getSession().setAttribute("corsi", corsi);
		
			RequestDispatcher rd = request.getRequestDispatcher("gestioneCorsiAdmin.jsp");
			rd.forward(request, response);
		
	
		
		
		
		

	}
	
	

}
