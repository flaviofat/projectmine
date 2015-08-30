package br.com.nt.address.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import br.com.nt.address.dao.AddressDao;
import br.com.nt.address.model.Address;

public class AddressDaoImpl implements AddressDao {

	private static List<Address> addreses;
	private static Long id = 0l;
	
	static {
		addreses = new ArrayList<Address>();

		Address address = new Address();
		address.setId(0l);
		address.setNumber(99l);
		address.setStreet("Rua das Flores");
		address.setNeighborhood("Ayrosa");
		address.setCity("Osasco");
		address.setState("SP");
		address.setZipCode("06293100");

		addreses.add(address);

	}

	@Override
	public Address findAddressByZipCode(String zipCode) {

		Optional<Address> option = addreses.stream()
				.filter(address -> zipCode.equals(address.getZipCode()))
				.findFirst();

		return option.orElse(null);
	}

	@Override
	public void insertAddress(Address address) {
		id = id + 1;
		address.setId(id);
		addreses.add(address);
	}

	@Override
	public Address findAddressById(Long id) {

		Optional<Address> option = addreses.stream()
				.filter(address -> id.equals(address.getId())).findFirst();

		return option.orElse(null);
	}

	@Override
	public void updateAddress(Address address) {
		addreses.remove(address);
		addreses.add(address);
	}

	@Override
	public void deleteAddress(Long id) {
		Address address = new Address();
		address.setId(id);
		addreses.remove(address);
	}

}
