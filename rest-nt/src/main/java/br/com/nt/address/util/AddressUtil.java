package br.com.nt.address.util;

import br.com.nt.address.model.Address;
import br.com.nt.exception.AddressInvalidException;
import br.com.nt.exception.ZipCodeInvalidException;


public class AddressUtil {

	public void validateZipCode(String zipCode) throws ZipCodeInvalidException {
		if (zipCode == null
				|| !zipCode.matches("^[0-9]{5}(?:-*[0-9]{3})?$")
				|| zipCode.length() != 8
				|| zipCode.matches("00000000")) {
			throw new ZipCodeInvalidException();
		}
	}

	public void validateAddress(Address address) throws AddressInvalidException{
		if (address.getStreet() == null 
			|| address.getNumber() == null
			|| address.getStreet() == null 
			|| address.getCity() == null
			|| address.getState() == null) {

			throw new AddressInvalidException("Favor informar campos obrigatorios "
					+ "(Rua, Numero, Rua, Cidade e Estado)");
		}
	}

	public String putZeroToRight(String zipCode) {

		StringBuilder code = new StringBuilder(zipCode);

		for (int i = code.length() -1; i >= 0; i--) {
			if (code.charAt(i) != '0') {
				code.setCharAt(i, '0');
				break;
			}
		}
		return code.toString();
	}
}
