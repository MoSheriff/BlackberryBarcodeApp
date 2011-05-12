package main.java.com.owfg.facade.bb.StoreManagement.gui;

import javax.microedition.lcdui.Image;

import main.java.com.owfg.facade.bb.StoreManagement.app.MyApp;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.container.MainScreen;

public class LoginScreen extends MainScreen {
	final int enterButton = 4;
	Field okButton;
	Image logo;

	public LoginScreen() {
		Bitmap logo = Bitmap.getBitmapResource("logo_ofg_72.png");
		LabelField title = new LabelField("Login", LabelField.ELLIPSIS
				| LabelField.USE_ALL_WIDTH);
		setTitle(title);
		LoginFieldManager lfm = new LoginFieldManager(0);
		FieldChangeListener buttonListener = new ButtonListener();
		BitmapField logoField = new BitmapField(logo);

		EditField username = new EditField("Username:","", 20, 0);
		PasswordEditField passwd = new PasswordEditField("Password:","", 20, 0);
		okButton = new ButtonField("Enter", ButtonField.CONSUME_CLICK);
		okButton.setChangeListener(buttonListener);
		lfm.add(logoField);
		lfm.add(username);
		lfm.add(passwd);
		lfm.add(okButton);
		add(lfm);
	}

	final class ButtonListener implements FieldChangeListener {
		public void fieldChanged(Field field, int context) {
			if (field.equals(okButton)) {
				synchronized (MyApp.app.getEventLock()) {
					MyApp.app.popScreen(getScreen());
					MyApp.app.pushScreen(MyApp.cScreen);
				}
				MyApp.cScreen.startThread();
			}
		}
	}

	public boolean onSavePrompt() {
		return true;
	}
}
