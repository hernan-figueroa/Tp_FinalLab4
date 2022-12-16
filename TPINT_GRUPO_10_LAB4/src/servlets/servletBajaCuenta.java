package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import entidades.Cuenta;
import entidades.TipoCuenta;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;

/**
 * Servlet implementation class servletBajaCuenta
 */
@WebServlet("/servletBajaCuenta")
public class servletBajaCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletBajaCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cuenta cu = null;
		Cliente cli = null;
		
		CuentaNegocioImpl cuNeg = new CuentaNegocioImpl();
		ClienteNegocioImpl cNeg = new ClienteNegocioImpl();		
		
		if(request.getParameter("btnListarCuenta")!=null) {
			
			Long id = Long.valueOf(request.getParameter("txtIDClienteCuenta"));
			Long numCuenta = Long.valueOf(request.getParameter("txtNumeroCuenta"));

			cli = cNeg.buscarCliente(id);
			cu = cuNeg.buscarCuentaPorId(id, numCuenta);
			
			request.setAttribute("ClienteListado", cli);
			request.setAttribute("CuentaListada", cu);
			
			RequestDispatcher rd = request.getRequestDispatcher("/CuentaBajaLogica.jsp");
			rd.forward(request,response);
		}
		
		if(request.getParameter("confirmarBajaCuenta")!=null)  {

			boolean estado= false;
			
			estado = cuNeg.deleteCuenta(Long.valueOf(request.getParameter("IDEliminarCuenta")), Long.valueOf(request.getParameter("NumCuentaEliminar")));
			
			
			request.setAttribute("CuentaBorrada", estado);
			RequestDispatcher rd = request.getRequestDispatcher("/CuentaBajaLogica.jsp");
			rd.forward(request,response);
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
