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
import it.mat.unical.ingsw.model.Feedback;
import it.mat.unical.ingsw.model.Trainer;
import it.mat.unical.ingsw.model.Utente;
import it.mat.unical.persistence.DBManager;

@WebServlet("/MostraTuttiFeedback")
public class MostraTuttiFeedback extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		    throws IOException{
		        resp.setContentType("text/html");
		        String nomeCorso = req.getParameter("corso");
		        Corso corso = DBManager.getInstance().getCorsoDAO().findByPrimaryKey(nomeCorso);
		        
		        if (!corso.getFeedback().isEmpty())
		         {
		        	resp.getWriter().println("<div class = \"my-3\">");
		        	resp.getWriter().println("<h4>Elenco Feedback:</h4>");
		        	resp.getWriter().println("</div>");
		        	resp.getWriter().println(" <table class=\"table my-5 text-center\" >");
			        for (int i = 0;i<corso.getFeedback().size();i++)
			        {
			        	if(corso.getFeedback().get(i).getVoto() == 1)
			        		resp.getWriter().println("<th class='row'> "+ "VOTO : &#10032"+ "</th>");
			        	if(corso.getFeedback().get(i).getVoto() == 2) 
				        	resp.getWriter().println("<th class='row'> "+ "VOTO : &#10032 &#10032"+ "</th>");
			        	if(corso.getFeedback().get(i).getVoto() == 3)
				        	resp.getWriter().println("<th class='row'> "+ "VOTO : &#10032 &#10032 &#10032"+ "</th>");
			        	if(corso.getFeedback().get(i).getVoto() == 4)
				        	resp.getWriter().println("<th class='row'> "+ "VOTO : &#10032 &#10032 &#10032 &#10032"+ "</th>");
			        	if(corso.getFeedback().get(i).getVoto() == 5)
				        	resp.getWriter().println("<th class='row'> "+ "VOTO : &#10032 &#10032 &#10032 &#10032 &#10032"+ "</th>");
			        	
			        	
			        	
			        	resp.getWriter().println("<th class='row'> "+ "RECENSIONE : "+ corso.getFeedback().get(i).getTesto()+"</th>");
			        	resp.getWriter().println("<th class='row'> "+"</th>");
			        	//resp.getWriter().println("<div> <a>"+corso.getFeedback().get(i).getTesto()+"</a></div>" );
			        }
			       // resp.getWriter().println("<br> ");
			        resp.getWriter().println("</table> ");
		        }
		        
		       resp.getWriter().println("<div id = \"feedback\" class = \"my-5 text-center\">");
		       resp.getWriter().println("<button type=\"button\" class=\"btn btn-primary\" onclick=\"nascondiFeedback()\" id =\"nomeCorso\" value = "+nomeCorso+">Nascondi feedback</button>");
		       resp.getWriter().println("</div>");
		    }
}

