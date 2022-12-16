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

import entidades.Cliente;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Provincia;
import entidades.TipoUsuario;
import negocio.ClienteNegocio;
import negocioImpl.ClienteNegocioImpl;

/**
 * Servlet implementation class ServletRegistrarCliente
 */
@WebServlet("/ServletRegistrarCliente")
public class ServletRegistrarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ClienteNegocio clienteNeg = new ClienteNegocioImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRegistrarCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("btnAceptar") != null) {
			// Cliente c =
			// clienteNeg.buscarClientePorUsuario(request.getParameter("usuario"));
			ArrayList<Cliente> clientes = clienteNeg.listarClientes();

			if (!clientes.stream().map(c -> c.getCuil())
					.anyMatch(cuil -> cuil == Long.parseLong(request.getParameter("cuil")))) {
				if (!clientes.stream().map(c -> c.getDni())
						.anyMatch(dni -> dni == Long.parseLong(request.getParameter("dni")))) {
					if (!clientes.stream().map(c -> c.getUsuario())
							.anyMatch(usuario -> usuario.equals(request.getParameter("usuario")))) {
						Provincia prov = new Provincia();
						Localidad loc = new Localidad();
						Nacionalidad nac = new Nacionalidad();
						Cliente cliente = new Cliente();
						cliente.setDni(Long.parseLong(request.getParameter("dni")));
						cliente.setNombre(request.getParameter("nombre"));
						cliente.setApellido(request.getParameter("apellido"));
						cliente.setCuil(Long.parseLong(request.getParameter("cuil")));
						cliente.setSexo(request.getParameter("sexo"));
						cliente.setFechaNac(Date.valueOf((request.getParameter("fechaNacimiento"))));
						cliente.setDireccion(request.getParameter("direccion"));
						loc.setId(Long.parseLong(request.getParameter("ddlLocalidad")));
						cliente.setLocalidad(loc);
						prov.setId(Long.parseLong(request.getParameter("ddlProvincia")));
						cliente.setProvincia(prov);
						nac.setId(Long.parseLong(request.getParameter("ddlNacionalidad")));
						cliente.setNacionalidad(nac);
						cliente.setMail(request.getParameter("mail"));
						cliente.setUsuario(request.getParameter("usuario"));
						cliente.setContrasenia(request.getParameter("password"));
						TipoUsuario tipoUsuario = clienteNeg.buscarTipoUsuarioPorId(2L);
						cliente.setTipoUsuario(tipoUsuario);

						if (clienteNeg.addCliente(cliente)) {
							String mensaje = "El cliente se registro existosamente";
							request.setAttribute("Mensaje", mensaje);
							RequestDispatcher rd = request.getRequestDispatcher("/RegistroCliente.jsp");
							rd.forward(request, response);
						}
					} else {
						String mensaje = "El nombre de usuario ingresado ya existe";
						request.setAttribute("Mensaje", mensaje);
						RequestDispatcher rd = request.getRequestDispatcher("/RegistroCliente.jsp");
						rd.forward(request, response);
					}
				} else {
					String mensaje = "El DNI ingresado ya existe";
					request.setAttribute("Mensaje", mensaje);
					RequestDispatcher rd = request.getRequestDispatcher("/RegistroCliente.jsp");
					rd.forward(request, response);
				}
			} else {
				String mensaje = "El CUIL ingresado ya existe";
				request.setAttribute("Mensaje", mensaje);
				RequestDispatcher rd = request.getRequestDispatcher("/RegistroCliente.jsp");
				rd.forward(request, response);
			}

		}

	}

}
