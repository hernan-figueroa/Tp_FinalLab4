package Excepciones;

public class FaltaArrobaException extends RuntimeException {

	public FaltaArrobaException() 
	{
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Falta colocar el arroba";
	}
}
