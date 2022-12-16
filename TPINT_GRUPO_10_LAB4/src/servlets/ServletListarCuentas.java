package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class ServletListarCuentas
 */
@WebServlet("/ServletListarCuentas")
public class ServletListarCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final CuentaNegocioImpl cuentaNegocio = new CuentaNegocioImpl();
	private static final ClienteNegocioImpl cDao = new ClienteNegocioImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListarCuentas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		System.out.println("soy el " +usuario);
		Cliente cliente = cDao.buscarClientePorUsuario(usuario);
		System.out.println("Holiwis"+cliente);
		ArrayList<Cuenta> cuentas = cuentaNegocio.listarCuenta(cliente.getId()); // EL ID LO TOMARIA DE LA SESSION
		System.out.println(cliente);
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<div class=\"row\">");

		int numero = 1;
		for (Cuenta obj : cuentas) {
			TipoCuenta tipoCuenta= cuentaNegocio.buscarTipoCuentaPorId(obj.getTipoCuenta().getId());
			
			
			out.println("<div class=\"col\">"
					+ "<div class=\"card\" style=\"max-width: 18rem;\">\r\n" + 
					"			<div class=\"card-header\">"+tipoCuenta.getDescripcion().toUpperCase() +"</div>\r\n" + 
					"			<div class=\"card-body text-secondary\">\r\n" + 
					"				<h5 class=\"card-title\">Saldo $"+ obj.getSaldo()+"</h5>\r\n" + 
					"				<p class=\"card-text\"> CBU: "+obj.getCbu()+"</p>\r\n" + 
					"			<input name=\"numeroCuenta"+numero+"\" type=\"hidden\" value=\""+obj.getNumeroCuenta()+"\">"
							+ "<input name=\"idCliente\" type=\"hidden\" value=\""+obj.getId_cliente()+"\"></div>\r\n" + 
					"<button class=\"card-button\" name=\"btn"+numero+"\">DETALLE</button></div></div>");
			numero++;
		}

		out.println("</div></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
