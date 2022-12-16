package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import dao.ClienteDao;
import daoImpl.ClienteDaoImpl;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Prestamo;
import entidades.TipoMovimiento;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;
import entidades.Login;
import entidades.Movimiento;

/**
 * Servlet implementation class ServletSolicitarPrestamo
 */
@WebServlet("/ServletSolicitarPrestamo")
public class ServletSolicitarPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSolicitarPrestamo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteNegocioImpl cNeg = new ClienteNegocioImpl();
		Prestamo prestamo = new Prestamo();
				
		if(request.getParameter("btnSolicitarPrestamo")!=null) {
			
			prestamo.setCbu(Long.valueOf(request.getParameter("CBUPrestamo")));
			prestamo.setNroCuenta(Long.valueOf(request.getParameter("NumeroDeCuentaPrestamo")));
			prestamo.setIdCliente(Long.valueOf(request.getParameter("IDClientePrestamo")));
			prestamo.setFechaInicio(Date.valueOf(LocalDate.now()));
			
			request.setAttribute("PrestamoPrimero", prestamo);
			RequestDispatcher rd = request.getRequestDispatcher("/SolicitarPrestamo.jsp");
			rd.forward(request, response);
			
		}
		
		
		if(request.getParameter("btnConfirmarSolicitud")!=null) {
		
			prestamo.setCbu(Long.valueOf(request.getParameter("CBUPrestamo1")));
			prestamo.setNroCuenta(Long.valueOf(request.getParameter("NumeroDeCuentaPrestamo1")));
			prestamo.setIdCliente(Long.valueOf(request.getParameter("IDClientePrestamo1")));
			prestamo.setFechaInicio(Date.valueOf(request.getParameter("FechaInicio1")));
			

			prestamo.setCantCuotas(Integer.parseInt(request.getParameter("ddlCuotas")));
			prestamo.setMontoPrestado(Double.valueOf(request.getParameter("txtImporte")));
			
			prestamo.setMontoAdeudado(prestamo.getMontoPrestado()*((prestamo.getCantCuotas()/10.0)+1.0));
			prestamo.setCuotaMensual(prestamo.getMontoAdeudado()/prestamo.getCantCuotas());
			
			
			request.setAttribute("PrestamoSegundo", prestamo);
			RequestDispatcher rd = request.getRequestDispatcher("/ConfirmarPrestamo.jsp");
			rd.forward(request, response);
			
		}
		
		if(request.getParameter("btnConfirmarPrestamo")!=null) {
			
						
			prestamo.setAprobacion(false);
			prestamo.setEstado(true);
			
			prestamo.setIdCliente(Long.valueOf(request.getParameter("inputIDCliente")));
			prestamo.setCbu(Long.valueOf(request.getParameter("inputCBU")));
			prestamo.setNroCuenta(Long.valueOf(request.getParameter("inputNumeroDeCuenta")));
			prestamo.setCantCuotas(Integer.valueOf(request.getParameter("inputCuotas")));
			prestamo.setCuotaMensual(Double.valueOf(request.getParameter("inputImportePorCuotas")));
			prestamo.setMontoAdeudado(Double.valueOf(request.getParameter("inputMontoAdeudado")));
			prestamo.setMontoPrestado(Double.valueOf(request.getParameter("inputMontoPrestado")));
			prestamo.setFechaInicio(Date.valueOf(request.getParameter("inputFechaInicio")));
			
						
						
			boolean estado = cNeg.agregarPrestamo(prestamo);
			
			request.setAttribute("estadoPrestamo", estado);
			RequestDispatcher rd = request.getRequestDispatcher("/CartelPrestamo.jsp");
			rd.forward(request, response);
		}
		
		
		if(request.getParameter("btnVolverAlMenu")!=null) {
			RequestDispatcher rdp = request.getRequestDispatcher("/MenuPrincipalUsuario.jsp");
			rdp.forward(request,response);
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
