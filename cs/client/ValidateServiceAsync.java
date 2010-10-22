package cs.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ValidateServiceAsync {
	void validatePassword (String username, String password, AsyncCallback<String> callback);
}
