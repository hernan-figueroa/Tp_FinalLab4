package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cuenta;
import entidades.Movimiento;
import entidades.TipoCuenta;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;

/**
 * Servlet implementation class ServletCuentaSeleccionada
 */
@WebServlet("/ServletCuentaSeleccionada")
public class ServletCuentaSeleccionada extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final CuentaNegocioImpl cuentaNegocio = new CuentaNegocioImpl();
	private static final MovimientoNegocioImpl movNegocio = new MovimientoNegocioImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCuentaSeleccionada() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long numeroCuenta=0L;
		
		if(request.getParameter("btn1")!=null) {
			numeroCuenta = Long.valueOf(request.getParameter("numeroCuenta1"));
		}else if(request.getParameter("btn2")!=null) {
			numeroCuenta = Long.valueOf(request.getParameter("numeroCuenta2"));
		}else {
			numeroCuenta = Long.valueOf(request.getParameter("numeroCuenta3"));
		}
		Long idCliente = Long.valueOf(request.getParameter("idCliente"));
		
		System.out.println("Soy yo, la cuenta: "+numeroCuenta);
		
		Cuenta cuenta = cuentaNegocio.buscarCuentaPorId(idCliente, numeroCuenta);
		TipoCuenta tipoCuenta= cuentaNegocio.buscarTipoCuentaPorId(cuenta.getTipoCuenta().getId());
		ArrayList<Movimiento> movimientos = movNegocio.listarMovimientos(cuenta.getCbu().toString());
		request.setAttribute("listamov", movimientos);
		request.setAttribute("tipoCuenta", tipoCuenta.getDescripcion());
		request.setAttribute("Cuenta", cuenta);			
		RequestDispatcher rd = request.getRequestDispatcher("/CuentaSeleccionada.jsp");
		rd.forward(request, response);
	}

}
