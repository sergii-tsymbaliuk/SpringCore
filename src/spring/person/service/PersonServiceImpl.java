package spring.person.service;

import org.springframework.beans.factory.annotation.Autowired;

import spring.person.dao.PersonDao;
import spring.person.dao.PersonDaoImpl;
import spring.person.model.Person;

public class PersonServiceImpl implements PersonService {
	// 3 Autowired - Spring itself inserts the bean, no need in constructor or setter
	@Autowired
	private PersonDao personDao = new PersonDaoImpl();

	@Override
	public Person find(Integer id) {
		System.out.println("Finding person with id=" + id);
		return personDao.find(id);
	}

	@Override
	public void save(Person person) {
		System.out.println("Finding person " + person);
		personDao.save(person);
	}

//	public PersonDao getPersonDao() {
//		return personDao;
//	}
//
//	public void setPersonDao(PersonDao personDao) {
//		System.out.println("Setter injection");
//		this.personDao = personDao;
//	}
//
//	public PersonServiceImpl(PersonDao personDao) {
//		super();
//		System.out.println("Constructor injections");
//		this.personDao = personDao;
//	}
}
