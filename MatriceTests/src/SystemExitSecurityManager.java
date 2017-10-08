import java.security.Permission;


public class SystemExitSecurityManager extends SecurityManager {
	
	@Override
	public void checkExit(final int statusCode){
		throw new SystemExitSecurityException(statusCode);
		
	}
	
	@Override
	public void checkPermission(final Permission permission){}

}

