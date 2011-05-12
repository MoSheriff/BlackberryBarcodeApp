package main.java.com.owfg.facade.bb.StoreManagement.gui;

import main.java.com.owfg.facade.bb.StoreManagement.app.MyApp;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class LoginScreen extends MainScreen {
	final int enterButton = 4;

	public LoginScreen() {
		Bitmap backgroundBitmap = Bitmap.getBitmapResource("logo_ofg_72-1.png");
		LabelField title = new LabelField("Login", LabelField.ELLIPSIS
				| LabelField.USE_ALL_WIDTH);
		setTitle(title);
		VerticalFieldManager vfm = new VerticalFieldManager();
		FieldChangeListener buttonListener = new ButtonListener();

		EditField username = new EditField();
		PasswordEditField passwd = new PasswordEditField();
		Field okButton = new ButtonField("Enter", ButtonField.CONSUME_CLICK);
		okButton.setChangeListener(buttonListener);
		vfm.add(new LabelField("Username:"));
		vfm.add(username);
		vfm.add(new LabelField("Password:"));
		vfm.add(passwd);
		vfm.add(okButton);
		add(vfm);
	}

	final class ButtonListener implements FieldChangeListener {
		public void fieldChanged(Field field, int context) {
			if (field.getIndex() == enterButton) {
				MyApp.cScreen.startThread();
				synchronized (MyApp.app.getEventLock()) {
					MyApp.app.popScreen(getScreen());
					MyApp.app.pushScreen(MyApp.cScreen);
				}
			}
		}
	}

	public boolean onSavePrompt() {
		return true;
	}
}
