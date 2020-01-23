package it.unical.ingsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.mat.unical.ingsw.model.Feedback;
import it.mat.unical.persistence.DBManager;

/**
 * Servlet implementation class InviaFeedback
 */
@WebServlet("/InviaFeedback")
public class InviaFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InviaFeedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String testo = request.getParameter("testo");
		String voto = request.getParameter("voto");
		String autore = request.getParameter("mail");
		int v = Integer.parseInt(voto);
		//String corso = request.getParameter("nomeCorso");
		
		
		DBManager.getInstance().getCorsi().get(0).aggiungiFeedback(new Feedback(v,testo,autore));
	
		
		
		RequestDispatcher view = request.getRequestDispatcher("corsoPugilato.jsp");
		view.forward(request, response);
		
	}

}
