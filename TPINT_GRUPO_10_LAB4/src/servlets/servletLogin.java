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
		LoginNegocio logNeg = new LoginNegocioImpl();
		if (request.getParameter("btnIngresar") != null) {

			Login UsuarioIngresado = new Login();
			Long DNI = Long.parseLong(request.getParameter("txtDNI"));
			String Usuario = (request.getParameter("txtUsuario"));
			String Clave = (request.getParameter("txtClave"));
			UsuarioIngresado = logNeg.VerificarLogin(DNI, Usuario, Clave);
			if (UsuarioIngresado != null) {
				System.out.println(UsuarioIngresado);
				if (UsuarioIngresado.getAdmin() == true) {
					System.out.println("ES ADMIN");
					response.sendRedirect("InformeEstadistico.jsp");
				} else {
					System.out.println("NO ES ADMIN");
					response.sendRedirect("MenuPrincipalUsuario.jsp");
				}
				System.out.println("GUARDO SESSION");
				request.getSession().setAttribute("NombreUsuario", request.getParameter("txtUsuario"));
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
			response.sendRedirect("RegistroUsuario.jsp");
		}

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
