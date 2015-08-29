package br.com.nt.address.service;

import br.com.nt.address.model.Address;

public interface AddressService {

	public Address findAddressByZipCode(String zipCode);
}
