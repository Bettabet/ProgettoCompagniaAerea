package it.daniele.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import it.daniele.controller.ClienteServiceBeanLocal;
import it.daniele.model.Cliente;


@WebServlet(urlPatterns="/registrazione")
public class RegistrazioneServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	ClienteServiceBeanLocal clienteService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome= request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		Cliente cliente= new Cliente();
		cliente.setNome(nome);
		cliente.setCognome(cognome);
		cliente.setUsername(username);
		cliente.setPassword(password);

		try {
			clienteService.inserisci(cliente);
		}
		catch (jakarta.ejb.EJBTransactionRolledbackException e) {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.print("Username già utilizzato!");
			request.getRequestDispatcher("tornaAllaHome.html").include(request, response);
			out.close();
		}

	}

}
