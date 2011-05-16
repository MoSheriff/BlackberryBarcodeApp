package main.java.com.owfg.facade.bb.StoreManagement.gui;

import net.rim.device.api.system.Display;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Manager;

public class LoginFieldManager extends Manager {
	final int ofgLogo = 0;
	//final int usernameText = 2;
	final int usernameEditField = 1;
	//final int passwordText = 3;
	final int passwordEditField  = 2;
	final int okButton = 3;
	
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
		int fieldWidth = field.getPreferredWidth()/2;
		setPositionChild(field, ((Display.getWidth()/2) - fieldWidth), 0); // set the position for the field
		layoutChild(field, width, height);

//		field = getField(usernameText);
//		setPositionChild(field, (Display.getWidth()/2 - field.getPreferredWidth()), Display.getHeight()/2 - field.getPreferredHeight());
//		layoutChild(field, width, height);
		
		field = getField(usernameEditField);
		fieldWidth = field.getPreferredWidth()/2;
		setPositionChild(field, Display.getWidth()/4, Display.getHeight()/3);
		layoutChild(field, width, height);
		
//		field = getField(passwordText);
//		setPositionChild(field, offsetXOne, offsetYtwo);
//		layoutChild(field, width, height);
		
		field = getField(passwordEditField);
		setPositionChild(field, Display.getWidth()/4, Display.getHeight()/3 + field.getPreferredHeight() );
		layoutChild(field, width, height);
		
		field = getField(okButton);
		setPositionChild(field, Display.getWidth()/2 - field.getPreferredWidth(), Display.getHeight()/3 + field.getPreferredHeight()*2);
		layoutChild(field, width, height);
		
		setExtent(width, height);
	}
}