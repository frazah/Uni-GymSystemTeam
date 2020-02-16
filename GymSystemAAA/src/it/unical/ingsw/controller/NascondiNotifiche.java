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

@WebServlet("/NascondiNotifiche")
public class NascondiNotifiche extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		    throws IOException{
		        resp.setContentType("text/html");
		        
		        resp.getWriter().println("<div id = \"notifiche\" class = \"my-5 col-md-6\">");
		        resp.getWriter().println("<button type=\"button\" class=\"btn btn-primary\" onclick=\"mostraNotifiche()\">Mostra notifiche</button>");
		        resp.getWriter().println("</div>");
		    }
}

