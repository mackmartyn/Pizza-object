
public class IllegalPizza extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//when called elsewhere, provides a relevant error message called message
	public IllegalPizza (String message){
		super(message);
	}
	
	//constructor uses a generic default error message
	public IllegalPizza (){
		super("Attempt to create pizza with illegal data!");
	}
}

