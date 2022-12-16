package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import negocioImpl.ClienteNegocioImpl;

/**
 * Servlet implementation class servletBajaCliente
 */
@WebServlet("/servletBajaCliente")
public class servletBajaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletBajaCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cli = null;
		ClienteNegocioImpl cNeg = new ClienteNegocioImpl();
		
		if(request.getParameter("txtDNIClienteListar")!=null) {
			
			Long id = Long.valueOf(request.getParameter("txtDNIClienteListar"));

			cli = cNeg.buscarCliente(id);
			System.out.println(cli);
			
			request.setAttribute("ClienteListado", cli);
			RequestDispatcher rd = request.getRequestDispatcher("/ClienteBajaLogica.jsp");
			rd.forward(request,response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cliente cli = null;
		ClienteNegocioImpl cNeg = new ClienteNegocioImpl();
		
		if(request.getParameter("confirmarAlta")!=null) {
			boolean estado=true;
			estado = cNeg.AltaCliente(Long.valueOf(request.getParameter("IDEliminar")));
			request.setAttribute("ClienteAgregado", estado);
		}
		
		if(request.getParameter("confirmarBaja")!=null) {

			boolean estado= false;
			
			estado = cNeg.deleteCliente(Long.valueOf(request.getParameter("IDEliminar")));
			
			System.out.println(String.valueOf(Long.valueOf(request.getParameter("IDEliminar")))); //ESTO FUNCA
			
			request.setAttribute("ClienteBorrado", estado);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("/ClienteBajaLogica.jsp");
		rd.forward(request,response);
	}
}