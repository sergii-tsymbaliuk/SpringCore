package spring.person.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.person.Person;
import spring.person.dao.PersonDao;


//@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS ) 
@Service
public class PersonService {
	
	@Resource
	PersonDao personDao;

	@CachePut(value="persons",key="#p.id")
	@Transactional
	@Secured("ROLE_ADMIN")
	public Person save(Person p) {
		if (p.getCreateDate() == null) 
			p.setCreateDate(new Date());
		return personDao.save(p);
	}

//	
//	@Transactional
//	@Secured("ROLE_ADMIN")
//	public <S extends Person> Iterable<S> save(Iterable<S> entities) {
//		return personDao.save(entities);
//	}

	@Cacheable("persons")
	public Person findOne(Long id) throws Exception{
		if (id <=0 ){
			throw new Exception("id must be > 0");
		}
		return personDao.findOne(id);
	}

	public boolean exists(Long id) {
		return personDao.exists(id);
	}
	
	//@Cacheable("persons")
	public Iterable<Person> findAll() {
		return personDao.findAll();
	}

	//@Cacheable("persons")
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

	@CacheEvict(value = "persons", key = "#id")
	@Transactional
	@Secured(value = { "ROLE_ADMIN" })
	public void delete(Person entity) {
		personDao.delete(entity);
	}

	@CacheEvict(value = "persons", key = "#id")
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
