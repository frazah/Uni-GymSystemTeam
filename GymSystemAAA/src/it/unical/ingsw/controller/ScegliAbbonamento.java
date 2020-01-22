package it.unical.ingsw.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.mat.unical.ingsw.model.Atleta;
import it.mat.unical.ingsw.model.Corso;
import it.mat.unical.persistence.DBManager;


@WebServlet("/ScegliAbbonamento")
public class ScegliAbbonamento extends HttpServlet {
	
	DBManager db = DBManager.getInstance();
	ArrayList<Corso> corsi = db.getCorsi();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("arraylist", corsi);

		String scelta = request.getParameter("scelta");
		System.out.println(scelta);
		Atleta utente = (Atleta) request.getSession().getAttribute("utente");
		utente.setTipoTessera(scelta);
		RequestDispatcher rd = request.getRequestDispatcher("sceltaPianoAllenamento.jsp");
		rd.forward(request, response);
	}

}
