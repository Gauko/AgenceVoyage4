package m2tiil.agence.voyage.shared;

import java.io.Serializable;

public class ConnectionException extends Exception implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConnectionException(){
		super();
	}
	
	public ConnectionException(String message){
		super(message);
	}
	
	
	
}
