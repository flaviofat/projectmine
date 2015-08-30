package br.com.nt.address.service;

import br.com.nt.address.model.Address;

public interface AddressService {

	public Address findAddressByZipCode(String zipCode);

	public void insertAddress(Address address);

	public Address findAddressById(Long id);

	public void updateAddress(Address address);

	public void deleteAddress(Long id);
}
