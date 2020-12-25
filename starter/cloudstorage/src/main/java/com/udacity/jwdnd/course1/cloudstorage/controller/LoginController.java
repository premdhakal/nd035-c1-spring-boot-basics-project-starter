package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping("/login")
	public String getLoginPage(Model model, String error, String logout) {
		  if (error != null) {
			  model.addAttribute("error", "Invalid username or password");
			  logger.info("LoginController::getLoginPage() -> Error Logging in");
		  }
		  
	      if (logout != null)
	      {
	    	   model.addAttribute("message", "You have been logged out");
	      }
	           
	        return "login";
	}

	/*
	 * @PostMapping(value = "/logout") public String
	 * getLogoutPage(HttpServletRequest request, HttpServletResponse response) {
	 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 * if (auth != null) {
	 * logger.info("LoginController::getLogoutPage() -> Logging out"); new
	 * SecurityContextLogoutHandler().logout(request, response, auth); } return
	 * "redirect:/login?logout=true"; }
	 */
}