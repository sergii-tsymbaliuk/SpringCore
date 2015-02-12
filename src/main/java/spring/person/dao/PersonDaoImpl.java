package spring.person.dao;

import spring.person.model.Person;

public class PersonDaoImpl implements PersonCustomDao {

	@Override
	public void doSomethingSpecific(Person p) {
		System.out.println("doing something specific");

	}

}
