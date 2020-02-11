package it.unical.ingsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.mat.unical.ingsw.model.Admin;
import it.mat.unical.ingsw.model.Utente;
import it.mat.unical.persistence.DBManager;

/**
 * Servlet implementation class RichiestaNuovoCorso
 */
@WebServlet("/RichiestaNuovoCorso")
public class RichiestaNuovoCorso extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String messaggio = new String();
		
		messaggio = "Richiesta di inserimento di un nuovo corso"+"<br>"+"<br>";
		messaggio = messaggio.concat("Il codice del mio titolo di abilitazione all'insegnamento è : ");
		messaggio = messaggio.concat(request.getParameter("codice")+"<br>"+"<br>");
		messaggio = messaggio.concat("Perché : ");
		messaggio = messaggio.concat(request.getParameter("motivazioni")+"<br>"+"<br>");
		messaggio = messaggio.concat("Il nome del corso sarà : ");
		messaggio = messaggio.concat(request.getParameter("nome")+"<br>"+"<br>");
		messaggio = messaggio.concat("inviato da : ");
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		String firma = utente.getNome() + " ";
		firma = firma.concat(utente.getCognome() + "<br>" + "<br>");
		messaggio = messaggio.concat(firma);
		/*if (messaggio.isEmpty())
			System.out.println("errore");*/
		//System.out.println(messaggio);
		
		Admin admin = DBManager.getInstance().getAdmin();
		admin.getRichieste().add(messaggio);
		DBManager.getInstance().aggiornaAdmin(admin);
		RequestDispatcher rd = request.getRequestDispatcher("profiloTrainer.jsp");
		rd.forward(request, response);
	}

}
