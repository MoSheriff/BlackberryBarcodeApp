package mypackage;

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
			imgTkr.run();
		}
	}
}
