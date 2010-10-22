package cs.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cs.client.ValidateService;

@SuppressWarnings("serial")
public class Validate extends RemoteServiceServlet implements ValidateService{

	public String validatePassword(String username, String password) {
		if (username.equals("noor") && password.equals("molaj"))
			return "true";
		else
			return "false";
	}
}
