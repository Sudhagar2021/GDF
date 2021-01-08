package com.book.managent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.managent.service.ActionService;
import com.book.managent.service.AuthorService;
import com.book.managent.service.DetectIntentTexts;
import com.book.managent.service.GetResponse;
import com.google.actions.api.ActionRequest;
import com.google.cloud.dialogflow.v2.IntentName;
import com.google.cloud.dialogflow.v2.QueryResult;

@RestController
@RequestMapping("/api/actions")
public class ActionsController {
	@Autowired
	private ActionService actionService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private GetResponse getRes;
	@Autowired
	DetectIntentTexts dt;
private Logger logger=LoggerFactory.getLogger(ActionsController.class);
	@PostMapping
    public ResponseEntity<?> executePostactions(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String body=request.getReader().lines().collect(Collectors.joining());
		logger.info(new JSONObject(body).toString(4));
		Map<String, QueryResult> resp = null;
		String re = null;
		try {
			String intentName=actionService.getIntentName(body);
			
			/*
			 * List<String> texts=new ArrayList<String>(); texts.add(intentName);
			 * 
			 * resp = dt.detectIntentTexts("gdfongenesys-jeuv",texts, "123456789", "en-US");
			 * re = resp.toString();
			 */
			
			
					
			if(intentName.equals("Default Welcome Intent")) {
				String res=authorService.handleRequest(body, getHeaderMap(request)).get();	
				//String sb = authorService.handleReq();
				return new ResponseEntity<String>(res, HttpStatus.OK);
				
				}
				else {
					return new ResponseEntity<String>("Could not process request",HttpStatus.OK);	
				}
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Could not process", HttpStatus.OK);
			
		}
		//return new ResponseEntity<String>("post accepts", HttpStatus.OK);
	}
	
	private Map<String, String> getHeaderMap(HttpServletRequest request) {
		Map<String,String> headermap=new HashMap<>();
		Enumeration<?> headerEnumeration=request.getHeaderNames();
		while(headerEnumeration.hasMoreElements()) {
			String key=(String)headerEnumeration.nextElement();
			String value= request.getHeader(key);
			headermap.put(key, value);
		}
		
		// TODO Auto-generated method stub
		return headermap;
	}

	@GetMapping(path="/{text}")
    public ResponseEntity<?> executeGetactions(@PathVariable String text){
		
		return new ResponseEntity<String>("post accepts", HttpStatus.OK);
		
	}
}
