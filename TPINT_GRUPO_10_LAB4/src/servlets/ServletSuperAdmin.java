package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Admin;
import entidades.Cliente;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Provincia;
import entidades.TipoUsuario;
import negocio.ClienteNegocio;
import negocioImpl.AdminNegocioImpl;
import negocioImpl.ClienteNegocioImpl;

/**
 * Servlet implementation class ServletSuperAdmin
 */
@WebServlet("/ServletSuperAdmin")
public class ServletSuperAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final AdminNegocioImpl adminNeg = new AdminNegocioImpl();
	private static final ClienteNegocio clienteNeg = new ClienteNegocioImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSuperAdmin() {
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
		if (request.getParameter("btnAceptar") != null) {
			ArrayList<Admin> administradores = adminNeg.listarAdmin();
					if (!administradores.stream().map(c -> c.getUsuario())
							.anyMatch(usuario -> usuario.equals(request.getParameter("usuario")))) {
						Admin admin = new Admin();
						admin.setUsuario(request.getParameter("usuario"));
						admin.setContrasenia(request.getParameter("password"));
						admin.setMail(request.getParameter("mail"));
						TipoUsuario tipoUsuario = clienteNeg.buscarTipoUsuarioPorId(1L);
						admin.setTipoUsuario(tipoUsuario);
						admin.setEstado(true);
						
						admin.setSuperAdmin(false);
						
						if(request.getParameter("password").equals(request.getParameter("password2"))) {
							if (adminNeg.addAdmin(admin)) {
								String mensaje = "El Administrador se registro existosamente";
								request.setAttribute("Mensaje", mensaje);
								RequestDispatcher rd = request.getRequestDispatcher("/RegistrarAdmin.jsp");
								rd.forward(request, response);
							}
						}else {
								String mensaje = "Las contraseñas deben ser iguales";
								request.setAttribute("Mensaje", mensaje);
								RequestDispatcher rd = request.getRequestDispatcher("/RegistrarAdmin.jsp");
								rd.forward(request, response);
						}

						
					} else {
						String mensaje = "El nombre de usuario ingresado ya existe";
						request.setAttribute("Mensaje", mensaje);
						RequestDispatcher rd = request.getRequestDispatcher("/RegistrarAdmin.jsp");
						rd.forward(request, response);
					}

		}

	}

}
