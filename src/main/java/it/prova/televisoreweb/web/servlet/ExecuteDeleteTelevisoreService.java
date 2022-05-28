package it.prova.televisoreweb.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.televisoreweb.model.Televisore;
import it.prova.televisoreweb.service.MyServiceFactory;
import it.prova.televisoreweb.service.televisore.TelevisoreService;


@WebServlet("/ExecuteDeleteTelevisoreService")
public class ExecuteDeleteTelevisoreService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TelevisoreService televisoreServiceInstance = MyServiceFactory.getTelevisoreService();
		
		Long idPerDelete = Long.parseLong(request.getParameter("idAttributo"));
		List<Televisore> televisori = new ArrayList<Televisore>();
		try {
			Televisore temp = televisoreServiceInstance.cercaConId(idPerDelete);
			televisoreServiceInstance.elimina(temp);
			televisori = televisoreServiceInstance.listaTuttiTelevisori();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listTelevisoriAttributeName", televisori);
		RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
		rd.forward(request, response);
	}

}
