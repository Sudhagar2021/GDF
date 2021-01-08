package com.book.managent.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AuthorUtil {
	//requests
	public static final List<String> listofauthormessages=new ArrayList<>();
	//Response
	public static final List<String> listofauthorselectmessages=new ArrayList<>();

	static {
		listofauthormessages.add("here is list");
		listofauthormessages.add("sure ,here is list");
		listofauthormessages.add(" i found the following authors");
		
		listofauthorselectmessages.add("which one would you like to select");
		listofauthorselectmessages.add("Please choose one of them to continue");
		listofauthorselectmessages.add("I can provide list of books if you choose author");
		
		
	}
	public static String getRandomlist() {
		Integer value=new Random().nextInt(listofauthormessages.size());
		return listofauthormessages.get(value);
	}
	public static String getRandomselection() {
		Integer value=new Random().nextInt(listofauthorselectmessages.size());
		return listofauthorselectmessages.get(value);
	}
}
