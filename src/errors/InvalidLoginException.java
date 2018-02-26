package errors;

public class InvalidLoginException extends Exception{	
	
	      // Parameterless Constructor
	      public InvalidLoginException() {}

	      // Constructor that accepts a message
	      public InvalidLoginException(String message)
	      {
	         super(message);
	      }
	 
}
