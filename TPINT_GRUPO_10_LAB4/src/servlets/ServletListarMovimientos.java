package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Movimiento;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;
import entidades.Cliente;
import entidades.Cuenta;

/**
 * Servlet implementation class ServletListarMovimientos
 */
@WebServlet("/ServletListarMovimientos")
public class ServletListarMovimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final MovimientoNegocioImpl movNegocio = new MovimientoNegocioImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarMovimientos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		PrintWriter out = response.getWriter();
		String CBU = request.getParameter("CBU");
		
		out.println("<html><body>");
		out.println("<div>");
	    ArrayList<Movimiento> movimientos = movNegocio.listarMovimientos(CBU);
	     
//	   request.setAttribute("listamov", movimientos);
//	   RequestDispatcher rd = request.getRequestDispatcher("/CuentaSeleccionada.jsp");
//	   rd.forward(request, response);
	   
	  
	    out.println("<label>Historial de movimientos: </label> <br> \r\n" + 
   			"<table border=\"1\" class=\"table table-striped\"> \r\n" + 
  			"<tr>\r\n" + 
   			" <th><b>FECHA OPERACION</b></th> \r\n" + 
   			"<th><b>CONCEPTO</b></th> \r\n" + 
  			" <th><b>IMPORTE</b></th> \r\n" + 
  			"<th><b>TIPO MOVIMIENTO</b></th> \r\n" + 
  			"\r\n" + 
   			"</tr>");	    
	    
	    for (Movimiento obj  : movimientos) {
	    	
	    	out.println("<tr>");
	         out.println("<td>"+obj.getFecha()+"</td>\r\n" + 
 			"<td>"+obj.getDetalle()+"</td>\r\n" + 
 			"<td>"+obj.getImporte()+"</td>\r\n" + 
    		"<td>"+obj.getTipoMovimiento().getDescripcion()+"</td> ");
    	
	        out.println("</tr>");
	}
   
	    out.println("</table></div></body></html>");
		
//		out.println("<html><body>");
//		out.println("<div class=\"row\">");
//		out.println("entre al ayax");
//		for(Movimiento obj : mov) {
//			
//			out.println("entre al for");
//			
//			out.println("<label>Historial de movimientos:</label> <br>\r\n" + 
//					"			<table border=\"1\" class=\"table table-striped\">\r\n" + 
//					"				<tr>\r\n" + 
//					"		\r\n" + 
//					"				\r\n" + 
//					"					<td><b>FECHA OPERACIÓN</b></td>\r\n" + 
//					"					<td><b>CONCEPTO</b></td>\r\n" + 
//					"					<td><b>IMPORTE</b></td>\r\n" + 
//					"					<td><b>TIPO MOVIMIENTO</b></td>\r\n" + 
//					"					\r\n" + 
//					"				</tr>\r\n" + 
//					"\r\n" + 
//					"				<tr>\r\n" + 
//					"				     <td>"+obj.getFecha()+"</td>\r\n" + 
//					"					<td>"+obj.getDetalle()+"</td>\r\n" + 
//					"					<td>"+obj.getImporte()+"</td>\r\n" + 
//					"					<td>"+obj.getTipoMovimiento().getDescripcion()+"</td>\r\n" + 
//					"					\r\n" + 
//					"					\r\n" + 
//					"				</tr>\r\n" + 
//					"			</table>");
//			
//			
//		}
//		
//		out.println("</div></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
