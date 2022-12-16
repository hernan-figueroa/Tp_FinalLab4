package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Prestamo;
import negocioImpl.ClienteNegocioImpl;

/**
 * Servlet implementation class ServletInformeEstadistico
 */
@WebServlet("/ServletInformeEstadistico")
public class ServletInformeEstadistico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ClienteNegocioImpl cNeg = new ClienteNegocioImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletInformeEstadistico() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Date inicio = Date.valueOf(request.getParameter("desde"));
		Date fin = Date.valueOf(request.getParameter("hasta"));

		ArrayList<Prestamo> prestamos = cNeg.listarPrestamos(inicio, fin);
		PrintWriter out = response.getWriter();
		
		if (prestamos !=null && !prestamos.isEmpty()) {
			out.println("<html><body><table class=\"table\">\r\n" + 
					"				<thead>\r\n" + 
					"					<tr>\r\n" + 
					"						<th scope=\"col\">#</th>\r\n" + 
					"						<th scope=\"col\">ID usuario</th>\r\n" + 
					"						<th scope=\"col\">Monto prestado</th>\r\n" + 
					"						<th scope=\"col\">Interes</th>\r\n" + 
					"					</tr>\r\n" + 
					"				</thead><tbody>");;
			for (Prestamo obj : prestamos) {
				Double interes = obj.getMontoAdeudado() - obj.getMontoPrestado();
				out.println("<tr>");
				out.println("<td scope=\"col\">" + obj.getIdPrestamo() + "</td>");
				out.println("<td scope=\"col\">" + obj.getIdCliente() + "</td>");
				out.println("<td scope=\"col\">" + obj.getMontoPrestado() + "</td>");
				out.println("<td scope=\"col\">" + interes + "</td>");
				out.println("</tr>");
			

			}
			double totalInteres= prestamos.stream()
				      .mapToDouble(o -> o.getMontoAdeudado()- o.getMontoPrestado())
				      .sum();
			double totalPrestado= prestamos.stream()
				      .mapToDouble(o ->o.getMontoPrestado())
				      .sum();
			
			out.println("</tbody></table><div class=\"row mt-5\">\r\n" + 
					"				<div class=\"col-3\">\r\n" + 
					"					<label class=\"col h6\">Total prestado:</label> <input\r\n" + 
					"						class=\"form-control\" value="+totalPrestado+" type=\"text\">\r\n" + 
					"				</div>\r\n" + 
					"				<div class=\"col-3\">\r\n" + 
					"					<label class=\"col h6\">Total intereses:</label> <input\r\n" + 
					"						class=\"form-control\" value=\""+totalInteres+"\" type=\"text\">\r\n" + 
					"				</div>\r\n" + 
					"				<div class=\"col-3\">\r\n" + 
					"					<label class=\"col h6\">Tasa:</label> <input class=\"form-control\"\r\n" + 
					"						value="+ Math.round(totalInteres/totalPrestado*100) +"% type=\"text\" readonly>\r\n" + 
					"				</div>\r\n" + 
					"			</div>");
			
			out.println("</body></html>");
			
		}else if(prestamos.isEmpty()) {
			out.println("<div class=\"alert alert-warning mt-2 text-center h5\" role=\"alert\">No hay prestamos para las fechas indicadas<div>");
			out.println("<br>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
