package br.com.nt.address.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.nt.address.dao.AddressDao;
import br.com.nt.address.model.Address;

public class AddressDaoImpl implements AddressDao {

	public Address findAddressByZipCode(String zipCode) {
		
		//Vamos fingir que existe uma proc aqui, e que o banco restorne algo...

		Address address = null;

		//Para tal fingimento, devo fazer um if forcando o zipCode
		//If nao se faz em DAO...
		if(zipCode.equals("06200000")) {
			address = new Address();
			address.setStreet("Rua das Flores");
			address.setNeighborhood("Ayrosa");
			address.setCity("Osasco");
			address.setState("SP");
			address.setZipCode("06293100");
		}

		return address;
	}
	
	
}
