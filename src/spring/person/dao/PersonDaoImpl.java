package spring.person.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import spring.person.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Person find(Integer id) {
		return em.find(Person.class, id);
	}

	@Override
	public void save(Person person) {
		em.persist(person);
	}
}
