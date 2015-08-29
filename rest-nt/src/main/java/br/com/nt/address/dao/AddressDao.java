package br.com.nt.address.dao;

import br.com.nt.address.model.Address;

public interface AddressDao {

	public Address findAddressByZipCode(String zipCode);
	
}
