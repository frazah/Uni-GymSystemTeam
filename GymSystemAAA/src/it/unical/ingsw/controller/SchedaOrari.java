package it.unical.ingsw.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.mat.unical.ingsw.model.Corso;
import it.mat.unical.persistence.DBManager;


@WebServlet("/SchedaOrari")
public class SchedaOrari extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Corso> corsi = DBManager.getInstance().getCorsi();
		request.getSession().setAttribute("corsi", corsi);
		
		RequestDispatcher rd = request.getRequestDispatcher("corsi.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
