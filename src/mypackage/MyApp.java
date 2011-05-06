package mypackage;

import java.io.IOException;

import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.VideoControl;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.oned.MultiFormatOneDReader;
import com.google.zxing.common.GlobalHistogramBinarizer;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.system.EventInjector;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.UiApplication;


/**
 * This class extends the UiApplication class, providing a graphical user
 * interface.
 */
public class MyApp extends UiApplication {

	static MyApp app;
	static Field viewFinder;
	static CameraScreen cScreen;
	static VideoControl vc;

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
	}

	/**
	 * Creates a new MyApp object
	 */
	public MyApp() {
		Player player;
		MyScreen screen = new MyScreen();
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
	final class imageTaker implements Runnable {
		//Hashtable formats = new Hashtable();
		//formats.put(DecodeHintType.POSSIBLE_FORMATS, BarcodeFormat_UPC_E);
		imageTaker() {
			
		}

		public void run() {
			Result result;
			Reader reader;
			reader = new MultiFormatOneDReader(null);
			Bitmap bitmap = new Bitmap(Display.getWidth(), Display.getHeight());
			Display.screenshot(bitmap);
			LuminanceSource source = new CustomBitmapLuminanceSource(bitmap);
			BinaryBitmap bitmap1 = new BinaryBitmap(
					new GlobalHistogramBinarizer(source));
			try {
				result = reader.decode(bitmap1);
			} catch (ReaderException e) {
				return;
			}
			if (result != null) {
				String resultText = result.getText();
				MyApp.app.popScreen(getActiveScreen());
				return;
			} else {
				return;
			}
		}
	}
}
