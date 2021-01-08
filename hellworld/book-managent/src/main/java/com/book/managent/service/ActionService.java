package com.book.managent.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ActionService {
	
	public String getIntentName(String body) throws Exception {
		JSONObject jsonobjecct=new JSONObject(body);
		
		JSONObject queryResultObject=jsonobjecct.getJSONObject("queryResult");
		
		JSONObject intentObject=queryResultObject.getJSONObject("intent");
		return intentObject.get("displayName").toString();
	}

}
