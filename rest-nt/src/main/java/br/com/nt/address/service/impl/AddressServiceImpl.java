package br.com.nt.address.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.address.dao.AddressDao;
import br.com.nt.address.model.Address;
import br.com.nt.address.service.AddressService;
import br.com.nt.address.util.AddressUtil;
import br.com.nt.exception.AddressInvalidException;
import br.com.nt.exception.ZipCodeInvalidException;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private AddressUtil addressUtil;

	@Override
	public Address findAddressByZipCode(String zipCode)	throws ZipCodeInvalidException {

		Address address;

		do {

			addressUtil.validateZipCode(zipCode);
			address = addressDao.findAddressByZipCode(zipCode);

			if (address == null)
				zipCode = addressUtil.putZeroToRight(zipCode);

		} while (address == null);

		return address;
	}

	@Override
	public void insertAddress(Address address) {
		addressUtil.validateAddress(address);
		addressUtil.validateZipCode(address.getZipCode());
		addressDao.insertAddress(address);
	}

	@Override
	public Address findAddressById(Long id) {
		Address address = addressDao.findAddressById(id);

		if (address == null){
			throw new AddressInvalidException("Endereco nao encontrado");
		}

		return address;
	}

	@Override
	public void updateAddress(Address address) {
		addressUtil.validateAddress(address);
		addressUtil.validateZipCode(address.getZipCode());
		addressDao.updateAddress(address);
	}

	@Override
	public void deleteAddress(Long id) {
		addressDao.deleteAddress(id);
	}
}
