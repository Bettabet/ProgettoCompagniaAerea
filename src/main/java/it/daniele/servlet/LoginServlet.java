package it.daniele.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import it.daniele.controller.ClienteServiceBeanLocal;
import it.daniele.model.Cliente;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	ClienteServiceBeanLocal clienteService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		Cliente cliente= new Cliente();
		cliente.setUsername(username);
		cliente.setPassword(password);
		
		try{
			Cliente cliente2= clienteService.getCliente(cliente);
			if (cliente2==null) {
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.print("Password errata!");
				request.getRequestDispatcher("tornaAllaHome.html").include(request, response);
				out.close();
			}
			else {
				HttpSession session= request.getSession();
				session.setAttribute("nome", cliente2.getNome());
				session.setAttribute("cognome", cliente2.getCognome());
				session.setAttribute("username", cliente2.getUsername());
				request.getRequestDispatcher("clienteHome.jsp").forward(request, response);
			}
		}
		catch (jakarta.ejb.EJBException e) {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.print("Username non esistente!");
			request.getRequestDispatcher("tornaAllaHome.html").include(request, response);
			out.close();
		}
	}

}
