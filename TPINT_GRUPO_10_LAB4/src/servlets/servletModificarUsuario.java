package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

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
 * Servlet implementation class servletModificarUsuario
 */
@WebServlet("/servletModificarUsuario")
public class servletModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ClienteNegocioImpl cDao = new ClienteNegocioImpl();   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cliente cliente= new Cliente();
		
		if(request.getParameter("txtFiltro")!=null)
		{ 
			cliente=cDao.listarCliente(Long.parseLong(request.getParameter("txtFiltro")));
			if(cliente!=null)
			{
			request.setAttribute("LabelMensaje", "");
			request.setAttribute("cliente", cliente);
			
			}
			else 
				{
				request.setAttribute("LabelMensaje", "El usuario ingresado no existe");
				request.setAttribute("cliente", null);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/ModificarUsuario.jsp");   
	        rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			Cliente cliente= new Cliente();
			Provincia prov= new Provincia();
			Localidad loc= new Localidad();
			Nacionalidad nac= new Nacionalidad();
			if(request.getParameter("btnActualizar")!=null)
			{ 
				boolean Actualizo;
				cliente.setId(Long.parseLong(request.getParameter("txtidUs")));
				cliente.setDni(Long.parseLong(request.getParameter("txtDni")));
				cliente.setNombre(request.getParameter("txtNombre"));
				cliente.setApellido(request.getParameter("txtApellido"));
				cliente.setCuil(Long.parseLong(request.getParameter("txtCuil")));
				cliente.setSexo(request.getParameter("txtSexo"));
				cliente.setFechaNac(Date.valueOf((request.getParameter("txtFechaNac"))));
				cliente.setDireccion(request.getParameter("txtDirec"));
				loc.setId(Long.parseLong(request.getParameter("ddlLocalidad")));
				cliente.setLocalidad(loc);
				prov.setId(Long.parseLong(request.getParameter("ddlProvincia")));
				cliente.setProvincia(prov);
				nac.setId(Long.parseLong(request.getParameter("ddlNacionalidad")));
				cliente.setNacionalidad(nac);
				cliente.setMail(request.getParameter("txtMail"));
				cliente.setUsuario(request.getParameter("txtUsuario"));
				cliente.setContrasenia(request.getParameter("txtContraseña"));
				
				Actualizo=cDao.updateCliente(cliente);
				request.setAttribute("Actualizo", Actualizo);
				
			}
			
			
			
		}catch(Exception e){
			request.setAttribute("Actualizo", false);
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("/ModificarUsuario.jsp");   
        rd.forward(request, response);
		}

		String usuario = request.getParameter("usuario");
		System.out.println(usuario);
		Cliente cliente = cDao.buscarClientePorUsuario(usuario);
		cliente.setNacionalidad(cDao.listarNacionalidad().stream().filter(nacionalidad-> nacionalidad.getId()==cliente.getNacionalidad().getId()).findFirst().get());
		cliente.setProvincia(cDao.listarProvincia().stream().filter(provincia-> provincia.getId()==cliente.getProvincia().getId()).findFirst().get());
		cliente.setLocalidad(cDao.listarLocalidad().stream().filter(localidad-> localidad.getId()==cliente.getLocalidad().getId()).findFirst().get());
		String direccion = cliente.getDireccion();
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<div class=\"row\">	<div class=\"row\">\r\n" + 
				"		<div class=\"col-4 p-2\">\r\n" + 
				"			<label class=\"\">IDUsuario:</label>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-4\">\r\n" + 
				"			<input type=\"text\" class=\"form-control\" readonly value="+cliente.getId()+">\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-4 p-2\">\r\n" + 
				"			<label class=\"\">DNI:</label>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-4\">\r\n" + 
				"			<input type=\"text\" class=\"form-control\" readonly value="+cliente.getDni()+">\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-4 p-2\">\r\n" + 
				"			<label class=\"\">CUIL:</label>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-4\">\r\n" + 
				"			<input type=\"number\" class=\"form-control\" readonly value="+cliente.getCuil()+">\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-4 p-2\">\r\n" + 
				"			<label class=\"\">Nombre:</label>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-4\">\r\n" + 
				"			<input type=\"text\" class=\"form-control\" readonly value="+cliente.getNombre()+">\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-4 p-2\">\r\n" + 
				"			<label class=\"\">Apellido:</label>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-4\">\r\n" + 
				"			<input type=\"text\" class=\"form-control\" readonly value="+cliente.getApellido()+">\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-4 p-2\">\r\n" + 
				"			<label class=\"\">SEXO:</label>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-4\">\r\n" + 
				"			<input type=\"text\" class=\"form-control\" readonly value="+cliente.getSexo()+">\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-4 p-2\">\r\n" + 
				"			<label class=\"\">FECHA NACIMIENTO:</label>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-4 \">\r\n" + 
				"			<input type=\"text\" class=\"form-control\" readonly value="+cliente.getFechaNac()+">\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-4 p-2\">\r\n" + 
				"			<label class=\"\">DIRECCION:</label>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-4\">\r\n" + 
				"			<input type=\"text\" class=\"form-control\" readonly value=\""+direccion+"\">\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-4 p-2\">\r\n" + 
				"			<label class=\"\">LOCALIDAD:</label>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-4\">\r\n" + 
				"			<input id=\"localidades\" class=\"form-control\" readonly value="+cliente.getLocalidad().getDescripcion()+">\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-4 p-2\">\r\n" + 
				"			<label class=\"\">PROVINCIA:</label>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-4\">\r\n" + 
				"			<input id=\"provincias\" class=\"form-control\" readonly value="+cliente.getProvincia().getDescripcion() +">\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-4 p-2\">\r\n" + 
				"			<label class=\"\">NACIONALIDAD:</label>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-4\">\r\n" + 
				"			<input id=\"nacionalidades\" readonly class=\"form-control\" value="+cliente.getNacionalidad().getDescripcion()+">\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-4 p-2\">\r\n" + 
				"			<label class=\"\">MAIL:</label>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-4\">\r\n" + 
				"			<input type=\"email\" class=\"form-control\" readonly value="+cliente.getMail()+">\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-4 p-2\">\r\n" + 
				"			<label class=\"\">NOMBRE DE USUARIO:</label>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-4\">\r\n" + 
				"			<input type=\"text\" class=\"form-control\" readonly value="+cliente.getUsuario()+">\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-4 p-2\">\r\n" + 
				"			<label class=\"\">CONTRASE&NtildeA:</label>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-4\">\r\n" + 
				"			<input type=\"password\" class=\"form-control\" readonly value="+cliente.getContrasenia()+">\r\n" + 
				"		</div>\r\n" + 
				"	</div>");
		
		out.println("</div></body></html>");
	}

}
