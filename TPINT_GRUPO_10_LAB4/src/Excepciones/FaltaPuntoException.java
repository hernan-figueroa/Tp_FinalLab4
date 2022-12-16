package Excepciones;

public class FaltaPuntoException extends RuntimeException{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Falta colocar un punto";
	}

}
