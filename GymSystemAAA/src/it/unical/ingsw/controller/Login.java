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

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object utente = request.getSession().getAttribute("utente");
		String isLogout = request.getParameter("logout");
		if (isLogout != null && isLogout.equals("true")) {
			request.getSession().removeAttribute("utente");
			RequestDispatcher rd = request.getRequestDispatcher("");
			rd.forward(request, response);
		}else {
			if (utente == null) {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("mail");
		String password = request.getParameter("password");
		
		Utente utente = DBManager.getInstance().login(username, password);
		if (utente != null) {
			request.getSession().setAttribute("utente", utente);
//			resp.sendRedirect(".");
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("loginErrorPage.html");
			rd.forward(request, response);
		}
	}

}
