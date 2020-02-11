package it.unical.ingsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.mat.unical.ingsw.model.Corso;
import it.mat.unical.ingsw.model.Feedback;
import it.mat.unical.ingsw.model.Trainer;
import it.mat.unical.persistence.DBManager;

/**
 * Servlet implementation class ReindirizzaCorso
 */
@WebServlet("/ReindirizzaCorso")
public class ReindirizzaCorso extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List<Corso> corsi = DBManager.getInstance().getCorsi();
		List<Trainer> trainer = DBManager.getInstance().getTrainer();
	
	
		request.getSession().setAttribute("corsi", corsi);
		request.getSession().setAttribute("trainer", trainer);
		
		
		String nomeCorso = request.getParameter("corso");
		//System.out.println(nomeCorso);
		Corso corso = null;
		
		for(Corso c : corsi)
		{
			
			if(c.getNome().equals(nomeCorso))
				corso = c;
			
				
		}
		
		
		request.setAttribute("nomeCorso", corso.getNome());
		request.setAttribute("descrizione", corso.getDescrizione());
		request.setAttribute("linkVideo", corso.getLinkVideo());
		request.setAttribute("feedback", corso.getFeedback());
		request.setAttribute("mediaFeedback", corso.getMediaFeedback());
		
		
		
		boolean trovato = false;
		Trainer t = null;
		System.out.println(trainer.size());
		for(Trainer i : trainer)
		{
			if(i.getCorso()!= null && i.getCorso().getNome().equals(corso.getNome()))
			{
				trovato = true;
				t = i;
				
			}
		}
			

		
		
		if(t != null)
		{
			request.setAttribute("nomeTrainer", t.getNome());
			request.setAttribute("cognomeTrainer", t.getCognome());
			request.setAttribute("fotoTrainer", t.getFotoProfilo());
			request.setAttribute("mailTrainer", t.getMail());
		}
		else
		{
			request.setAttribute("nomeTrainer", "NESSUN");
			request.setAttribute("cognomeTrainer", "TRAINER ASSEGNATO");
			request.setAttribute("fotoTrainer", "immagini/shadow_person.png");
			request.setAttribute("mailTrainer", "null@null.bruh");
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("corso.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
