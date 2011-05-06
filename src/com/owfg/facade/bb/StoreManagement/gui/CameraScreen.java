package com.owfg.facade.bb.StoreManagement.gui;

import com.owfg.facade.bb.StoreManagement.app.ScreenshotThread;

import net.rim.device.api.ui.container.MainScreen;

public final class CameraScreen extends MainScreen {
	CameraThread cThread;

	public CameraScreen() {
		cThread = new CameraThread();
	}
	
	public void startThread() {
		cThread.start();
	}
	
	class CameraThread extends Thread {	
		Runnable imgTkr;
		CameraThread() {
		}
		
		public void run() {
			imgTkr = new ScreenshotThread();
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			imgTkr.run();
		}
	}
}
