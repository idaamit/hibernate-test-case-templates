package org.hibernate.bugs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh123Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		final LocalDateTime creationDate = LocalDateTime.of(2018, 12, 26, 8, 10, 40, 340);
		final DatesTbl datesTbl = entityManager.merge(new DatesTbl(creationDate));
		DatesTbl dbDatesTbl = entityManager.createQuery(
				"select e " +
						"from DatesTbl e", DatesTbl.class)
				.getSingleResult();
		final DatesTbl datesTbl2 = entityManager.merge(new DatesTbl(creationDate));
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
