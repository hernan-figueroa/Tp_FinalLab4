package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.ClienteDaoImpl;
import entidades.Cliente;
import entidades.Login;
import entidades.Usuario;
import negocio.LoginNegocio;
import negocioImpl.LoginNegocioImpl;

/**
 * Servlet implementation class servletLogin
 */
@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginNegocio logNeg = new LoginNegocioImpl();
		if (request.getParameter("btnIngresar") != null) {

			Login UsuarioIngresado = new Login();
			String Usuario = (request.getParameter("txtUsuario"));
			String Clave = (request.getParameter("txtClave"));
			
			UsuarioIngresado = logNeg.VerificarLogin("Login", Usuario, Clave,null);
			System.out.println(UsuarioIngresado);
			if (UsuarioIngresado != null) {
				request.getSession().setAttribute("NombreUsuario", UsuarioIngresado);
				if (UsuarioIngresado.getAdmin() == true) {
					response.sendRedirect("InformeEstadistico.jsp");
				} else {
					response.sendRedirect("MenuPrincipalUsuario.jsp");
				}
				
			} else {
				request.setAttribute("Mensaje", "Usuario Invalido");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
				rd.forward(request, response);
			}

		}

		if (request.getParameter("btnSalir") != null) {
			request.getSession().setAttribute("NombreUsuario", null);
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);
		}
		if (request.getParameter("btnRegistrarUsuario") != null) {
			response.sendRedirect("RegistroCliente.jsp");
			
		}
	}

}
