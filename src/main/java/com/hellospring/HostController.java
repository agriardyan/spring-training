package com.hellospring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/host")
public class HostController {
	
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
	
	List<Employee> list = new ArrayList<>();
	private ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping(value="/employees")
	@ResponseBody
	public String employeesGet(@RequestParam String gender) {
		
		list.add(new Employee("John", "male"));
		list.add(new Employee("Jim", "male"));
		list.add(new Employee("Mila", "female"));
		
		return list.stream().filter(n -> n.getGender().equals("male")).map(n -> n.getName() + "<br>").collect(Collectors.joining());
		
	}
	
	@RequestMapping(value="/employees", method=RequestMethod.POST)
	@ResponseBody
	public String employeesPost(@RequestBody String body) {
		
		list.add(new Employee("John", "male"));
		list.add(new Employee("Jim", "male"));
		list.add(new Employee("Mila", "female"));
		
		try {
			list.add(mapper.readValue(body, Employee.class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list.get(list.size() - 1).getName();
		
	}
	
}
