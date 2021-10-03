package ec.com.exceptionhandling;

public class UserAllreadyExists extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAllreadyExists(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserAllreadyExists(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserAllreadyExists(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
