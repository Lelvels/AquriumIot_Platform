package com.luv2code.mvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotGoodController {
	
	@RequestMapping("/showForm")
	public String displayTheForm() {
		return "notgood";
	}
	
}
