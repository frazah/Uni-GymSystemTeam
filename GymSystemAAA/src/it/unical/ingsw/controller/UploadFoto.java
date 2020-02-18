package it.unical.ingsw.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import it.mat.unical.ingsw.model.Admin;
import it.mat.unical.ingsw.model.Atleta;
import it.mat.unical.ingsw.model.Trainer;
import it.mat.unical.ingsw.model.Utente;
import it.mat.unical.persistence.DBManager;


@WebServlet("/UploadFoto")
public class UploadFoto extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String urlImmagine = request.getParameter("urlImmagine");
	    String mail = request.getParameter("nomeUtente");
	    
	    Utente utente = DBManager.getInstance().getUtenteDAO().findByPrimaryKey(mail);
	    
	    Atleta atleta = DBManager.getInstance().getAtletaDAO().findByPrimaryKey(mail);
	    
	    Trainer trainer = DBManager.getInstance().getTrainerDAO().findByPrimaryKey(mail);
	    	    
	    utente.setFotoProfilo(urlImmagine);
	    
	    DBManager.getInstance().getUtenteDAO().update(utente);
	    
	    //System.out.println();
		
	    if (atleta != null)	    
	    {
	    	System.out.println("sas");
	    	response.sendRedirect("profilo.jsp");
			System.out.println("sas2");
			
	    }
	    	//response.sendRedirect("profilo.jsp");
	    
	    else if (trainer != null)
	    {
	    	RequestDispatcher rd = request.getRequestDispatcher("profiloTrainer.jsp");
			rd.forward(request, response);
	    }
	    	
	    else
	    {
	    	RequestDispatcher rd = request.getRequestDispatcher("profiloAdmin.jsp");
			rd.forward(request, response);
	    }
	    	
	    
	   
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}
