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

@WebServlet("/Notifiche")
public class Notifiche extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		    throws IOException{
		        resp.setContentType("text/html");
		        List<String> notifiche = DBManager.getInstance().getAdmin().getRichieste();
		        resp.getWriter().println("<div class = \"my-3\">");
		        resp.getWriter().println("<h2>Richieste:</h2>");
		        resp.getWriter().println("</div>");
		        
		        if (notifiche.isEmpty())
		        	resp.getWriter().println("<a>Non ci sono richieste</a>");
		        else {
			        for (int i = 0;i<notifiche.size();i++)
			        {
			        	resp.getWriter().println("<b class = \"nMessaggio\" id = \"" + (i+1) +"\">Messaggio "+ (i+1) +"</b>");
			        	resp.getWriter().println("<div> <a class = \"messaggio\">"+notifiche.get(i)+"</a></div>" );
			        }
 
		        }
		        
		        resp.getWriter().println("<div id = \"notifiche\" class = \"my-5 col-md-6\">");
		        resp.getWriter().println("<button type=\"button\" class=\"btn btn-primary\" onclick=\"nascondiNotifiche()\">Nascondi notifiche</button>");
		        resp.getWriter().println("</div>");
		    }
}

