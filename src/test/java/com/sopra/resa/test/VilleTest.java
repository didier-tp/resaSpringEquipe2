package com.sopra.resa.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sopra.resa.model.Ville;
import com.sopra.resa.service.ServiceClient;

@RunWith(SpringJUnit4ClassRunner.class) // necessite spring-test dans pom.xml
@ContextConfiguration(locations = { "/configSpring.xml" }) // charg� qu'une seule fois!!!
public class VilleTest {

	@Autowired // @Autowired est equivalent � context.getBean(ServiceClient.class);
	private ServiceClient serviceClient; // � tester

	@Test
	public void testRechercherVille() {
		Ville ville = serviceClient.rechercherVille(1L);
		Assert.assertTrue(ville.getId() == 1L);
		System.out.println(ville);
	}
}
