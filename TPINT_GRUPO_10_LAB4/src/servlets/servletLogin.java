package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Cliente;
import entidades.Usuario;
import dao.Dao;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btnIngresar")!=null)
		{
			
			Dao dao = new Dao();
			String DNI=request.getParameter("txtDNI");
			String NombreUsuario=request.getParameter("txtUsuario");
			String Clave=request.getParameter("txtClave");
			ArrayList<String> Mensaje= dao.VerificarLogin(DNI,NombreUsuario,Clave);
			
			
			

				if(Mensaje.get(0).equals("OK")) {
					System.out.println("GUARDO SESSION");
					request.getSession().setAttribute("NombreUsuario",request.getParameter("txtUsuario"));
					
					if(Integer.parseInt(Mensaje.get(1))==1)
					{
						System.out.println("ES ADMIN");
						response.sendRedirect("InformeEstadistico.jsp");
					}
					else {
						System.out.println("NO ES ADMIN");
						response.sendRedirect("MenuPrincipalUsuario.jsp");
					}
				}
				else {
					request.setAttribute("Mensaje", Mensaje.get(0));
					RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");   
			        rd.forward(request, response);
				}
				
		}
		
		
		if(request.getParameter("btnSalir")!=null)
		{ 
			request.getSession().setAttribute("NombreUsuario",null);
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");   
	        rd.forward(request, response);
		}
		if(request.getParameter("btnRegistrarUsuario")!=null)
		{ 
			response.sendRedirect("RegistroUsuario.jsp");
		}
		
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
