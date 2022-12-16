package servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Movimiento;
import entidades.Prestamo;
import entidades.TipoMovimiento;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;


/**
 * Servlet implementation class ServletPagarPrestamo
 */
@WebServlet("/ServletPagarPrestamo")
public class ServletPagarPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPagarPrestamo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteNegocioImpl cNeg = new ClienteNegocioImpl();
		Long CBU = null;
		Long IDPrestamo = null;
		Movimiento mov = new Movimiento();
		MovimientoNegocioImpl movNeg = new MovimientoNegocioImpl();
			
		if(request.getParameter("btnPagarPrestamo")!=null) {
				
			CBU = Long.valueOf(request.getParameter("CBUPrestamo"));
			
			System.out.println(CBU);
			
			ArrayList<Prestamo> listaPrestamo =  cNeg.listarPrestamosCBU(CBU);
			
			
			request.setAttribute("listaPrestamo", listaPrestamo);
			RequestDispatcher rd = request.getRequestDispatcher("/PagarPrestamo.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnPagarCuota")!=null) {
			
			boolean estado = false;
			
			IDPrestamo = Long.valueOf(request.getParameter("IDPrestamo"));
			TipoMovimiento tipMov = new TipoMovimiento();
			String movS = "Pago";
			
			mov.setCBU(Long.valueOf(request.getParameter("CBUPrestamo")));
			mov.setIdCliente(Long.valueOf(request.getParameter("IDCliente")));
			mov.setImporte(Double.valueOf(request.getParameter("Importe")));
			mov.setFecha(Date.valueOf(LocalDate.now()));
			tipMov.setId(3L);
			mov.setTipoMovimiento(tipMov);
			
			movNeg.addMovimiento(mov, movS);
			estado = cNeg.pagarCuotaPrestamo(IDPrestamo);
			
			
			request.setAttribute("estadoPago", estado);
			RequestDispatcher rd = request.getRequestDispatcher("/PagarPrestamo.jsp");
			rd.forward(request, response);
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
