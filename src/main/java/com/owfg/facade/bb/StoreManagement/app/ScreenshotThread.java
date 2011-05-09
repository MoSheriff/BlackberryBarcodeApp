package com.owfg.facade.bb.StoreManagement.app;

import java.util.Hashtable;
import java.util.Vector;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Characters;
import net.rim.device.api.system.Display;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.oned.MultiFormatOneDReader;

public class ScreenshotThread implements Runnable {

	public void run() {
		Result result;
		Reader reader;
		Hashtable hints = new Hashtable(1);
		Vector readerHints = new Vector(4);
		readerHints.addElement(BarcodeFormat.UPC_A);
		readerHints.addElement(BarcodeFormat.UPC_E);
		readerHints.addElement(BarcodeFormat.CODE_128);
		readerHints.addElement(BarcodeFormat.ITF);
		hints.put(DecodeHintType.POSSIBLE_FORMATS, readerHints);
		reader = new MultiFormatOneDReader(hints);
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
			MyApp.keyDownUp(Characters.ESCAPE);
			return;
		} else {
			return;
		}
	}

}
