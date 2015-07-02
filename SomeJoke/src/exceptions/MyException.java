package exceptions;

public abstract class MyException extends RuntimeException{

	private static final long serialVersionUID = -7194471787090796806L;
	protected String message;
	
	public MyException(){
		
	}
	
	public abstract void printMessage();

}
