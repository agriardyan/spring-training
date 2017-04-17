package com.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/host")
public class Host {
	
	@RequestMapping(value="")
	@ResponseBody
	public String index() {
		return "ok";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	@ResponseBody
	public String helloGet(@RequestParam String message) {
		return "Get Message " + message;
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.POST)
	@ResponseBody
	public String helloPost(@RequestParam String message) {
		return "Post Message " + message;
	}
	
	@RequestMapping(value="/hello/{msg}", method=RequestMethod.PUT)
	@ResponseBody
	public String helloAny(@PathVariable String msg) {
		return "Put Message " + msg;
	}
	
}
