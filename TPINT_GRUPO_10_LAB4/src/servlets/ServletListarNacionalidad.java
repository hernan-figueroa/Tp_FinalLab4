package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Nacionalidad;
import entidades.Provincia;
import negocioImpl.ClienteNegocioImpl;

/**
 * Servlet implementation class ServletListarNacionalidad
 */
@WebServlet("/ServletListarNacionalidad")
public class ServletListarNacionalidad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ClienteNegocioImpl clienteNegocio = new ClienteNegocioImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarNacionalidad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Nacionalidad> nacionalidades = clienteNegocio.listarNacionalidad();
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<select name=\"ddlNacionalidad\" class=\"form-select\" required>");
		String ddlNacionalidad="--Seleccionar--";
		String ddlNacionalidadValue="";
		out.println("<option selected value="+ddlNacionalidadValue+">"+ddlNacionalidad+"</option>");
		for (Nacionalidad obj : nacionalidades) {
			out.println("<option value=" +obj.getId()+"> "+ obj.getDescripcion() + "</option>");
		}
		out.println("</select></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
