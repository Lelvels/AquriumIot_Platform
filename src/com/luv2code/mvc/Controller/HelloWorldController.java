package com.luv2code.mvc.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//Create the showing form controller method
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//Process the form 
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//New controller method to read form data
	//add data to the model
	@RequestMapping("/processFormVersion2")
	public String letsShoutDude(HttpServletRequest request, Model model)
	{
		//read request param from the HTML form
		String theName = request.getParameter("studentName");
		//Convert all to upper case
		theName = theName.toUpperCase();
		
		String result = "Yo! " + theName;
		//add message to the model
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormVersion3")
	public String letsShoutDudeVersion3(
			@RequestParam("studentName") String theName, Model model)
	{
		//Convert all to upper case
		theName = theName.toUpperCase();
		
		String result = "Yo! " + theName;
		//add message to the model
		model.addAttribute("message", result);
		return "helloworld";
	}
}
