package it.unical.ingsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.mat.unical.ingsw.model.Atleta;
import it.mat.unical.ingsw.model.Utente;
import it.mat.unical.persistence.DBManager;

/**
 * Servlet implementation class IscriviAtleta
 */
@WebServlet("/IscriviAtleta")
public class IscriviAtleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IscriviAtleta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		//System.out.println(nome + cognome + username + password);
		
		Atleta atleta = new Atleta (nome,cognome,mail,password);
		
		DBManager.getInstance().registraUtente(atleta);
		
		request.getSession().setAttribute("utente", atleta);
		
		RequestDispatcher view = request.getRequestDispatcher("iscritto.jsp");
		view.forward(request, response);
	}

}
