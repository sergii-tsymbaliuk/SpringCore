package spring.person.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import spring.Application;
import spring.person.model.Person;

public class PersonDaoImpl implements PersonDao {
	private EntityManager em =  Application.EM;

	@Override
	public Person find(Integer id) {
		return em.find(Person.class, id);
	}

	@Override
	public void save(Person person) {
		EntityTransaction t = getTransaction();
		try {
			em.persist(person);
			t.commit();
		} catch (Exception e) {
			if (t.isActive()) {
				t.rollback();
			}
			throw e;
		}

	}

	private EntityTransaction getTransaction() {
		EntityTransaction t = em.getTransaction();
		t.begin();
		return t;
	}

}
