package org.taek.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LinearRegressionController {

	private static final Logger logger = LoggerFactory.getLogger(LinearRegressionController.class);
	
	@RequestMapping(method=RequestMethod.GET, value="/linearRegression/oneValue")
	public void oneValueLinearRegression() {
		
		logger.error("in oneValueLinearRegression" );
		
		//return "oneValue";
		
	}
	
}
