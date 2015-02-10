package spring.person.dao;

import spring.person.model.Person;

public interface PersonDao {
	Person find(Integer id);
	
	void save(Person person);
}
