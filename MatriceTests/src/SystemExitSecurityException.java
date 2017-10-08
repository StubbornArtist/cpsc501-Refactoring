

public class SystemExitSecurityException extends SecurityException{
	private final int statusCode;
	
	public SystemExitSecurityException(final int statusCode){
		this.statusCode = statusCode;
	}
	
	public int getStatusCode(){
		return statusCode;
	}
}

