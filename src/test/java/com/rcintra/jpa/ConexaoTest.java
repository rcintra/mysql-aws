package com.rcintra.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConexaoTest {
	
	private EntityManagerFactory emFactory;

	@Before
	public void begin() {
		emFactory = Persistence.createEntityManagerFactory("mysql-aws");
	}
	
	@Test
	public void connection() {
		EntityManager em = emFactory.createEntityManager();
		em.close();
	}
	
	@After
	public void end() {
		emFactory.close();
	}
}
