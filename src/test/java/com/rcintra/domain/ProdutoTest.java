package com.rcintra.domain;

import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.rcintra.jpa.PersistenceManager;

/**
 * Unit test for produto
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest {

	private static EntityManager em;
	
	@BeforeClass
	public static void init() {
		em = PersistenceManager.INSTANCE.getEntityManager();
	}

	@Test
	public void add_produto() {

		Produto produto = new Produto();
		produto.setNome("1010");
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}
	
	@Test
	public void remove_produto() {
		
		Produto produto = 
				(Produto)
					em.createNamedQuery("findProdutoByNome")
					.setParameter("prodName", "1010")
					.getSingleResult();
		
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
	}

	@AfterClass
	public static void close() {
		em.close();
		PersistenceManager.INSTANCE.close();
	}

}
