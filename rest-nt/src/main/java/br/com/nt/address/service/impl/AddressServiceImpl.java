package br.com.nt.address.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.nt.address.dao.AddressDao;
import br.com.nt.address.model.Address;
import br.com.nt.address.service.AddressService;
import br.com.nt.address.util.AddressUtil;

public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private AddressUtil addressUtil;

	public Address findAddressByZipCode(String zipCode) {

		Address address = new Address();

		try {
			addressUtil.validateZipCode(zipCode);
		} catch (Exception e) {
			address.setMessageError(e.getMessage());
			return address;
		}

		
		do {

			address = addressDao.findAddressByZipCode(zipCode);
			if (address == null)
				zipCode = addressUtil.putZeroToRight(zipCode);

		} while (address == null); 

		return address;
	}
}
