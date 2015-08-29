package br.com.nt.address.util;


public class AddressUtil {

	public void validateZipCode(String zipCode) throws Exception {
		if (!zipCode.matches("^[0-9]{5}(?:-*[0-9]{3})?$")){
			throw new Exception("CEP inválido");
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
