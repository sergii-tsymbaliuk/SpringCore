package spring.person.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.person.Person;
import spring.person.dao.PersonDao;


@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS ) 
@Service
public class PersonService {
	
	@Resource
	PersonDao personDao;

	@Transactional
	public <S extends Person> S save(S entity) {
		if (entity.getCreateDate() == null) 
			entity.setCreateDate(new Date());
		return personDao.save(entity);
	}

	public <S extends Person> Iterable<S> save(Iterable<S> entities) {
		return personDao.save(entities);
	}

	public Person findOne(Long id) throws Exception{
		if (id <=0 ){
			throw new Exception("id must be > 0");
		}
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

	@Transactional
	@Secured(value = { "ROLE_ADMIN" })	
	public void delete(Long id) {
		personDao.delete(id);
	}

	@Transactional
	@Secured(value = { "ROLE_ADMIN" })
	public void delete(Person entity) {
		personDao.delete(entity);
	}

	@Transactional
	@Secured(value = { "ROLE_ADMIN" })	
	public void delete(Iterable<? extends Person> entities) {
		personDao.delete(entities);
	}

	@Transactional
	@Secured(value = { "ROLE_ADMIN" })	
	public void deleteAll() {
		personDao.deleteAll();
	}

	public PersonService() {
		super();
		System.out.println("new PersonService() ");
	}

	
}
