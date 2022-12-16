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
import entidades.TipoCuenta;
import negocioImpl.ClienteNegocioImpl;

/**
 * Servlet implementation class servletListarLocalidades
 */
@WebServlet("/servletListarLocalidades")
public class servletListarLocalidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ClienteNegocioImpl clienteNegocio = new ClienteNegocioImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListarLocalidades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Localidad> Localidad = clienteNegocio.listarLocalidad();
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<select name=\"ddlLocalidad\" class=\"form-select\" required>");
		String ddlLocalidades="--Seleccionar--";
		String ddlLocalidadValue="";
		out.println("<option selected value="+ddlLocalidadValue+">"+ddlLocalidades+"</option>");
		for (Localidad obj : Localidad) {
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
