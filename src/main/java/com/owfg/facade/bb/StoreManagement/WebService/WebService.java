package main.java.com.owfg.facade.bb.StoreManagement.WebService;

import main.java.com.owfg.facade.bb.StoreManagement.Logger.Logger;
import main.java.com.owfg.facade.bb.StoreManagement.stub.Banner;
import main.java.com.owfg.facade.bb.StoreManagement.stub.Store;
import main.java.com.owfg.facade.bb.StoreManagement.stub.StoreManagementImpl_Stub;
import main.java.com.owfg.facade.bb.StoreManagement.stub.StoreManagementInfo;



public class WebService  {
	private static StoreManagementImpl_Stub stub = null;
	public WebService() {
		Logger.logDebugEvent("WebService(): entered");
		try {
			if (stub == null) {
				//here we should be parsing an external file to set the endpoint address
				stub = new StoreManagementImpl_Stub();
				stub._setProperty(StoreManagementImpl_Stub.ENDPOINT_ADDRESS_PROPERTY,
						"http://warrenv.dlinkddns.com:8080");
				if (stub == null) {
					Logger.logErrorEvent("stub null after fetching it");
				} else {
					Logger.logDebugEvent("WebService() stub not null");
				}
			}
		} catch (Exception ex) {
			Logger.logSevereErrorEvent("WebService(): " + ex);
			return;
		}
		Logger.logDebugEvent("WebService(): exit");
	}
	
	public Store[] getStores() throws Exception {
		Store[] storesResponse = null;
		if (stub == null) {
			throw new Exception("Null Pointer Exception");
		}		
		try {
			storesResponse = stub.getActiveStores();
		} catch (Exception e) {
			Logger.logSevereErrorEvent("WebService.getStores(): " + e);
			throw e;
		}
		return storesResponse;
	}
	
	public Banner[] getBanners() throws Exception {
		Banner[] banners = null;
		if (stub == null) {
			throw new Exception("Null Pointer Exception");
		}
		try {
			banners = stub.getBanners();
		} catch (Exception e) {
			Logger.logSevereErrorEvent("WebService.getStores(): " + e);
			throw e;
		}
		return banners;
	}
	
	public StoreManagementInfo getInfo(String str) throws Exception {
		StoreManagementInfo info = null;
		if (stub == null) {
			throw new Exception("Null Pointer Exception");
		}
		try {
			info = stub.getStoreManagementInfo(1,str);
		} catch (Exception e) {
			Logger.logSevereErrorEvent("WebService.getStores(): " + e);
			throw e;
		}
		return info;
	}
}