package spring.person.service;

import spring.person.model.Person;

public class PersonServiceTestImpl implements PersonService {

	@Override
	public Person find(Integer id) {
		System.out.println("Stub for Finding person with id=" + id);
		Person person = new Person();
		person.setId(id);
		return person;
	}

	@Override
	public void save(Person person) {
		System.out.println("Stub for Finding person " + person);
	}

}
