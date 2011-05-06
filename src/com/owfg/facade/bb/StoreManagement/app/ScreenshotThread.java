package com.owfg.facade.bb.StoreManagement.app;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.oned.MultiFormatOneDReader;

public class ScreenshotThread implements Runnable {

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
			MyApp.app.popScreen(MyApp.app.getActiveScreen());
			return;
		} else {
			return;
		}
	}

}
