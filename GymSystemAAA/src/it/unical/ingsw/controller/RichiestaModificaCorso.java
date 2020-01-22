package it.unical.ingsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.mat.unical.ingsw.model.Utente;
import it.mat.unical.persistence.DBManager;


@WebServlet("/RichiestaModificaCorso")
public class RichiestaModificaCorso extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String messaggio = new String();
		String richiesta = new String();
				
		if(request.getParameter("scelta").equals("modifica"))
		{
			richiesta = "modifica";
		}
		else
		{
			richiesta = "esonero dal corso";
		}
		
		messaggio = "Richiesta di "+richiesta+"<br>"+"<br>";
		messaggio = messaggio.concat(request.getParameter("motivazioni")+"<br>"+"<br>");
		messaggio = messaggio.concat("inviato da : ");
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		String firma = utente.getNome() + " ";
		firma = firma.concat(utente.getCognome() + "<br>" + "<br>");
		messaggio = messaggio.concat(firma);
		/*if (messaggio.isEmpty())
			System.out.println("errore");*/
		//System.out.println(messaggio);
		
		DBManager.getInstance().getAdmin().getRichieste().add(messaggio);
		RequestDispatcher rd = request.getRequestDispatcher("profiloTrainer.jsp");
		rd.forward(request, response);
	}

}
