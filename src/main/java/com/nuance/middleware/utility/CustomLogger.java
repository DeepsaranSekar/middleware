package com.nuance.middleware.utility;

import org.json.JSONObject;  

public class CustomLogger {
	
	
	public static JSONObject logMessageAsJSON(String loglevel, String message, String variable) {
		String jsonRequestString = "{\""+loglevel+"\" : \""+message+variable+"\" }";
		JSONObject json = new JSONObject(jsonRequestString);
		return json;
	}
	
	public static String logMessageAsString(String loglevel, String message, String variable) {
		String updatedString = "{"+loglevel+" : "+message+variable+" }";
		return updatedString;
	}

}
