package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Localidad;
import entidades.Provincia;
import negocioImpl.ClienteNegocioImpl;

/**
 * Servlet implementation class ServletListarProvincias
 */
@WebServlet("/ServletListarProvincias")
public class ServletListarProvincias extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ClienteNegocioImpl clienteNegocio = new ClienteNegocioImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarProvincias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Provincia> provincias = clienteNegocio.listarProvincia();
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<select name=\"ddlProvincia\" class=\"form-select\" required>");
		
		String ddlProvincia="--Seleccionar--";
		String ddlProvinciaValue="";
		out.println("<option selected value="+ddlProvinciaValue+">"+ddlProvincia+"</option>");
		for (Provincia obj : provincias) {
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
