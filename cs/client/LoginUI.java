package cs.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginUI extends Composite {

	private static LoginUIUiBinder uiBinder = GWT.create(LoginUIUiBinder.class);

	interface LoginUIUiBinder extends UiBinder<Widget, LoginUI> {
	}

	@UiField
	HorizontalPanel usernamePanel;
	@UiField
	HorizontalPanel passwordPanel;
	@UiField
	HorizontalPanel submitPanel;
	@UiField
	HorizontalPanel statusPanel;
	
	@UiField
	Label usernameLabel;
	@UiField
	Label passwordLabel;
	@UiField
	Label statusLabel;
	@UiField
	TextBox usernameField;
	@UiField
	PasswordTextBox passwordField;
	@UiField
	Button submitButton;
	
	public LoginUI() {
		initWidget(uiBinder.createAndBindUi(this));
		
		usernamePanel.setSpacing(5);
		usernamePanel.setVerticalAlignment(DockPanel.ALIGN_MIDDLE);
		usernamePanel.add(usernameLabel);
		usernamePanel.add(usernameField);
		
		passwordPanel.setSpacing(5);
		passwordPanel.setVerticalAlignment(DockPanel.ALIGN_MIDDLE);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordField);
		
		submitPanel.setSpacing(10);
		submitPanel.add(submitButton);
		
		statusPanel.setSpacing(10);
		statusPanel.add(statusLabel);
		
		usernameLabel.setText("Username: ");
		passwordLabel.setText("Password: ");
				
		submitButton.setText("Submit");
	}

	/*@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}*/

}
