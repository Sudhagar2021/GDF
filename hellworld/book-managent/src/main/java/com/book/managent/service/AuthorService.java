package com.book.managent.service;

import java.util.List;
import java.util.StringJoiner;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.managent.domain.Author;
import com.book.managent.repository.AuthorRepository;
import com.book.managent.util.AuthorUtil;
import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;

@Service
@Transactional
public class AuthorService extends DialogflowApp {
	@Autowired
	private AuthorRepository authorRepository;
	private Logger logger=LoggerFactory.getLogger(AuthorService.class);
		
	@ForIntent("Default Welcome Intent")
	//@ForIntent("actions.intent.OPTION")
	public ActionResponse findall(ActionRequest request) {
		logger.info(request.toString());
		System.out.println("Intent Name-->"+ request.getSelectedOption());
		String li = request.getSelectedOption();
		return buildResponse(request, request.getIntent());
		//List<Author> authorlist=authorRepository.findAll();
		//String response="Success";
		/*
		 *  System.out.println("Intent Name-->"+ intentName);
		 * intentName = intentName.replaceAll("\\s", "");
		 * System.out.println("Intent Name After space-->"+ intentName);
		 * if(intentName.contains("use_case")) { intentName = "welcomeMsg"; } try {
		 * intentName = getRes.getVal(intentName); }catch(Exception e) {
		 * 
		 * }
		 */ 
		
		/*
		 * StringBuilder response=new StringBuilder(AuthorUtil.getRandomlist());
		 * StringJoiner sj=new StringJoiner(","); authorlist.forEach(author ->
		 * sj.add(author.toString())); response.append(sj); response.append(". ");
		 * response.append(AuthorUtil.getRandomselection());
		 */
		 
		
	
		
		
	}
	@ForIntent("Use_Case_One") 
	public ActionResponse useCaseOne(ActionRequest request) {
		logger.info(request.toString());		
		return buildResponse(request, request.getIntent());
	}

	@ForIntent("nfl-sunday-ticket")
	public ActionResponse nflSundayTicket(ActionRequest request) {
		logger.info(request.toString());		
		return buildResponse(request, request.getIntent());
	}
	@ForIntent("Games")
	public ActionResponse games(ActionRequest request) {
		logger.info(request.toString());		
		return buildResponse(request, request.getIntent());
	}
	@ForIntent("Monthly")
	public ActionResponse monthly(ActionRequest request) {
		logger.info(request.toString());		
		return buildResponse(request, request.getIntent());
	}
	@ForIntent("Nine")
	public ActionResponse nine(ActionRequest request) {
		logger.info(request.toString());		
		return buildResponse(request, request.getIntent());
	}
	@ForIntent("Nine-No")
	public ActionResponse nineNo(ActionRequest request) {
		logger.info(request.toString());		
		return buildResponse(request, request.getIntent());
	}
	@ForIntent("Nine-Yes")
	public ActionResponse nineYes(ActionRequest request) {
		logger.info(request.toString());		
		return buildResponse(request, request.getIntent());
	}
	@ForIntent("Single")
	public ActionResponse single(ActionRequest request) {
		logger.info(request.toString());		
		return buildResponse(request, request.getIntent());
	}
	@ForIntent("Single-Yes")
	public ActionResponse singleYes(ActionRequest request) {
		logger.info(request.toString());		
		return buildResponse(request, request.getIntent());
	}
	@ForIntent("Passcode")
	public ActionResponse Passcode(ActionRequest request) {
		logger.info(request.toString());		
		return buildResponse(request, request.getIntent());
	}
	public ActionResponse buildResponse(ActionRequest request, String intent) {
		String response = intent;
		ResponseBuilder responseBuilder=getResponseBuilder(request).add(response.toString());
		ActionResponse actionResponse=responseBuilder.build();
		return actionResponse;	
	}

}
