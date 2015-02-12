package spring.person.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.person.model.Person;

public interface PersonDao extends JpaRepository<Person, Long> 
{

	public List<Person> findByName(String name);
}
