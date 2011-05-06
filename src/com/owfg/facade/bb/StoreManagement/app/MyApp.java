package com.owfg.facade.bb.StoreManagement.app;

import java.io.IOException;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.VideoControl;

import com.owfg.facade.bb.StoreManagement.gui.CameraScreen;
import com.owfg.facade.bb.StoreManagement.gui.MenuScreen;

import net.rim.device.api.system.EventInjector;
import net.rim.device.api.system.EventLogger;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.UiApplication;

/**
 * This class extends the UiApplication class, providing a graphical user
 * interface.
 */
public class MyApp extends UiApplication {

	public static MyApp app;
	static Field viewFinder;
	public static CameraScreen cScreen;
	static VideoControl vc;
	public static final long GUID = 0x2051fd67b72d11L;
	public static final String APP_NAME = "OWFGScanner";
	
	/**
	 * Entry point for application
	 * 
	 * @param args
	 *            Command line arguments (not used)
	 * @throws IOException
	 * @throws MediaException
	 */
	public static void main(String[] args) {
		app = new MyApp();
		app.enterEventDispatcher();
		EventLogger.register(MyApp.GUID, MyApp.APP_NAME, EventLogger.VIEWER_STRING);
	}

	/**
	 * Creates a new MyApp object
	 */
	public MyApp() {
		Player player;
		MenuScreen screen = new MenuScreen();
		cScreen = new CameraScreen();
		pushScreen(screen);
		try {
			player = Manager.createPlayer("capture://video");
			player.realize();
			player.start();
			vc = (VideoControl) player.getControl("VideoControl");
			viewFinder = (Field) vc.initDisplayMode(
					VideoControl.USE_GUI_PRIMITIVE,
					"net.rim.device.api.ui.Field");
			vc.setDisplayFullScreen(true);
			try {
				cScreen.add(MyApp.viewFinder);
			} catch (IllegalStateException ise) {
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (MediaException mee) {
			mee.printStackTrace();
		}
	}

	/**
	 * Simulates a single keypress (push and release)
	 */
	private static void keyDownUp(char character) {
		EventInjector.invokeEvent(new EventInjector.KeyEvent(
				EventInjector.KeyEvent.KEY_DOWN, character, 0));
		EventInjector.invokeEvent(new EventInjector.KeyEvent(
				EventInjector.KeyEvent.KEY_UP, character, 0));
	}
}
