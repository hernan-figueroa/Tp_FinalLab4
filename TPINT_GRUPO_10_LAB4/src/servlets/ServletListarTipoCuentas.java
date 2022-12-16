package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.TipoCuenta;
import negocioImpl.CuentaNegocioImpl;

/**
 * Servlet implementation class ServletListarTipoUsuarios
 */
@WebServlet("/ServletListarTipoCuentas")
public class ServletListarTipoCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final CuentaNegocioImpl cuentaNegocio = new CuentaNegocioImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarTipoCuentas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TipoCuenta> tiposCuentas = cuentaNegocio.listarTipoCuenta();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<select name=\"ddlTipoUsuario\" class=\"form-select\">");
		
		for (TipoCuenta obj : tiposCuentas) {
			
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
