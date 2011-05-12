// This class was generated by 172 StubGenerator.
// Contents subject to change without notice.
// @generated

package main.java.com.owfg.facade.bb.StoreManagement.stub;

import javax.xml.rpc.JAXRPCException;
import javax.xml.namespace.QName;
import javax.microedition.xml.rpc.Operation;
import javax.microedition.xml.rpc.Type;
import javax.microedition.xml.rpc.ComplexType;
import javax.microedition.xml.rpc.Element;

public class StoreManagementImpl_Stub implements main.java.com.owfg.facade.bb.StoreManagement.stub.StoreManagementImpl, javax.xml.rpc.Stub {
	private String[] _propertyNames;
	private Object[] _propertyValues;

	public StoreManagementImpl_Stub() {
		_propertyNames = new String[] {ENDPOINT_ADDRESS_PROPERTY};
		_propertyValues = new Object[] {"http://wazasrv:8080/StoreManagement-ws"};
	}

	public void _setProperty(String name, Object value) {
		int size = _propertyNames.length;
		for (int i = 0; i < size; ++i) {
			if (_propertyNames[i].equals(name)) {
				_propertyValues[i] = value;
				return;
			}
		}
		// Need to expand our array for a new property
		String[] newPropNames = new String[size + 1];
		System.arraycopy(_propertyNames, 0, newPropNames, 0, size);
		_propertyNames = newPropNames;
		Object[] newPropValues = new Object[size + 1];
		System.arraycopy(_propertyValues, 0, newPropValues, 0, size);
		_propertyValues = newPropValues;

		_propertyNames[size] = name;
		_propertyValues[size] = value;
	}

	public Object _getProperty(String name) {
		for (int i = 0; i < _propertyNames.length; ++i) {
			if (_propertyNames[i].equals(name)) {
				return _propertyValues[i];
			}
		}
		if (ENDPOINT_ADDRESS_PROPERTY.equals(name) || USERNAME_PROPERTY.equals(name) || PASSWORD_PROPERTY.equals(name)) {
			return null;
		}
		if (SESSION_MAINTAIN_PROPERTY.equals(name)) {
			return new java.lang.Boolean(false);
		}
		throw new JAXRPCException("Stub does not recognize property: "+name);
	}

	protected void _prepOperation(Operation op) {
		for (int i = 0; i < _propertyNames.length; ++i) {
			op.setProperty(_propertyNames[i], _propertyValues[i].toString());
		}
	}

	// 
	//  Begin user methods
	// 

	public main.java.com.owfg.facade.bb.StoreManagement.stub.Store[] getActiveStores() throws java.rmi.RemoteException {
		// Copy the incoming values into an Object array if needed.
		Object[] inputObject = new Object[0];

		Operation op = Operation.newInstance(_qname_getActiveStores, _type_getActiveStores, _type_getActiveStoresResponse);
		_prepOperation(op);
		op.setProperty(Operation.SOAPACTION_URI_PROPERTY, "");
		Object resultObj;
		try {
			resultObj = op.invoke(inputObject);
		} catch (JAXRPCException e) {
			Throwable cause = e.getLinkedCause();
			if (cause instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) cause;
			}
			throw e;
		}
		main.java.com.owfg.facade.bb.StoreManagement.stub.Store[] result;
		// Convert the result into the right Java type.
		// Unwrapped return value
		Object[] _returnObj = (Object[]) ((Object[])resultObj)[0];
		if (_returnObj == null) {
			result = null;
		} else {
			int storeArraySize = _returnObj.length;
			result = new main.java.com.owfg.facade.bb.StoreManagement.stub.Store[storeArraySize];
			for (int storeArrayIndex = 0; 
				storeArrayIndex < storeArraySize; ++storeArrayIndex) {
				if (_returnObj[storeArrayIndex] == null) {
					result[storeArrayIndex] = null;
				} else {
					result[storeArrayIndex] = new main.java.com.owfg.facade.bb.StoreManagement.stub.Store();
					long a_long;
					Object bannerIdObj = ((Object[])_returnObj[storeArrayIndex])[0];
					a_long = ((java.lang.Long)bannerIdObj).longValue();
					result[storeArrayIndex].setBannerId(a_long);
					long a_long2;
					Object storeIdObj = ((Object[])_returnObj[storeArrayIndex])[1];
					a_long2 = ((java.lang.Long)storeIdObj).longValue();
					result[storeArrayIndex].setStoreId(a_long2);
					java.lang.String string;
					Object storeNameObj = ((Object[])_returnObj[storeArrayIndex])[2];
					string = (java.lang.String)storeNameObj;
					result[storeArrayIndex].setStoreName(string);
				}
			}
		}
		return result;
	}

	public main.java.com.owfg.facade.bb.StoreManagement.stub.Banner[] getBanners() throws java.rmi.RemoteException {
		// Copy the incoming values into an Object array if needed.
		Object[] inputObject = new Object[0];

		Operation op = Operation.newInstance(_qname_getBanners, _type_getBanners, _type_getBannersResponse);
		_prepOperation(op);
		op.setProperty(Operation.SOAPACTION_URI_PROPERTY, "");
		Object resultObj;
		try {
			resultObj = op.invoke(inputObject);
		} catch (JAXRPCException e) {
			Throwable cause = e.getLinkedCause();
			if (cause instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) cause;
			}
			throw e;
		}
		main.java.com.owfg.facade.bb.StoreManagement.stub.Banner[] result;
		// Convert the result into the right Java type.
		// Unwrapped return value
		Object[] _returnObj = (Object[]) ((Object[])resultObj)[0];
		if (_returnObj == null) {
			result = null;
		} else {
			int bannerArraySize = _returnObj.length;
			result = new main.java.com.owfg.facade.bb.StoreManagement.stub.Banner[bannerArraySize];
			for (int bannerArrayIndex = 0; 
				bannerArrayIndex < bannerArraySize; ++bannerArrayIndex) {
				if (_returnObj[bannerArrayIndex] == null) {
					result[bannerArrayIndex] = null;
				} else {
					result[bannerArrayIndex] = new main.java.com.owfg.facade.bb.StoreManagement.stub.Banner();
					long a_long;
					Object bannerIdObj = ((Object[])_returnObj[bannerArrayIndex])[0];
					a_long = ((java.lang.Long)bannerIdObj).longValue();
					result[bannerArrayIndex].setBannerId(a_long);
					java.lang.String string;
					Object bannerNameObj = ((Object[])_returnObj[bannerArrayIndex])[1];
					string = (java.lang.String)bannerNameObj;
					result[bannerArrayIndex].setBannerName(string);
				}
			}
		}
		return result;
	}

	public main.java.com.owfg.facade.bb.StoreManagement.stub.StoreManagementInfo getStoreManagementInfo(long arg0, java.lang.String arg1) throws java.rmi.RemoteException {
		// Copy the incoming values into an Object array if needed.
		Object[] inputObject = new Object[2];
		inputObject[0] = new java.lang.Long(arg0);
		inputObject[1] = arg1;

		Operation op = Operation.newInstance(_qname_getStoreManagementInfo, _type_getStoreManagementInfo, _type_getStoreManagementInfoResponse);
		_prepOperation(op);
		op.setProperty(Operation.SOAPACTION_URI_PROPERTY, "");
		Object resultObj;
		try {
			resultObj = op.invoke(inputObject);
		} catch (JAXRPCException e) {
			Throwable cause = e.getLinkedCause();
			if (cause instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) cause;
			}
			throw e;
		}
		main.java.com.owfg.facade.bb.StoreManagement.stub.StoreManagementInfo result;
		// Convert the result into the right Java type.
		// Unwrapped return value
		Object[] _returnObj = (Object[]) ((Object[])resultObj)[0];
		if (_returnObj == null) {
			result = null;
		} else {
			result = new main.java.com.owfg.facade.bb.StoreManagement.stub.StoreManagementInfo();
			double a_double;
			Object balanceOnHandObj = _returnObj[0];
			a_double = ((java.lang.Double)balanceOnHandObj).doubleValue();
			result.setBalanceOnHand(a_double);
			double a_double2;
			Object forecastObj = _returnObj[1];
			a_double2 = ((java.lang.Double)forecastObj).doubleValue();
			result.setForecast(a_double2);
			double a_double3;
			Object inTransitObj = _returnObj[2];
			a_double3 = ((java.lang.Double)inTransitObj).doubleValue();
			result.setInTransit(a_double3);
			java.lang.String string;
			Object itemDescriptionObj = _returnObj[3];
			string = (java.lang.String)itemDescriptionObj;
			result.setItemDescription(string);
			long a_long;
			Object minimumObj = _returnObj[4];
			a_long = ((java.lang.Long)minimumObj).longValue();
			result.setMinimum(a_long);
			double a_double4;
			Object onOrderObj = _returnObj[5];
			a_double4 = ((java.lang.Double)onOrderObj).doubleValue();
			result.setOnOrder(a_double4);
			int a_int;
			Object packObj = _returnObj[6];
			a_int = ((java.lang.Integer)packObj).intValue();
			result.setPack(a_int);
			java.lang.String string2;
			Object promotionObj = _returnObj[7];
			string2 = (java.lang.String)promotionObj;
			result.setPromotion(string2);
			double a_double5;
			Object regularPriceObj = _returnObj[8];
			a_double5 = ((java.lang.Double)regularPriceObj).doubleValue();
			result.setRegularPrice(a_double5);
			java.lang.String string3;
			Object sourceObj = _returnObj[9];
			string3 = (java.lang.String)sourceObj;
			result.setSource(string3);
			long a_long2;
			Object storeIdObj = _returnObj[10];
			a_long2 = ((java.lang.Long)storeIdObj).longValue();
			result.setStoreId(a_long2);
			java.lang.String string4;
			Object upcObj = _returnObj[11];
			string4 = (java.lang.String)upcObj;
			result.setUpc(string4);
		}
		return result;
	}
	// 
	//  End user methods
	// 

	protected static final QName _qname_arg0 = new QName("", "arg0");
	protected static final QName _qname_arg1 = new QName("", "arg1");
	protected static final QName _qname_balanceOnHand = new QName("", "balanceOnHand");
	protected static final QName _qname_bannerId = new QName("", "bannerId");
	protected static final QName _qname_bannerName = new QName("", "bannerName");
	protected static final QName _qname_forecast = new QName("", "forecast");
	protected static final QName _qname_inTransit = new QName("", "inTransit");
	protected static final QName _qname_itemDescription = new QName("", "itemDescription");
	protected static final QName _qname_minimum = new QName("", "minimum");
	protected static final QName _qname_onOrder = new QName("", "onOrder");
	protected static final QName _qname_pack = new QName("", "pack");
	protected static final QName _qname_promotion = new QName("", "promotion");
	protected static final QName _qname_regularPrice = new QName("", "regularPrice");
	protected static final QName _qname_return = new QName("", "return");
	protected static final QName _qname_source = new QName("", "source");
	protected static final QName _qname_storeId = new QName("", "storeId");
	protected static final QName _qname_storeName = new QName("", "storeName");
	protected static final QName _qname_upc = new QName("", "upc");
	protected static final QName _qname_getActiveStores = new QName("http://StoreManagement.ws.facade.owfg.com/", "getActiveStores");
	protected static final QName _qname_getActiveStoresResponse = new QName("http://StoreManagement.ws.facade.owfg.com/", "getActiveStoresResponse");
	protected static final QName _qname_getBanners = new QName("http://StoreManagement.ws.facade.owfg.com/", "getBanners");
	protected static final QName _qname_getBannersResponse = new QName("http://StoreManagement.ws.facade.owfg.com/", "getBannersResponse");
	protected static final QName _qname_getStoreManagementInfo = new QName("http://StoreManagement.ws.facade.owfg.com/", "getStoreManagementInfo");
	protected static final QName _qname_getStoreManagementInfoResponse = new QName("http://StoreManagement.ws.facade.owfg.com/", "getStoreManagementInfoResponse");
	protected static final Element _type_getActiveStores;
	protected static final Element _type_getActiveStoresResponse;
	protected static final Element _type_getBanners;
	protected static final Element _type_getBannersResponse;
	protected static final Element _type_getStoreManagementInfo;
	protected static final Element _type_getStoreManagementInfoResponse;
	static {
		// Create all of the Type's that this stub uses, once.
		ComplexType _complexType_getActiveStores;
		_complexType_getActiveStores = new ComplexType();
		_complexType_getActiveStores.elements = new Element[0];
		_type_getActiveStores = new Element(_qname_getActiveStores, _complexType_getActiveStores);
		Element _type_bannerId;
		_type_bannerId = new Element(_qname_bannerId, Type.LONG);
		Element _type_storeId;
		_type_storeId = new Element(_qname_storeId, Type.LONG);
		Element _type_storeName;
		_type_storeName = new Element(_qname_storeName, Type.STRING, 0, 1, false);
		ComplexType _complexType_store;
		_complexType_store = new ComplexType();
		_complexType_store.elements = new Element[3];
		_complexType_store.elements[0] = _type_bannerId;
		_complexType_store.elements[1] = _type_storeId;
		_complexType_store.elements[2] = _type_storeName;
		Element _type_return;
		_type_return = new Element(_qname_return, _complexType_store, 0, -1, false);
		ComplexType _complexType_getActiveStoresResponse;
		_complexType_getActiveStoresResponse = new ComplexType();
		_complexType_getActiveStoresResponse.elements = new Element[1];
		_complexType_getActiveStoresResponse.elements[0] = _type_return;
		_type_getActiveStoresResponse = new Element(_qname_getActiveStoresResponse, _complexType_getActiveStoresResponse);
		_type_getBanners = new Element(_qname_getBanners, _complexType_getActiveStores);
		Element _type_bannerName;
		_type_bannerName = new Element(_qname_bannerName, Type.STRING, 0, 1, false);
		ComplexType _complexType_banner;
		_complexType_banner = new ComplexType();
		_complexType_banner.elements = new Element[2];
		_complexType_banner.elements[0] = _type_bannerId;
		_complexType_banner.elements[1] = _type_bannerName;
		Element _type_return2;
		_type_return2 = new Element(_qname_return, _complexType_banner, 0, -1, false);
		ComplexType _complexType_getBannersResponse;
		_complexType_getBannersResponse = new ComplexType();
		_complexType_getBannersResponse.elements = new Element[1];
		_complexType_getBannersResponse.elements[0] = _type_return2;
		_type_getBannersResponse = new Element(_qname_getBannersResponse, _complexType_getBannersResponse);
		Element _type_arg0;
		_type_arg0 = new Element(_qname_arg0, Type.LONG);
		Element _type_arg1;
		_type_arg1 = new Element(_qname_arg1, Type.STRING, 0, 1, false);
		ComplexType _complexType_getStoreManagementInfo;
		_complexType_getStoreManagementInfo = new ComplexType();
		_complexType_getStoreManagementInfo.elements = new Element[2];
		_complexType_getStoreManagementInfo.elements[0] = _type_arg0;
		_complexType_getStoreManagementInfo.elements[1] = _type_arg1;
		_type_getStoreManagementInfo = new Element(_qname_getStoreManagementInfo, _complexType_getStoreManagementInfo);
		Element _type_balanceOnHand;
		_type_balanceOnHand = new Element(_qname_balanceOnHand, Type.DOUBLE);
		Element _type_forecast;
		_type_forecast = new Element(_qname_forecast, Type.DOUBLE);
		Element _type_inTransit;
		_type_inTransit = new Element(_qname_inTransit, Type.DOUBLE);
		Element _type_itemDescription;
		_type_itemDescription = new Element(_qname_itemDescription, Type.STRING, 0, 1, false);
		Element _type_minimum;
		_type_minimum = new Element(_qname_minimum, Type.LONG);
		Element _type_onOrder;
		_type_onOrder = new Element(_qname_onOrder, Type.DOUBLE);
		Element _type_pack;
		_type_pack = new Element(_qname_pack, Type.INT);
		Element _type_promotion;
		_type_promotion = new Element(_qname_promotion, Type.STRING, 0, 1, false);
		Element _type_regularPrice;
		_type_regularPrice = new Element(_qname_regularPrice, Type.DOUBLE);
		Element _type_source;
		_type_source = new Element(_qname_source, Type.STRING, 0, 1, false);
		Element _type_upc;
		_type_upc = new Element(_qname_upc, Type.STRING, 0, 1, false);
		ComplexType _complexType_storeManagementInfo;
		_complexType_storeManagementInfo = new ComplexType();
		_complexType_storeManagementInfo.elements = new Element[12];
		_complexType_storeManagementInfo.elements[0] = _type_balanceOnHand;
		_complexType_storeManagementInfo.elements[1] = _type_forecast;
		_complexType_storeManagementInfo.elements[2] = _type_inTransit;
		_complexType_storeManagementInfo.elements[3] = _type_itemDescription;
		_complexType_storeManagementInfo.elements[4] = _type_minimum;
		_complexType_storeManagementInfo.elements[5] = _type_onOrder;
		_complexType_storeManagementInfo.elements[6] = _type_pack;
		_complexType_storeManagementInfo.elements[7] = _type_promotion;
		_complexType_storeManagementInfo.elements[8] = _type_regularPrice;
		_complexType_storeManagementInfo.elements[9] = _type_source;
		_complexType_storeManagementInfo.elements[10] = _type_storeId;
		_complexType_storeManagementInfo.elements[11] = _type_upc;
		Element _type_return3;
		_type_return3 = new Element(_qname_return, _complexType_storeManagementInfo, 0, 1, false);
		ComplexType _complexType_getStoreManagementInfoResponse;
		_complexType_getStoreManagementInfoResponse = new ComplexType();
		_complexType_getStoreManagementInfoResponse.elements = new Element[1];
		_complexType_getStoreManagementInfoResponse.elements[0] = _type_return3;
		_type_getStoreManagementInfoResponse = new Element(_qname_getStoreManagementInfoResponse, _complexType_getStoreManagementInfoResponse);
	}

}