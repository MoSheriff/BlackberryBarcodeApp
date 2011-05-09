// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JSR-172 Reference Implementation wscompile 1.0, using: JAX-RPC Standard Implementation (1.1, build R59)

package com.datacomm.weatherExample.stubs;


public class WeatherForecasts {
    protected float latitude;
    protected float longitude;
    protected float allocationFactor;
    protected java.lang.String fipsCode;
    protected java.lang.String placeName;
    protected java.lang.String stateCode;
    protected java.lang.String status;
    protected com.datacomm.weatherExample.stubs.ArrayOfWeatherData details;
    
    public WeatherForecasts() {
    }
    
    public WeatherForecasts(float latitude, float longitude, float allocationFactor, java.lang.String fipsCode, java.lang.String placeName, java.lang.String stateCode, java.lang.String status, com.datacomm.weatherExample.stubs.ArrayOfWeatherData details) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.allocationFactor = allocationFactor;
        this.fipsCode = fipsCode;
        this.placeName = placeName;
        this.stateCode = stateCode;
        this.status = status;
        this.details = details;
    }
    
    public float getLatitude() {
        return latitude;
    }
    
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    
    public float getLongitude() {
        return longitude;
    }
    
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    
    public float getAllocationFactor() {
        return allocationFactor;
    }
    
    public void setAllocationFactor(float allocationFactor) {
        this.allocationFactor = allocationFactor;
    }
    
    public java.lang.String getFipsCode() {
        return fipsCode;
    }
    
    public void setFipsCode(java.lang.String fipsCode) {
        this.fipsCode = fipsCode;
    }
    
    public java.lang.String getPlaceName() {
        return placeName;
    }
    
    public void setPlaceName(java.lang.String placeName) {
        this.placeName = placeName;
    }
    
    public java.lang.String getStateCode() {
        return stateCode;
    }
    
    public void setStateCode(java.lang.String stateCode) {
        this.stateCode = stateCode;
    }
    
    public java.lang.String getStatus() {
        return status;
    }
    
    public void setStatus(java.lang.String status) {
        this.status = status;
    }
    
    public com.datacomm.weatherExample.stubs.ArrayOfWeatherData getDetails() {
        return details;
    }
    
    public void setDetails(com.datacomm.weatherExample.stubs.ArrayOfWeatherData details) {
        this.details = details;
    }
}