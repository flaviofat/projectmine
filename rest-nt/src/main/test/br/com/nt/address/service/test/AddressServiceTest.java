package br.com.nt.address.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.nt.address.model.Address;
import br.com.nt.address.service.AddressService;
import br.com.nt.exception.AddressInvalidException;
import br.com.nt.exception.ZipCodeInvalidException;



public class AddressServiceTest {
	
	private AddressService service;
	
	private ApplicationContext context;
	
	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("rest-servlet.xml");
		service = (AddressService) context.getBean("addressService");
	}

	@Test
	public void findAddressByZipCodeAndReturnAaddress(){
		Address address = service.findAddressByZipCode("06293100");
		Assert.assertNotNull(address);
	}

	@Test
	public void findAddressByZipCodeAndPutZerosToRightAndReturnAaddress(){
		Address address = service.findAddressByZipCode("06293111");
		Assert.assertNotNull(address);
	}

	@Test(expected = ZipCodeInvalidException.class)
	public void findAddressByZipCodeWithInputWrongAndReturnError(){
		Address address = service.findAddressByZipCode("abcd");
	}
	
	@Test(expected = ZipCodeInvalidException.class)
	public void findAddressByZipCodeWithInputNotFormattedAndReturnError(){
		Address address = service.findAddressByZipCode("06.293-100");
	}

	@Test
	public void insertAddressCorrect(){
		Address address = new Address();
		address.setNumber(99l);
		address.setStreet("Rua das Flores");
		address.setNeighborhood("Ayrosa");
		address.setCity("Osasco");
		address.setState("SP");
		address.setZipCode("06293100");
		address.setComplement("house");
		service.insertAddress(address);
	}

	@Test(expected = ZipCodeInvalidException.class)
	public void insertAddressWithZipCodeWrong(){
		Address address = new Address();
		address.setNumber(99l);
		address.setStreet("Rua das Flores");
		address.setNeighborhood("Ayrosa");
		address.setCity("Osasco");
		address.setState("SP");
		address.setZipCode("abcd");
		address.setComplement("house");
		service.insertAddress(address);
	}

	@Test(expected = AddressInvalidException.class)
	public void insertAddressWithAddressWithoutRequiredFields(){
		Address address = new Address();
		address.setNumber(null);
		address.setStreet(null);
		address.setNeighborhood("Ayrosa");
		address.setCity(null);
		address.setState(null);
		address.setZipCode("02931101");
		address.setComplement("house");
		service.insertAddress(address);
	}

	@Test
	public void updateAddressCorrect(){
		Address address = new Address();
		address.setNumber(0l);
		address.setStreet("Rua das ruas");
		address.setNeighborhood("Lapa");
		address.setCity("Sao Paulo");
		address.setState("SP");
		address.setZipCode("05291111");
		address.setComplement("house");
		service.updateAddress(address);
	}
	
	@Test(expected = ZipCodeInvalidException.class)
	public void updateAddressWithZipCodeWrong(){
		Address address = new Address();
		address.setNumber(0l);
		address.setStreet("Rua das Flores");
		address.setNeighborhood("Ayrosa");
		address.setCity("Osasco");
		address.setState("SP");
		address.setZipCode("abcd");
		address.setComplement("house");
		service.updateAddress(address);
	}
	
	@Test
	public void findAddressById(){
		Address address = service.findAddressById(0l);
		Assert.assertNotNull(address);
	}

	@Test(expected = AddressInvalidException.class)
	public void findAddressByIdAndReturnNotFound(){
		Address address = service.findAddressById(999l);
	}
	
	@Test
	public void deleteAddressById(){
		service.deleteAddress(99l);
	}
}
