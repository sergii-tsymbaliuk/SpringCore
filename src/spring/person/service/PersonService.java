package spring.person.service;

import spring.person.model.Person;

public interface PersonService {
	
	Person find(Integer id);

	void save(Person person);
}
