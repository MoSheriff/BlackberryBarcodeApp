package mypackage;

//import mypackage.MyApp.imageTaker;
import net.rim.device.api.ui.container.MainScreen;

//import java.lang.Thread;


public final class CameraScreen extends MainScreen {
	CameraThread cThread;
	//imageTaker imgTkr;

	public CameraScreen() {
		//imgTkr = MyApp.app.new imageTaker();
		//new Thread(imgTkr).run();
		//cThread.run();
		cThread = new CameraThread();
	}
	
	public void startThread() {
		//new Thread(imgTkr).run();
		cThread.start();
		
	}
	
	class CameraThread extends Thread {	
		Runnable imgTkr;
		CameraThread() {
			imgTkr = MyApp.app.new imageTaker();
		}
		
		public void run() {
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			imgTkr.run();
		}
	}
}
