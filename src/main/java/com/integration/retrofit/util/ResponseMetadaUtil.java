package com.integration.retrofit.util;

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseMetadaUtil {
	
	private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();
	
	public ArrayList<HashMap<String, String>> getMetadata() {
		return metadata;
	}
	
	public void setMetada(String statusCode, String statusText, String statusMessage, String componentOrigin) {
		HashMap<String, String> mapa = new HashMap<String, String>();
		
		mapa.put("statusCode", statusCode);
		mapa.put("statusText", statusText);
		mapa.put("statusMessage", statusMessage);
		mapa.put("componentOrigin", componentOrigin);
		
		metadata.add(mapa);
	}
}
