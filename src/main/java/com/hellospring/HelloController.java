package com.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello")
	public String welcome(ModelMap modelMap) {
		modelMap.put("msg", "ABCD from MODELMAP!");
		return "halo";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/")
	@ResponseBody
	public String welcome() {
		return "halo";
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/test")
	@ResponseBody
	public String test(@RequestParam String name, @RequestParam String pass) {
		return "halo " + name + " pass " + pass;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/test2")
	@ResponseBody
	public String test2(@RequestBody String body) {
		return "body: " + body;
	}
	
//	@RequestMapping(value="/{message}")
//	@ResponseBody
//	public String hello(@PathVariable String message) {
//		return "Your message: " + message;
//	}

}
