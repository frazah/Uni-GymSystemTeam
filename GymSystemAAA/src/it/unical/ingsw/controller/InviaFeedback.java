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
import it.mat.unical.ingsw.model.Feedback;
import it.mat.unical.ingsw.model.Trainer;
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
		
		ArrayList<Corso> corsi = DBManager.getInstance().getCorsi();
		ArrayList<Trainer> trainer = DBManager.getInstance().getTrainer();
	
	
		request.getSession().setAttribute("corsi", corsi);
		request.getSession().setAttribute("trainer", trainer);
		
		
		String nomeCorso = request.getParameter("nomeCorso");
		System.out.println(nomeCorso);
		Corso corso = null;
		
		for(Corso c : corsi)
		{
			if(c.getNome().equals(nomeCorso))
				corso = c;
		}
		
		
		
		request.setAttribute("nomeCorso", corso.getNome());
		request.setAttribute("descrizione", corso.getDescrizione());
		request.setAttribute("linkVideo", corso.getLinkVideo());
		
		
		
		
		if(corso.getTrainer() != null)
		{
			request.setAttribute("nomeTrainer", corso.getTrainer().getNome());
			request.setAttribute("cognomeTrainer", corso.getTrainer().getCognome());
			request.setAttribute("fotoTrainer", corso.getTrainer().getFotoProfilo());
			request.setAttribute("mailTrainer", corso.getTrainer().getMail());
		}
		else
		{
			request.setAttribute("nomeTrainer", "NESSUN");
			request.setAttribute("cognomeTrainer", "TRAINER ASSEGNATO");
			request.setAttribute("fotoTrainer", "immagini/shadow_person.png");
			request.setAttribute("mailTrainer", "null@null.bruh");
		}
		
		
		String testo = request.getParameter("testo");
		String voto = request.getParameter("voto");
		String autore = request.getParameter("mail");
	
		int v = Integer.parseInt(voto);
		//String corso = request.getParameter("nomeCorso");
		
		for(Corso c : DBManager.getInstance().getCorsi())
		{
			if(c.getNome().equals(nomeCorso))
				c.aggiungiFeedback(new Feedback(v,testo,autore));
		}
		
		
		request.setAttribute("feedback", corso.getFeedback());
		request.setAttribute("mediaFeedback", corso.getMediaFeedback());
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("corso.jsp");
		rd.forward(request, response);
		
		
		
		
	}

}
