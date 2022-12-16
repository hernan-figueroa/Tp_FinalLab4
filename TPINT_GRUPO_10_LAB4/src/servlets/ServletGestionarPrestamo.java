package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import daoImpl.ClienteDaoImpl;
import entidades.Cliente;
import entidades.Movimiento;
import entidades.Prestamo;
import entidades.TipoMovimiento;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;

/**
 * Servlet implementation class ServletGestionarPrestamo
 */
@WebServlet("/ServletGestionarPrestamo")
public class ServletGestionarPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionarPrestamo() {
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
		ClienteNegocioImpl cNeg = new ClienteNegocioImpl();
		Movimiento mov = new Movimiento();
		MovimientoNegocioImpl movNeg = new MovimientoNegocioImpl();
		TipoMovimiento tipMov = new TipoMovimiento();
		
		if(request.getParameter("btnMostrarPrestamos")!=null) {
			Prestamo prestamo = new Prestamo();
			ArrayList<Prestamo> list = cNeg.listarPrestamos();
			
			request.setAttribute("listarPrestamos", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/GestionPrestamos.jsp");
			rd.forward(request, response);
		}
		
		
		String condicion = "";
		
		for(int i = 1; i<Integer.valueOf(request.getParameter("btnTamaño")) ; i++) {
		if(request.getParameter("btnAprobar"+i)!=null) {
			if(cNeg.AceptarPrestamos(Long.parseLong(request.getParameter("btnId"+i)))) {
				
					condicion = "Prestamo aprobado";	
					request.setAttribute("estado", condicion);
					
					String movS1 = "Prestamo";
					
					mov.setIdCliente(movNeg.buscarClientePorCBU(request.getParameter("btnSacarCbu"+i)));
					mov.setCBU( Long.valueOf(request.getParameter("btnSacarCbu"+i)));
					mov.setFecha(Date.valueOf(LocalDate.now()));
					mov.setImporte(Double.valueOf(request.getParameter("btnSacarMonto"+i)));
					tipMov.setId(2L);
					mov.setTipoMovimiento(tipMov);
					
					
					boolean estadoAceptar = movNeg.addMovimiento(mov, movS1);

					
					request.setAttribute("estadoAceptar", estadoAceptar);
					RequestDispatcher rd = request.getRequestDispatcher("/GestionPrestamos.jsp");
					rd.forward(request, response);
			}
		}}
		
		for(int i = 1; i<Integer.valueOf(request.getParameter("btnTamaño")) ; i++) {
		if(request.getParameter("btnDesaprobar"+i)!=null) {
			if(cNeg.DesaprobarPrestamo(Long.parseLong(request.getParameter("btnId"+i)))) {
				condicion = "Prestamo desaprobado";	
				request.setAttribute("estado", condicion);
				
				boolean estadoDesaprobar = true;
				
				request.setAttribute("estadoDesaprobar", estadoDesaprobar);
				RequestDispatcher rd = request.getRequestDispatcher("/GestionPrestamos.jsp");
				rd.forward(request, response);
			}
		}}
		/*if(request.getParameter("btnMostrarPrestamos")!= null) {
			ClienteDao cDao = new ClienteDaoImpl();
			ArrayList<Prestamo> list = cDao.listarPrestamos(null, null);
			
			request.setAttribute("listarPrestamos", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/GestionPrestamos.jsp");
			rd.forward(request, response);
		}*/
	}

}
