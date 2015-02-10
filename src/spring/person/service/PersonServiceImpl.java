package spring.person.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import spring.person.dao.PersonDao;
import spring.person.dao.PersonDaoImpl;
import spring.person.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	// 3 Autowired - Spring itself inserts the bean, no need in constructor or setter
//	@Autowired
//	@Qualifier("personDaoImpl")
//
	// 3.4 Alternative using javax annotation except spring:
	@Resource(name="personDaoImpl")
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
