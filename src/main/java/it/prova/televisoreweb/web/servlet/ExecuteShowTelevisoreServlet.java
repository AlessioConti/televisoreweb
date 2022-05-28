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
import it.prova.televisoreweb.service.televisore.TelevisoreService;

@WebServlet("/ExecuteShowTelevisoreServlet")
public class ExecuteShowTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametroDelTelevisorePerDettaglio = request.getParameter("idDaInviareComeParametro");
		
		TelevisoreService televisoreServiceInstance = MyServiceFactory.getTelevisoreService();
		Televisore result = new Televisore();
		try {
			result = televisoreServiceInstance.cercaConId(Long.parseLong(parametroDelTelevisorePerDettaglio));
			request.setAttribute("televisoreDaInviareAPaginaDettaglio", result);
			RequestDispatcher rd = request.getRequestDispatcher("dettaglio.jsp");
			rd.forward(request, response);
		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
