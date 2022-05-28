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

@WebServlet("/ExecuteUpdateTelevisoreServlet")
public class ExecuteUpdateTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String marcaInput = request.getParameter("marcaInput");
		String modelloInput = request.getParameter("modelloInput");
		Integer prezzoInput = Integer.parseInt(request.getParameter("prezzoInput"));
		Integer numeroPolliciInput = Integer.parseInt(request.getParameter("numeroPolliciInput"));
		String codiceInput = request.getParameter("codiceInput");
		
		try {
			Televisore televisoreDaID = MyServiceFactory.getTelevisoreService().cercaConId(Long.parseLong(request.getParameter("idTelevisore")));
			televisoreDaID.setMarca(marcaInput);
			televisoreDaID.setModello(modelloInput);
			televisoreDaID.setPrezzo(prezzoInput);
			televisoreDaID.setNumeroPollici(numeroPolliciInput);
			televisoreDaID.setCodice(codiceInput);
			
			MyServiceFactory.getTelevisoreService().aggiorna(televisoreDaID);
			
			request.setAttribute("listTelevisoriAttributeName", MyServiceFactory.getTelevisoreService().listaTuttiTelevisori());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
		rd.forward(request, response);
	}

}
