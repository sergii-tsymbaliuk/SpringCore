package spring.person.dao;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import spring.person.Person;

public interface PersonDao extends 
				CrudRepository<Person, Long>
{	
	Person findByLoginAndPassword(String login, String password);
}
