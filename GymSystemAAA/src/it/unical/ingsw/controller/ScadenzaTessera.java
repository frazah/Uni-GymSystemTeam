package it.unical.ingsw.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.mat.unical.ingsw.model.Atleta;

/**
 * Servlet implementation class ScadenzaTessera
 */
@WebServlet("/ScadenzaTessera")
public class ScadenzaTessera extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Atleta atleta = (Atleta) request.getSession().getAttribute("utente"); 
		LocalDateTime today =  LocalDateTime.now();
		if (atleta.getTessera() != null && today.isAfter(atleta.getTessera().getDataDiScadenza()))
		{
			atleta.setTessera(null);
		}
		RequestDispatcher rd = request.getRequestDispatcher("profilo.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
