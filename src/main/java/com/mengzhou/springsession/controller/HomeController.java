package com.mengzhou.springsession.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

	 private final String HOME_VIEW_COUNT="HOME_VIEW_COUNT";
	  @GetMapping("")
	  String hello(Principal principal, HttpSession s) {
		 Integer count = 0;
		  if (s.getAttribute(HOME_VIEW_COUNT) != null) {
		     count = (Integer) s.getAttribute(HOME_VIEW_COUNT) +1;
		  }
		 s.setAttribute(HOME_VIEW_COUNT, count);

	    return "Hello "+ principal.getName();
	  }

	@GetMapping("/count")
	String count(Principal principal, HttpSession s) {

		return "Count: "+ s.getAttribute(HOME_VIEW_COUNT);
	}
}

