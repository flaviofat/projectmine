package br.com.nt.address.dao;

import br.com.nt.address.model.Address;

public interface AddressDao {

	public Address findAddressByZipCode(String zipCode);

	public void insertAddress(Address address);

	public Address findAddressById(Long id);

	public void updateAddress(Address address);

	public void deleteAddress(Long id);

}
