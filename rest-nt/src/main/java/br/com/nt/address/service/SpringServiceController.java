package br.com.nt.address.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/service/greeting")
public class SpringServiceController {
	
	//@Autowired
	//BrqServices b;
	
	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public String getGreeting(@PathVariable String name) {
		String result="Hello "+name;		
		return result;
	}
	
	@RequestMapping(value="/p/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Greeting getShopInJSON(@PathVariable String name) {

		Greeting shop = new Greeting();
		shop.setContent(name);
		shop.setId(2);
		
		return shop;

	}

	@RequestMapping(value = "/post", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public Greeting obl(@RequestBody Greeting gree) {

		
		return gree;

	}

	
}