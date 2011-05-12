package main.java.com.owfg.facade.bb.StoreManagement.gui;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Manager;

public class LoginFieldManager extends Manager {
	final int ofgLogo = 0;
	final int usernameText = 1;
	final int usernameEditField = 2;
	final int passwordText = 3;
	final int passwordEditField  = 4;
	final int okButton = 5;
	
	final int offsetXOne = 60;
	final int offsetXTwo = 148;
	final int offsetYOne = 80;
	final int offsetYtwo = 110;

	protected LoginFieldManager(long style) {
		super(style);
	}

	protected void sublayout(int width, int height) {
		Field field;
		
		field = getField(ofgLogo); // get the field
		setPositionChild(field, 120, 0); // set the position for the field
		layoutChild(field, width, height);

		field = getField(usernameText);
		setPositionChild(field, offsetXOne, offsetYOne);
		layoutChild(field, width, height);
		
		field = getField(usernameEditField);
		setPositionChild(field, offsetXTwo, offsetYOne);
		layoutChild(field, width, height);
		
		field = getField(passwordText);
		setPositionChild(field, offsetXOne, offsetYtwo);
		layoutChild(field, width, height);
		
		field = getField(passwordEditField);
		setPositionChild(field, offsetXTwo, offsetYtwo);
		layoutChild(field, width, height);
		
		field = getField(okButton);
		setPositionChild(field, 120, 140);
		layoutChild(field, width, height);
		
		setExtent(width, height);
	}
}