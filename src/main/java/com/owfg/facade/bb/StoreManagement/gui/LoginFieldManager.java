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

	protected LoginFieldManager(long style) {
		super(style);
	}

	protected void sublayout(int width, int height) {
		Field field;
		
		field = getField(ofgLogo); // get the field
		setPositionChild(field, 120, 0); // set the position for the field
		layoutChild(field, width, height);

		field = getField(usernameText); // get the field
		setPositionChild(field, 60, 80); // set the position for the field
		layoutChild(field, width, height);
		
		field = getField(usernameEditField); // get the field
		setPositionChild(field, 148, 80); // set the position for the field
		layoutChild(field, width, height);
		
		field = getField(passwordText); // get the field
		setPositionChild(field, 60, 110); // set the position for the field
		layoutChild(field, width, height);
		
		field = getField(passwordEditField); // get the field
		setPositionChild(field, 142, 110); // set the position for the field
		layoutChild(field, width, height);
		
		field = getField(okButton); // get the field
		setPositionChild(field, 120, 140); // set the position for the field
		layoutChild(field, width, height);
		
		setExtent(width, height);
	}
}