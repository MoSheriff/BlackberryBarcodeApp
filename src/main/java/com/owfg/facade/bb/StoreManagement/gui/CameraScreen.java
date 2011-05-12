package main.java.com.owfg.facade.bb.StoreManagement.gui;

import org.w3c.dom.events.Event;

import main.java.com.owfg.facade.bb.StoreManagement.Logger.Logger;
import main.java.com.owfg.facade.bb.StoreManagement.app.MyApp;
import main.java.com.owfg.facade.bb.StoreManagement.app.ScreenshotThread;

import net.rim.device.api.system.Application;
import net.rim.device.api.ui.container.MainScreen;

public final class CameraScreen extends MainScreen {
	CameraThread cThread;
	Event barcodeScanned;

	public CameraScreen() {
	}

	public void startThread() {
		cThread = new CameraThread();
		cThread.start();
	}

	class CameraThread extends Thread {
		Runnable imgTkr;

		CameraThread() {
		}

		public void run() {
			imgTkr = new ScreenshotThread();
			try {
				sleep(500); // required to properly initialize the camerascreen
							// before screenshots start being taken. Might only
							// be a requirement in the simulator.
			} catch (InterruptedException e) {
				Logger.logSevereErrorEvent("CameraThread(): " + e);
			}
			imgTkr.run();
			synchronized (MyApp.app.getEventLock()) {
				MyApp.app.popScreen(getScreen());
				MyApp.app.pushScreen(new ProductScreen());
			}
			return;
		}
	}
}
