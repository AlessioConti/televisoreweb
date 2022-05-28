package it.prova.televisoreweb.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.televisoreweb.model.Televisore;
import it.prova.televisoreweb.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteInsertTelevisoreServlet
 */
@WebServlet("/ExecuteInsertTelevisoreServlet")
public class ExecuteInsertTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String marcaNuova = request.getParameter("marcaInput");
		String modelloNuovo = request.getParameter("modelloInput");
		int prezzoNuovo = Integer.parseInt(request.getParameter("prezzoInput"));
		int numeroPolliciNuovo = Integer.parseInt(request.getParameter("numeroPolliciInput"));
		String codiceNuovo = request.getParameter("codiceInput");
		
		Televisore televisoreInstance = new Televisore(marcaNuova, modelloNuovo, prezzoNuovo, numeroPolliciNuovo, codiceNuovo);
		
		try {
			MyServiceFactory.getTelevisoreService().inserisci(televisoreInstance);
			request.setAttribute("listTelevisoriAttributeName", MyServiceFactory.getTelevisoreService().listaTuttiTelevisori());
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
		rd.forward(request, response);
	}

}
