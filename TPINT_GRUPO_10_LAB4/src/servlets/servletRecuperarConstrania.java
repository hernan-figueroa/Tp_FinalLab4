package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Login;
import negocio.LoginNegocio;
import negocioImpl.LoginNegocioImpl;

/**
 * Servlet implementation class servletRecuperarConstrania
 */
@WebServlet("/servletRecuperarConstrania")
public class servletRecuperarConstrania extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletRecuperarConstrania() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginNegocio logNeg = new LoginNegocioImpl();
		if (request.getParameter("btnObtenerClave") != null) {

			Login UsuarioIngresado = new Login();
			String Mail = (request.getParameter("txtMail"));
			
			UsuarioIngresado = logNeg.VerificarLogin("RecuperarUsuario",null, null,Mail);
			
			if (UsuarioIngresado != null) {
				request.setAttribute("RecuperarClave", UsuarioIngresado);

			} else {
				request.setAttribute("MensajeOlvidoContrasenia", "No existe el usuario ingresado");
				
			}
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp?OlvidoContrasenia=true");
			rd.forward(request, response);
			
		}
	}

}
