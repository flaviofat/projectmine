package br.com.nt.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.nt.address.model.Address;
import br.com.nt.address.service.AddressService;


@RestController
@RequestMapping("/services")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/find/address", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseBody
	public Address findAddressByZipCode(@RequestBody Address zipCode) {
		return addressService.findAddressByZipCode(zipCode.getZipCode());
	}

	@RequestMapping(value = "/insert/address", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseBody
	public void insertAddress(@RequestBody Address address) {
		 addressService.insertAddress(address);
	}
}
