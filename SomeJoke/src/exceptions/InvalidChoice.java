package exceptions;

public class InvalidChoice extends MyException {

	private static final long serialVersionUID = 1474524421109127546L;
	
	public InvalidChoice(String message){
		super();
		this.message = message;
	}

	@Override
	public void printMessage() {
		System.out.println(message);
	}
	
}
