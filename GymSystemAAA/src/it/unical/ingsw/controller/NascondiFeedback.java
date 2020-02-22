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

@WebServlet("/NascondiFeedback")
public class NascondiFeedback extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		    throws IOException{
		        resp.setContentType("text/html");
		        String nomeCorso = req.getParameter("corso");
		        resp.getWriter().println("<div id = \"feedback\" class = \"my-5 text-center\">");
		        resp.getWriter().println("<button type=\"button\" class=\"btn btn-primary\" onclick=\"mostraFeedback()\" id =\"nomeCorso\" value = "+nomeCorso+">Mostra tutti i feedback</button>");
		        resp.getWriter().println("</div>");

		    }
}

