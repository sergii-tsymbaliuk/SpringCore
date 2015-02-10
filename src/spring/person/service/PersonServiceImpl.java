package spring.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.person.dao.PersonDao;
import spring.person.dao.PersonDaoImpl;
import spring.person.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	@Qualifier("personDaoImpl")
	private PersonDao personDao = new PersonDaoImpl();

	@Override
	public Person find(Integer id) {
		System.out.println("Finding person with id=" + id);
		return personDao.find(id);
	}

	@Override
	@Transactional
	public void save(Person person) {
		System.out.println("Finding person " + person);
		personDao.save(person);
	}
}
