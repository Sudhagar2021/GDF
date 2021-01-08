package com.book.managent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:response.properties")
public class GetResponse {

	@Autowired
	private Environment env;
	
	public String getVal(String req) {
		String res = env.getProperty(req);
		return res;
	}
}
