package br.com.nt.address.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.nt.address.model.Address;
import br.com.nt.address.service.AddressService;
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
	public void toReturnAddress(){
		Address address = service.findAddressByZipCode("06293100");
		Assert.assertNotNull(address);
	}

	@Test
	public void toReturnAddressPutRightZeros(){
		Address address = service.findAddressByZipCode("06293111");
		Assert.assertNotNull(address);
	}

	@Test(expected = ZipCodeInvalidException.class)
	public void toReturnAerrorByInputDiferentNumbers(){
		Address address = service.findAddressByZipCode("abcd");
	}
	
	@Test(expected = ZipCodeInvalidException.class)
	public void toReturnAerrorByInputNotFormatted(){
		Address address = service.findAddressByZipCode("06.293-100");
	}
}
