package spring.person.service;

import spring.person.dao.PersonDao;
import spring.person.dao.PersonDaoImpl;
import spring.person.model.Person;

public class PersonServiceImpl implements PersonService {
	
	PersonDao personDao = new PersonDaoImpl();

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

}
