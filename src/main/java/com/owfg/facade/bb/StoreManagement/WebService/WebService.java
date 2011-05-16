package main.java.com.owfg.facade.bb.StoreManagement.WebService;

import main.java.com.owfg.facade.bb.StoreManagement.Logger.Logger;
import main.java.com.owfg.facade.bb.StoreManagement.stub.Banner;
import main.java.com.owfg.facade.bb.StoreManagement.stub.Store;
import main.java.com.owfg.facade.bb.StoreManagement.stub.StoreManagementImpl_Stub;
import main.java.com.owfg.facade.bb.StoreManagement.stub.StoreManagementInfo;


/**
* Class which manages the web service.
* <p>
* The WebService uses the generated stub files then sets the
* target server address in the stub classes from the properties file
* (to be implemented)   
*
* @author Warren Voelkl
**/
public class WebService  {
	private static StoreManagementImpl_Stub stub = null;
	public WebService() {
		try {
			if (stub == null) {
				//here we should be parsing an external file to set the endpoint address
				stub = new StoreManagementImpl_Stub();
				//just setting to https is enough to make in encrypted
				stub._setProperty(StoreManagementImpl_Stub.ENDPOINT_ADDRESS_PROPERTY,
						"https://warrenv.dlinkddns.com/StoreManagement-ws");
				//and this should make it basic auth
				//this should be taking the "test" strings from login screen
				stub._setProperty(StoreManagementImpl_Stub.USERNAME_PROPERTY, "test");
				stub._setProperty(StoreManagementImpl_Stub.PASSWORD_PROPERTY, "test");
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
	}
	
	/**
	* Gets a list of the stores from server
	* <p>
	* Currently this function uses the stub to contact a server
	* on a failure it will throw an exception currently this is
	* disabled for testing purposes.
	*
	* @return a list of stores containing name, id and bannerId
	* @author Warren Voelkl
	**/
	public String[] getStores() throws Exception {
		Store[] storesResponse = null;
		String[] str = null;
		if (stub == null) {
			throw new Exception("Null Pointer Exception");
		}		
		try {
			storesResponse = stub.getActiveStores();
		} catch (Exception e) {
			Logger.logSevereErrorEvent("WebService.getStores(): " + e);
			throw e;
		}
		str = new String[storesResponse.length];
		for (int i = 0; i != storesResponse.length; i++) {
			str[i] = new String(storesResponse[i].getStoreId() + " " 
					+ ((storesResponse[i].getStoreName() == null) 
							? "" : storesResponse[i].getStoreName()));
		}	
		return str;
	}
	
	/**
	* Gets a list of the Banners from server
	* <p>
	* Currently this function uses the stub to contact a server
	* on a failure it will throw an exception currently this is
	* disabled for testing purposes.
	*
	* @return a list of store banners;
	* @author Warren Voelkl
	**/
	public String[] getBanners() throws Exception {
		Banner[] banners = null;
		String[] str = null;
		if (stub == null) {
			throw new Exception("Null Pointer Exception");
		}
		try {
			banners = stub.getBanners();
		} catch (Exception e) {
			Logger.logSevereErrorEvent("WebService.getStores(): " + e);
			throw e;
		}
		str = new String[banners.length];
		for (int i = 0; i != banners.length; i++) {
			str[i] = new String(banners[i].getBannerId() + " " 
					+ ((banners[i].getBannerName() == null) 
							? "" : banners[i].getBannerName()));
		}	
		return str;
	}
	
	/**
	* Gets a list of the Banners from server
	* <p>
	* Currently this function uses the stub to contact a server
	* on a failure it will throw an exception currently this exception
	* returns bogus data for testing purposes.
	* 
	* @return the info object containing all information of an object
	* @author Warren Voelkl
	**/	
	public ProductInfo getInfo(String str) throws Exception {
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
		return new ProductInfo(info);
	}
	
}