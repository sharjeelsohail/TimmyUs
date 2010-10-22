package cs.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;

//import security.BCrypt;
import cs.client.ValidateService;
import cs.client.ValidateServiceAsync;

public class TimmyMain implements EntryPoint {

	private final Label usernameLabel = new Label("Username: ");
	private final Label passwordLabel = new Label("Password: ");
	private final Label statusLabel = new Label();
	private final TextBox usernameField = new TextBox();
	private final PasswordTextBox passwordField = new PasswordTextBox();
	private final Button submitButton = new Button("Submit");
	
	//Panels
	private final VerticalPanel mainPanel = new VerticalPanel();
	private final HorizontalPanel usernamePanel = new HorizontalPanel();
	private final HorizontalPanel passwordPanel = new HorizontalPanel();
	private final HorizontalPanel submitPanel = new HorizontalPanel();
	private final HorizontalPanel statusPanel = new HorizontalPanel();
	
	//RPC Async Service
	private final ValidateServiceAsync validateRPC = GWT.create(ValidateService.class);
	
	public void onModuleLoad() {
		
		//The UI
		usernamePanel.setSpacing(5);
		usernamePanel.setVerticalAlignment(DockPanel.ALIGN_MIDDLE);
		usernamePanel.add(usernameLabel);
		usernamePanel.add(usernameField);
		
		passwordPanel.setSpacing(5);
		passwordPanel.setVerticalAlignment(DockPanel.ALIGN_MIDDLE);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordField);
		
		submitPanel.setSpacing(5);
		submitPanel.add(submitButton);
		
		statusPanel.setSpacing(5);
		statusPanel.add(statusLabel);
		
		mainPanel.setHorizontalAlignment(DockPanel.ALIGN_CENTER);
		mainPanel.add(usernamePanel);
		mainPanel.add(passwordPanel);
		mainPanel.add(submitPanel);
		mainPanel.add(statusPanel);
		
		RootPanel.get("main").setVisible(false);
		
		//LoginUI login = new LoginUI();
		RootPanel.get("login").add(mainPanel);
		
		
		//Button Event Handler
		submitButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				statusLabel.setText("Loading...");
				sendCredentials(usernameField.getText(), passwordField.getText());
			}
			
			//Sending the username and password to server
			private void sendCredentials(String username, String password){
				validateRPC.validatePassword(username, password, new AsyncCallback<String>(){
					public void onFailure(Throwable caught){
						statusLabel.setText("Error: Could not reach server");
					}
					public void onSuccess(String validated){
						if (validated.equals("true")){
							RootPanel.get("login").setVisible(false);
							RootPanel.get("main").setVisible(true);
						}
						else
							statusLabel.setText("Error: Incorrect username and/or password");
					}		
				});
			}
		});
	}
}
