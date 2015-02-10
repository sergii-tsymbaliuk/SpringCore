package spring.person.dao;

import java.util.ArrayList;
import java.util.List;

import spring.person.model.Person;

public class PersonDaoTestImpl implements PersonDao {

	List<Person> persons = new ArrayList<>();
	
	
	@Override
	public Person find(Integer id) {
		return persons.get(id);
	}

	@Override
	public void save(Person person) {
		if (person.getId() == null) {
			person.setId(persons.size());
		}
		persons.set(person.getId(), person);
	}

}
