package servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;
import entidades.Movimiento;
import entidades.TipoMovimiento;

/**
 * Servlet implementation class ServletRealizarTransferencia
 */
@WebServlet("/ServletRealizarTransferencia")
public class ServletRealizarTransferencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRealizarTransferencia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CuentaNegocioImpl cuNeg = new CuentaNegocioImpl();
		MovimientoNegocioImpl movNeg = new MovimientoNegocioImpl();
		Movimiento mov = new Movimiento();
		Movimiento mov2 = new Movimiento();
		
		String cbuOrigen = null;
		String cbuDestino = null;
		String saldo = null;
		double monto = 0;
		String montoS = null;
		
		if(request.getParameter("btnIrRealizarTransferencia")!=null) {
			
			cbuOrigen = request.getParameter("CBUOrigen");
			saldo = request.getParameter("SaldoDisponible");
			
			request.setAttribute("CBUOrigen", cbuOrigen);
			request.setAttribute("SaldoDisponible", saldo);
			RequestDispatcher rd = request.getRequestDispatcher("/RealizarTransferencia.jsp");
			rd.forward(request,response);
		}
		
		if(request.getParameter("btnVolverAlMenu")!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("/MenuPrincipalUsuario.jsp");
			rd.forward(request,response);
		}
		
		if(request.getParameter("btnTrasnferencia")!=null) {
			
			//Parametros
			
			cbuDestino = request.getParameter("txtTransferenciaCBU");
			monto = Double.valueOf(request.getParameter("txtTransferenciaMonto"));
			cbuOrigen = request.getParameter("inputCBUO");
			saldo = request.getParameter("inputSaldo");

			if(cuNeg.checkCBU(cbuDestino)==false ) {
			
				String mensajeCBU = "CBU invalido";
					
				request.setAttribute("CBUOrigen", cbuOrigen);
				request.setAttribute("SaldoDisponible", saldo);
				request.setAttribute("CBUInvalido", mensajeCBU);
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/RealizarTransferencia.jsp");
				rd.forward(request,response);
				}
			
			else {
				
					if(cuNeg.CheckSaldo(cbuOrigen, monto)==false) {
						
						String mensajeMonto ="Monto invalido";
						
						request.setAttribute("CBUOrigen", cbuOrigen);
						request.setAttribute("SaldoDisponibl", saldo);
						request.setAttribute("MontoInvalido", mensajeMonto);
						RequestDispatcher rd = request.getRequestDispatcher("/RealizarTransferencia.jsp");
						rd.forward(request,response);
					}
					
					else {
						
						request.setAttribute("CBUOrigen", cbuOrigen);
						request.setAttribute("CBUDestino", cbuDestino);
						request.setAttribute("Monto", monto);
						RequestDispatcher rd = request.getRequestDispatcher("/ConfirmarTransferencia.jsp");
						rd.forward(request,response);
						
						}
			}
		}
		
		if(request.getParameter("btnConfirmarTransferencia")!=null) {
			
			boolean estadoTransferencia = true;
			
			cbuOrigen = request.getParameter("inputCBUO");
			cbuDestino = request.getParameter("inputCBUD");
			montoS = request.getParameter("inputMonto");
			TipoMovimiento tipMov = new TipoMovimiento();
			
			String movS2 = "Ingreso";
			String movS1 = "Egreso";
			
			mov.setIdCliente(movNeg.buscarClientePorCBU(cbuOrigen));
			mov.setCBU( Long.valueOf(cbuOrigen));
			mov.setFecha(Date.valueOf(LocalDate.now()));
			mov.setImporte(Double.valueOf(montoS));
			tipMov.setId(4L);
			mov.setTipoMovimiento(tipMov);
			
			
			mov2.setIdCliente(movNeg.buscarClientePorCBU(cbuDestino));
			mov2.setCBU( Long.valueOf(cbuDestino));
			mov2.setFecha(Date.valueOf(LocalDate.now()));
			mov2.setImporte(Double.valueOf(montoS));
			mov2.setTipoMovimiento(tipMov);
			
			
			movNeg.addMovimiento(mov, movS1);
			movNeg.addMovimiento(mov2, movS2);
						
			cuNeg.RealizarTransferencia("Transferir", cbuOrigen, cbuDestino, montoS);
			
			request.setAttribute("Estado", estadoTransferencia);
			RequestDispatcher rd = request.getRequestDispatcher("/ConfirmarTransferencia.jsp");
			rd.forward(request,response);
			
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
