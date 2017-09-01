package com.sopra.resa.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sopra.resa.model.Client;
import com.sopra.resa.model.Login;
import com.sopra.resa.service.ServiceClient;

@RunWith(SpringJUnit4ClassRunner.class) // necessite spring-test dans pom.xml
@ContextConfiguration(locations = { "/configSpring.xml" }) // charg� qu'une seule fois!!!
public class ClientTest {

	@Autowired // @Autowired est equivalent � context.getBean(ServiceClient.class);
	private ServiceClient serviceClient; // � tester

	@Test
	public void testRechercherClient() {
		Client client = serviceClient.rechercherClient(1L);
		Assert.assertTrue(client.getId() == 1L);
		System.out.println(client);
	}

	@Test
	public void testRechercherLogin() {
		Login login = serviceClient.rechercherLogin(1L);
		Assert.assertTrue(login.getId() == 1L);
		System.out.println(login);
	}

}
