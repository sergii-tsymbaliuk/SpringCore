package spring.person.dao;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import spring.person.model.Person;

public interface PersonDao extends 
				CrudRepository<Person, Long>
				//JpaRepository<Person, Long> // Extends CrudRepository providing sorting and pagination  
{
	//Removed implementation, was replaced by JpaRepository default implementations
	public List<Person> findByName(String name);
	public List<Person> getByName(String name);	
	
	//public List<Person> findByName(String name);
}
