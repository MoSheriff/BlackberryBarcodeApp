package mypackage;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.GlobalHistogramBinarizer;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.container.MainScreen;

public final class CameraScreen extends MainScreen {
	/**
	 * Creates a new MyScreen object
	 */
	public CameraScreen() {
		MyApp.imgTkr = new imageTaker();
		MyApp.imgTkr.run();
	}

	final class imageTaker implements Runnable {

		public void run() {
			Result result;
			Reader reader;
			reader = new MultiFormatReader();
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
				MyApp.app.popScreen(getScreen());
				return;
			} else {
				return;
			}
		}
	}
}
