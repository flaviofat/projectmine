package br.com.nt.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(value = "/find/zipcode", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Address findAddressByZipCode(@RequestBody Address zipCode) {
		return addressService.findAddressByZipCode(zipCode.getZipCode());
	}

	@RequestMapping(value = "/insert/address", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public void insertAddress(@RequestBody Address address) {
		addressService.insertAddress(address);
	}

	@RequestMapping(value = "/find/address", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Address findAddressById(@RequestBody Address address) {
		return addressService.findAddressById(address.getId());
	}

	@RequestMapping(value = "/update/address", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public void updateAddress(@RequestBody Address address) {
		addressService.updateAddress(address);
	}

	@RequestMapping(value = "/delete/address", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public void deleteAddressById(@RequestBody Address address) {
		addressService.deleteAddress(address.getId());
	}
}
