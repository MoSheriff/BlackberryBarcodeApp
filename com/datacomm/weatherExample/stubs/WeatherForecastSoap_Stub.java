// This class was generated by 172 StubGenerator.
// Contents subject to change without notice.
// @generated

package com.datacomm.weatherExample.stubs;

import javax.xml.rpc.JAXRPCException;
import javax.xml.namespace.QName;
import javax.microedition.xml.rpc.Operation;
import javax.microedition.xml.rpc.Type;
import javax.microedition.xml.rpc.ComplexType;
import javax.microedition.xml.rpc.Element;

public class WeatherForecastSoap_Stub implements com.datacomm.weatherExample.stubs.WeatherForecastSoap, javax.xml.rpc.Stub {
	private String[] _propertyNames;
	private Object[] _propertyValues;

	public WeatherForecastSoap_Stub() {
		_propertyNames = new String[] {ENDPOINT_ADDRESS_PROPERTY};
		_propertyValues = new Object[] {"http://www.webservicex.net/weatherforecast.asmx"};
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

	public com.datacomm.weatherExample.stubs.WeatherForecasts getWeatherByZipCode(java.lang.String zipCode) throws java.rmi.RemoteException {
		// Copy the incoming values into an Object array if needed.
		Object[] inputObject = new Object[1];
		inputObject[0] = zipCode;

		Operation op = Operation.newInstance(_qname_GetWeatherByZipCode, _type_GetWeatherByZipCode, _type_GetWeatherByZipCodeResponse);
		_prepOperation(op);
		op.setProperty(Operation.SOAPACTION_URI_PROPERTY, "http://www.webservicex.net/GetWeatherByZipCode");
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
		com.datacomm.weatherExample.stubs.WeatherForecasts result;
		// Convert the result into the right Java type.
		// Unwrapped return value
		Object[] getWeatherByZipCodeResultObj = (Object[]) ((Object[])resultObj)[0];
		if (getWeatherByZipCodeResultObj == null) {
			result = null;
		} else {
			result = new com.datacomm.weatherExample.stubs.WeatherForecasts();
			float a_float;
			Object latitudeObj = getWeatherByZipCodeResultObj[0];
			a_float = ((java.lang.Float)latitudeObj).floatValue();
			result.setLatitude(a_float);
			float a_float2;
			Object longitudeObj = getWeatherByZipCodeResultObj[1];
			a_float2 = ((java.lang.Float)longitudeObj).floatValue();
			result.setLongitude(a_float2);
			float a_float3;
			Object allocationFactorObj = getWeatherByZipCodeResultObj[2];
			a_float3 = ((java.lang.Float)allocationFactorObj).floatValue();
			result.setAllocationFactor(a_float3);
			java.lang.String string;
			Object fipsCodeObj = getWeatherByZipCodeResultObj[3];
			string = (java.lang.String)fipsCodeObj;
			result.setFipsCode(string);
			java.lang.String string2;
			Object placeNameObj = getWeatherByZipCodeResultObj[4];
			string2 = (java.lang.String)placeNameObj;
			result.setPlaceName(string2);
			java.lang.String string3;
			Object stateCodeObj = getWeatherByZipCodeResultObj[5];
			string3 = (java.lang.String)stateCodeObj;
			result.setStateCode(string3);
			java.lang.String string4;
			Object statusObj = getWeatherByZipCodeResultObj[6];
			string4 = (java.lang.String)statusObj;
			result.setStatus(string4);
			com.datacomm.weatherExample.stubs.ArrayOfWeatherData arrayOfWeatherData;
			Object[] detailsObj = (Object[]) getWeatherByZipCodeResultObj[7];
			if (detailsObj == null) {
				arrayOfWeatherData = null;
			} else {
				arrayOfWeatherData = new com.datacomm.weatherExample.stubs.ArrayOfWeatherData();
				com.datacomm.weatherExample.stubs.WeatherData[] weatherDataArray;
				Object[] weatherDataObj = (Object[]) detailsObj[0];
				if (weatherDataObj == null) {
					weatherDataArray = null;
				} else {
					int weatherDataArraySize = weatherDataObj.length;
					weatherDataArray = new com.datacomm.weatherExample.stubs.WeatherData[weatherDataArraySize];
					for (int weatherDataArrayIndex = 0; 
						weatherDataArrayIndex < weatherDataArraySize; 
						++weatherDataArrayIndex) {
						if (weatherDataObj[weatherDataArrayIndex] == null) {
							weatherDataArray[weatherDataArrayIndex] = null;
						} else {
							weatherDataArray[weatherDataArrayIndex] = new com.datacomm.weatherExample.stubs.WeatherData();
							java.lang.String string5;
							Object dayObj = ((Object[])weatherDataObj[weatherDataArrayIndex])[0];
							string5 = (java.lang.String)dayObj;
							weatherDataArray[weatherDataArrayIndex].setDay(string5);
							java.lang.String string6;
							Object weatherImageObj = ((Object[])weatherDataObj[weatherDataArrayIndex])[1];
							string6 = (java.lang.String)weatherImageObj;
							weatherDataArray[weatherDataArrayIndex].setWeatherImage(string6);
							java.lang.String string7;
							Object maxTemperatureFObj = ((Object[])weatherDataObj[weatherDataArrayIndex])[2];
							string7 = (java.lang.String)maxTemperatureFObj;
							weatherDataArray[weatherDataArrayIndex].setMaxTemperatureF(string7);
							java.lang.String string8;
							Object minTemperatureFObj = ((Object[])weatherDataObj[weatherDataArrayIndex])[3];
							string8 = (java.lang.String)minTemperatureFObj;
							weatherDataArray[weatherDataArrayIndex].setMinTemperatureF(string8);
							java.lang.String string9;
							Object maxTemperatureCObj = ((Object[])weatherDataObj[weatherDataArrayIndex])[4];
							string9 = (java.lang.String)maxTemperatureCObj;
							weatherDataArray[weatherDataArrayIndex].setMaxTemperatureC(string9);
							java.lang.String string10;
							Object minTemperatureCObj = ((Object[])weatherDataObj[weatherDataArrayIndex])[5];
							string10 = (java.lang.String)minTemperatureCObj;
							weatherDataArray[weatherDataArrayIndex].setMinTemperatureC(string10);
						}
					}
				}
				arrayOfWeatherData.setWeatherData(weatherDataArray);
			}
			result.setDetails(arrayOfWeatherData);
		}
		return result;
	}

	public com.datacomm.weatherExample.stubs.WeatherForecasts getWeatherByPlaceName(java.lang.String placeName) throws java.rmi.RemoteException {
		// Copy the incoming values into an Object array if needed.
		Object[] inputObject = new Object[1];
		inputObject[0] = placeName;

		Operation op = Operation.newInstance(_qname_GetWeatherByPlaceName, _type_GetWeatherByPlaceName, _type_GetWeatherByPlaceNameResponse);
		_prepOperation(op);
		op.setProperty(Operation.SOAPACTION_URI_PROPERTY, "http://www.webservicex.net/GetWeatherByPlaceName");
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
		com.datacomm.weatherExample.stubs.WeatherForecasts result;
		// Convert the result into the right Java type.
		// Unwrapped return value
		Object[] getWeatherByPlaceNameResultObj = (Object[]) ((Object[])resultObj)[0];
		if (getWeatherByPlaceNameResultObj == null) {
			result = null;
		} else {
			result = new com.datacomm.weatherExample.stubs.WeatherForecasts();
			float a_float;
			Object latitudeObj = getWeatherByPlaceNameResultObj[0];
			a_float = ((java.lang.Float)latitudeObj).floatValue();
			result.setLatitude(a_float);
			float a_float2;
			Object longitudeObj = getWeatherByPlaceNameResultObj[1];
			a_float2 = ((java.lang.Float)longitudeObj).floatValue();
			result.setLongitude(a_float2);
			float a_float3;
			Object allocationFactorObj = getWeatherByPlaceNameResultObj[2];
			a_float3 = ((java.lang.Float)allocationFactorObj).floatValue();
			result.setAllocationFactor(a_float3);
			java.lang.String string;
			Object fipsCodeObj = getWeatherByPlaceNameResultObj[3];
			string = (java.lang.String)fipsCodeObj;
			result.setFipsCode(string);
			java.lang.String string2;
			Object placeNameObj = getWeatherByPlaceNameResultObj[4];
			string2 = (java.lang.String)placeNameObj;
			result.setPlaceName(string2);
			java.lang.String string3;
			Object stateCodeObj = getWeatherByPlaceNameResultObj[5];
			string3 = (java.lang.String)stateCodeObj;
			result.setStateCode(string3);
			java.lang.String string4;
			Object statusObj = getWeatherByPlaceNameResultObj[6];
			string4 = (java.lang.String)statusObj;
			result.setStatus(string4);
			com.datacomm.weatherExample.stubs.ArrayOfWeatherData arrayOfWeatherData;
			Object[] detailsObj = (Object[]) getWeatherByPlaceNameResultObj[7];
			if (detailsObj == null) {
				arrayOfWeatherData = null;
			} else {
				arrayOfWeatherData = new com.datacomm.weatherExample.stubs.ArrayOfWeatherData();
				com.datacomm.weatherExample.stubs.WeatherData[] weatherDataArray;
				Object[] weatherDataObj = (Object[]) detailsObj[0];
				if (weatherDataObj == null) {
					weatherDataArray = null;
				} else {
					int weatherDataArraySize = weatherDataObj.length;
					weatherDataArray = new com.datacomm.weatherExample.stubs.WeatherData[weatherDataArraySize];
					for (int weatherDataArrayIndex = 0; 
						weatherDataArrayIndex < weatherDataArraySize; 
						++weatherDataArrayIndex) {
						if (weatherDataObj[weatherDataArrayIndex] == null) {
							weatherDataArray[weatherDataArrayIndex] = null;
						} else {
							weatherDataArray[weatherDataArrayIndex] = new com.datacomm.weatherExample.stubs.WeatherData();
							java.lang.String string5;
							Object dayObj = ((Object[])weatherDataObj[weatherDataArrayIndex])[0];
							string5 = (java.lang.String)dayObj;
							weatherDataArray[weatherDataArrayIndex].setDay(string5);
							java.lang.String string6;
							Object weatherImageObj = ((Object[])weatherDataObj[weatherDataArrayIndex])[1];
							string6 = (java.lang.String)weatherImageObj;
							weatherDataArray[weatherDataArrayIndex].setWeatherImage(string6);
							java.lang.String string7;
							Object maxTemperatureFObj = ((Object[])weatherDataObj[weatherDataArrayIndex])[2];
							string7 = (java.lang.String)maxTemperatureFObj;
							weatherDataArray[weatherDataArrayIndex].setMaxTemperatureF(string7);
							java.lang.String string8;
							Object minTemperatureFObj = ((Object[])weatherDataObj[weatherDataArrayIndex])[3];
							string8 = (java.lang.String)minTemperatureFObj;
							weatherDataArray[weatherDataArrayIndex].setMinTemperatureF(string8);
							java.lang.String string9;
							Object maxTemperatureCObj = ((Object[])weatherDataObj[weatherDataArrayIndex])[4];
							string9 = (java.lang.String)maxTemperatureCObj;
							weatherDataArray[weatherDataArrayIndex].setMaxTemperatureC(string9);
							java.lang.String string10;
							Object minTemperatureCObj = ((Object[])weatherDataObj[weatherDataArrayIndex])[5];
							string10 = (java.lang.String)minTemperatureCObj;
							weatherDataArray[weatherDataArrayIndex].setMinTemperatureC(string10);
						}
					}
				}
				arrayOfWeatherData.setWeatherData(weatherDataArray);
			}
			result.setDetails(arrayOfWeatherData);
		}
		return result;
	}
	// 
	//  End user methods
	// 

	protected static final QName _qname_AllocationFactor = new QName("http://www.webservicex.net", "AllocationFactor");
	protected static final QName _qname_Day = new QName("http://www.webservicex.net", "Day");
	protected static final QName _qname_Details = new QName("http://www.webservicex.net", "Details");
	protected static final QName _qname_FipsCode = new QName("http://www.webservicex.net", "FipsCode");
	protected static final QName _qname_GetWeatherByPlaceName = new QName("http://www.webservicex.net", "GetWeatherByPlaceName");
	protected static final QName _qname_GetWeatherByPlaceNameResponse = new QName("http://www.webservicex.net", "GetWeatherByPlaceNameResponse");
	protected static final QName _qname_GetWeatherByPlaceNameResult = new QName("http://www.webservicex.net", "GetWeatherByPlaceNameResult");
	protected static final QName _qname_GetWeatherByZipCode = new QName("http://www.webservicex.net", "GetWeatherByZipCode");
	protected static final QName _qname_GetWeatherByZipCodeResponse = new QName("http://www.webservicex.net", "GetWeatherByZipCodeResponse");
	protected static final QName _qname_GetWeatherByZipCodeResult = new QName("http://www.webservicex.net", "GetWeatherByZipCodeResult");
	protected static final QName _qname_Latitude = new QName("http://www.webservicex.net", "Latitude");
	protected static final QName _qname_Longitude = new QName("http://www.webservicex.net", "Longitude");
	protected static final QName _qname_MaxTemperatureC = new QName("http://www.webservicex.net", "MaxTemperatureC");
	protected static final QName _qname_MaxTemperatureF = new QName("http://www.webservicex.net", "MaxTemperatureF");
	protected static final QName _qname_MinTemperatureC = new QName("http://www.webservicex.net", "MinTemperatureC");
	protected static final QName _qname_MinTemperatureF = new QName("http://www.webservicex.net", "MinTemperatureF");
	protected static final QName _qname_PlaceName = new QName("http://www.webservicex.net", "PlaceName");
	protected static final QName _qname_StateCode = new QName("http://www.webservicex.net", "StateCode");
	protected static final QName _qname_Status = new QName("http://www.webservicex.net", "Status");
	protected static final QName _qname_WeatherData = new QName("http://www.webservicex.net", "WeatherData");
	protected static final QName _qname_WeatherImage = new QName("http://www.webservicex.net", "WeatherImage");
	protected static final QName _qname_ZipCode = new QName("http://www.webservicex.net", "ZipCode");
	protected static final Element _type_GetWeatherByZipCode;
	protected static final Element _type_GetWeatherByZipCodeResponse;
	protected static final Element _type_GetWeatherByPlaceName;
	protected static final Element _type_GetWeatherByPlaceNameResponse;
	static {
		// Create all of the Type's that this stub uses, once.
		Element _type_ZipCode;
		_type_ZipCode = new Element(_qname_ZipCode, Type.STRING, 0, 1, false);
		ComplexType _complexType_getWeatherByZipCode;
		_complexType_getWeatherByZipCode = new ComplexType();
		_complexType_getWeatherByZipCode.elements = new Element[1];
		_complexType_getWeatherByZipCode.elements[0] = _type_ZipCode;
		_type_GetWeatherByZipCode = new Element(_qname_GetWeatherByZipCode, _complexType_getWeatherByZipCode);
		Element _type_Latitude;
		_type_Latitude = new Element(_qname_Latitude, Type.FLOAT);
		Element _type_Longitude;
		_type_Longitude = new Element(_qname_Longitude, Type.FLOAT);
		Element _type_AllocationFactor;
		_type_AllocationFactor = new Element(_qname_AllocationFactor, Type.FLOAT);
		Element _type_FipsCode;
		_type_FipsCode = new Element(_qname_FipsCode, Type.STRING, 0, 1, false);
		Element _type_PlaceName;
		_type_PlaceName = new Element(_qname_PlaceName, Type.STRING, 0, 1, false);
		Element _type_StateCode;
		_type_StateCode = new Element(_qname_StateCode, Type.STRING, 0, 1, false);
		Element _type_Status;
		_type_Status = new Element(_qname_Status, Type.STRING, 0, 1, false);
		Element _type_Day;
		_type_Day = new Element(_qname_Day, Type.STRING, 0, 1, false);
		Element _type_WeatherImage;
		_type_WeatherImage = new Element(_qname_WeatherImage, Type.STRING, 0, 1, false);
		Element _type_MaxTemperatureF;
		_type_MaxTemperatureF = new Element(_qname_MaxTemperatureF, Type.STRING, 0, 1, false);
		Element _type_MinTemperatureF;
		_type_MinTemperatureF = new Element(_qname_MinTemperatureF, Type.STRING, 0, 1, false);
		Element _type_MaxTemperatureC;
		_type_MaxTemperatureC = new Element(_qname_MaxTemperatureC, Type.STRING, 0, 1, false);
		Element _type_MinTemperatureC;
		_type_MinTemperatureC = new Element(_qname_MinTemperatureC, Type.STRING, 0, 1, false);
		ComplexType _complexType_weatherData;
		_complexType_weatherData = new ComplexType();
		_complexType_weatherData.elements = new Element[6];
		_complexType_weatherData.elements[0] = _type_Day;
		_complexType_weatherData.elements[1] = _type_WeatherImage;
		_complexType_weatherData.elements[2] = _type_MaxTemperatureF;
		_complexType_weatherData.elements[3] = _type_MinTemperatureF;
		_complexType_weatherData.elements[4] = _type_MaxTemperatureC;
		_complexType_weatherData.elements[5] = _type_MinTemperatureC;
		Element _type_WeatherData;
		_type_WeatherData = new Element(_qname_WeatherData, _complexType_weatherData, 0, -1, false);
		ComplexType _complexType_arrayOfWeatherData;
		_complexType_arrayOfWeatherData = new ComplexType();
		_complexType_arrayOfWeatherData.elements = new Element[1];
		_complexType_arrayOfWeatherData.elements[0] = _type_WeatherData;
		Element _type_Details;
		_type_Details = new Element(_qname_Details, _complexType_arrayOfWeatherData, 0, 1, false);
		ComplexType _complexType_weatherForecasts;
		_complexType_weatherForecasts = new ComplexType();
		_complexType_weatherForecasts.elements = new Element[8];
		_complexType_weatherForecasts.elements[0] = _type_Latitude;
		_complexType_weatherForecasts.elements[1] = _type_Longitude;
		_complexType_weatherForecasts.elements[2] = _type_AllocationFactor;
		_complexType_weatherForecasts.elements[3] = _type_FipsCode;
		_complexType_weatherForecasts.elements[4] = _type_PlaceName;
		_complexType_weatherForecasts.elements[5] = _type_StateCode;
		_complexType_weatherForecasts.elements[6] = _type_Status;
		_complexType_weatherForecasts.elements[7] = _type_Details;
		Element _type_GetWeatherByZipCodeResult;
		_type_GetWeatherByZipCodeResult = new Element(_qname_GetWeatherByZipCodeResult, _complexType_weatherForecasts);
		ComplexType _complexType_getWeatherByZipCodeResponse;
		_complexType_getWeatherByZipCodeResponse = new ComplexType();
		_complexType_getWeatherByZipCodeResponse.elements = new Element[1];
		_complexType_getWeatherByZipCodeResponse.elements[0] = _type_GetWeatherByZipCodeResult;
		_type_GetWeatherByZipCodeResponse = new Element(_qname_GetWeatherByZipCodeResponse, _complexType_getWeatherByZipCodeResponse);
		ComplexType _complexType_getWeatherByPlaceName;
		_complexType_getWeatherByPlaceName = new ComplexType();
		_complexType_getWeatherByPlaceName.elements = new Element[1];
		_complexType_getWeatherByPlaceName.elements[0] = _type_PlaceName;
		_type_GetWeatherByPlaceName = new Element(_qname_GetWeatherByPlaceName, _complexType_getWeatherByPlaceName);
		Element _type_GetWeatherByPlaceNameResult;
		_type_GetWeatherByPlaceNameResult = new Element(_qname_GetWeatherByPlaceNameResult, _complexType_weatherForecasts);
		ComplexType _complexType_getWeatherByPlaceNameResponse;
		_complexType_getWeatherByPlaceNameResponse = new ComplexType();
		_complexType_getWeatherByPlaceNameResponse.elements = new Element[1];
		_complexType_getWeatherByPlaceNameResponse.elements[0] = _type_GetWeatherByPlaceNameResult;
		_type_GetWeatherByPlaceNameResponse = new Element(_qname_GetWeatherByPlaceNameResponse, _complexType_getWeatherByPlaceNameResponse);
	}

}
