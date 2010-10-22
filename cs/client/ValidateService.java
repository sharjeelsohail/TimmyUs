package cs.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("validate")
public interface ValidateService extends RemoteService{
	String validatePassword (String username, String password);
}
