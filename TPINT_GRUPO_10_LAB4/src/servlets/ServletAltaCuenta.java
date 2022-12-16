package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import entidades.Cuenta;
import entidades.Movimiento;
import entidades.TipoCuenta;
import entidades.TipoMovimiento;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;

@WebServlet("/ServletAltaCuenta")
public class ServletAltaCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final CuentaNegocioImpl cuentaNegocio = new CuentaNegocioImpl();

	ClienteNegocioImpl cliNeg = new ClienteNegocioImpl();
	
	public ServletAltaCuenta() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("btnAceptar") != null) {
			
			Long idCliente = Long.valueOf(request.getParameter("idCliente"));
			
			System.out.println(idCliente);
			
			Long idTipoCuenta = Long.valueOf(request.getParameter("ddlTipoUsuario"));
			TipoCuenta tipoCuenta = cuentaNegocio.buscarTipoCuentaPorId(idTipoCuenta);
			
			ArrayList<Cliente> clientes = cliNeg.listarClientes();
			boolean existeCliente = clientes.stream().map(c -> c.getId()).anyMatch(c -> c == idCliente);
			
			ArrayList<Cuenta> cuentas = cuentaNegocio.listarCuenta(idCliente);
			//boolean existeCuenta = cuentas.stream().map(c -> c.getId_cliente()).anyMatch(c -> c == idCliente);
			
			int cantCuentas = cuentas.size();


			Movimiento mov = new Movimiento();
			MovimientoNegocioImpl movNeg = new MovimientoNegocioImpl();
			TipoMovimiento tipMov = new TipoMovimiento();
			

			if (existeCliente) {
				if (cantCuentas < 3) {

					Double saldo = Double.valueOf(request.getParameter("saldo"));
					Long nroCuenta = cuentaNegocio.generarNroCuenta(idCliente);
					Cuenta cuenta = new Cuenta();
					cuenta.setId_cliente(idCliente);
					cuenta.setTipoCuenta(tipoCuenta);
					cuenta.setSaldo(saldo);
					cuenta.setNumeroCuenta(nroCuenta);
					cuenta.setFechaCreacion(Date.valueOf(request.getParameter("txtFecha")));
					Long cbu = (long) (Math.random() * 100000000000L) + idCliente + nroCuenta;
					cuenta.setCbu(cbu);

					if (cuentaNegocio.addCuenta(cuenta)) {

						
						String movS1 = "Alta";
						
						mov.setIdCliente(cuenta.getId_cliente());
						mov.setCBU( cuenta.getCbu());
						mov.setFecha(Date.valueOf(LocalDate.now()));
						mov.setImporte(10000.0);
						tipMov.setId(1L);
						mov.setTipoMovimiento(tipMov);
						
						movNeg.addMovimiento(mov, movS1);
						
						
						Cuenta cuentaCreada = cuentaNegocio.buscarCuentaPorId(cuenta.getId_cliente(),
								cuenta.getNumeroCuenta());

						request.setAttribute("Cuenta", cuentaCreada);
						RequestDispatcher rd = request.getRequestDispatcher("/AltaDeCuenta.jsp");
						rd.forward(request, response);
					}
				} else {
					String mensaje = "El cliente ya tiene el maximo de cuentas (3)";
					request.setAttribute("Mensaje", mensaje);
					RequestDispatcher rd = request.getRequestDispatcher("/AltaDeCuenta.jsp");
					rd.forward(request, response);
				}
			}else {
				String mensaje = "El id de cliente no existe";
				request.setAttribute("Mensaje", mensaje);
				RequestDispatcher rd = request.getRequestDispatcher("/AltaDeCuenta.jsp");
				rd.forward(request, response);
			}

		}
	}

}
