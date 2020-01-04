package org.taek.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
		@ExceptionHandler(Exception.class)
		public ModelAndView common(Exception ex) {
			logger.info(ex.toString());
			System.out.println("wegawhrherh");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/error_common");
			mav.addObject("exception",ex);
			
			return mav;
		}
}
