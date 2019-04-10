package net.txeis.unity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

	/**
	 * Returns the main index view which contains 
	 * the bundled javascript file
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String index() {
		return "index";
	}
}
