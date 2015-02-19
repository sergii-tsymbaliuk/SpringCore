package spring.person.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import spring.person.dao.PersonDao;
import spring.person.model.Person;


@Service
public class PersonService {
	
	@Resource
	PersonDao personDao;

	public <S extends Person> S save(S entity) {
		if (entity.getCreateDate() == null) 
			entity.setCreateDate(new Date());
		return personDao.save(entity);
	}

	public <S extends Person> Iterable<S> save(Iterable<S> entities) {
		return personDao.save(entities);
	}

	public Person findOne(Long id) {
		return personDao.findOne(id);
	}

	public boolean exists(Long id) {
		return personDao.exists(id);
	}

	public Iterable<Person> findAll() {
		return personDao.findAll();
	}

	public Iterable<Person> findAll(Iterable<Long> ids) {
		return personDao.findAll(ids);
	}

	public long count() {
		return personDao.count();
	}

	public void delete(Long id) {
		personDao.delete(id);
	}

	public void delete(Person entity) {
		personDao.delete(entity);
	}

	public void delete(Iterable<? extends Person> entities) {
		personDao.delete(entities);
	}

	public void deleteAll() {
		personDao.deleteAll();
	}

}
