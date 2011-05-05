package com.datacomm.weatherExample.gui;

import com.datacomm.weatherExample.stubs.WeatherForecastSoap_Stub;
import com.datacomm.weatherExample.stubs.WeatherForecasts;

import mypackage.MyApp;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.Menu;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.MainScreen;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public final class MyScreen extends MainScreen
{
	private WeatherForecastSoap_Stub stub = null;
	private WeatherForecasts response = null;
	private String location = "Boston";
	private RichTextField field;
	private MyApp app;
	private EditField editSearch;
	private RichTextField searchString;
	
    public MyScreen(MyApp application)
    {   
    	super(DEFAULT_MENU | DEFAULT_CLOSE);
    	this.app = application;
    	
    	setTitle(new LabelField("Contacting a weather service", LabelField.ELLIPSIS | LabelField.USE_ALL_WIDTH));
    	field = new RichTextField("");
    	searchString = new RichTextField("");
    	add(editSearch = new EditField(EditField.FILTER_DEFAULT));
    	add(searchString);
    	add(field);
    	
    	
    	
    }
    
	public void makeMenu(Menu menu, int instance) {
		menu.add(getResponse);
	}
	
    public MenuItem getResponse = new MenuItem("Get response",100, 1) {
		public void run() {
			location = editSearch.getText();
			if (location.length() == 0) {
				return;
			}
			searchString.setText("Querying for location: " + location);
			//field.setText(location);
			editSearch.setText("");
			try {
				if (stub == null) {
					stub = new WeatherForecastSoap_Stub();
				}
				response = stub.getWeatherByPlaceName(location);
				searchString.setText("Found: " + response.getPlaceName() + ", " + response.getStateCode());
				field.setText("Latitude: " + Float.toString(response.getLatitude()) + " Longitude: " + Float.toString(response.getLongitude())) ;
				//editList.insert(2);
				//myCallback.insert(response.getStatus(), 2);
				//editList.setSelectedIndex(0);
			} catch (Exception ex) {
				Dialog.alert("Unable to connect to service. Service returned:\n"
						+ ex.toString());
			}
		}
	};                                   
		
}