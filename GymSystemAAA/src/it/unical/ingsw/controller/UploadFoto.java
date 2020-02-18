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

import it.mat.unical.ingsw.model.Utente;
import it.mat.unical.persistence.DBManager;


@WebServlet("/UploadFoto")
public class UploadFoto extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String urlImmagine = request.getParameter("urlImmagine");
	    String mail = request.getParameter("nomeUtente");
	    
	    Utente utente = DBManager.getInstance().getUtenteDAO().findByPrimaryKey(mail);
	    
	    utente.setFotoProfilo(urlImmagine);
	    
	    DBManager.getInstance().getUtenteDAO().update(utente);
	    
	    DBManager.getInstance().login(mail, utente.getPassword());
		
	    if(utente.getClass().getSimpleName().equals("Atleta"))	    
	    	response.sendRedirect("profilo.jsp");
	    
	    else if (utente.getClass().getSimpleName().equals("Trainer"))
	    	response.sendRedirect("profiloTrainer.jsp");
	    	
	    else
	    	response.sendRedirect("profiloAdmin.jsp");
	    	
	    
		

	    
	    //System.out.println(urlImmagine+" "+mail);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}
