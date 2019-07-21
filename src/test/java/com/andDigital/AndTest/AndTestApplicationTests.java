package com.andDigital.AndTest;

import com.andDigital.AndTest.model.Phone;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AndTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class AndTestApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}

	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "http://localhost:" + port + "/api/v1/";
	}

	@Test
	public void testGetAllPhoneNumbers() {

		Phone[] response = restTemplate.getForObject(
				getRootUrl() + "/getAllPhoneNumbers",
				Phone[].class);
		Assert.assertNotNull(response);
	}

	@Test
	public void testGetPhoneNumberByPersonId() {

		Phone [] phone = restTemplate.getForObject(
				getRootUrl() + "/phoneNumber/1/",
				Phone[].class);
		phone[0].getPhoneId();
		Assert.assertNotNull(phone[0]);
	}

	@Test
	public void testActivatePhoneNumber() {

		Phone phoneBefore = Util.phoneRepo.get(3);
		boolean beforeStatus = phoneBefore.isActiveStatus();
		restTemplate.put(getRootUrl() + "/activatePhoneNumber/4/", phoneBefore);
		Phone[] phone  = restTemplate.getForObject(getRootUrl() + "/phoneNumber/4/", Phone[].class);
		Assert.assertNotNull(phone[0]);
		Assert.assertNotEquals(beforeStatus, phone[0].isActiveStatus());
	}


	// complication with @Before
	@BeforeClass
	public static void init() {
		Util.init();
	}

}
