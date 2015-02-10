package spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import spring.person.model.Person;
import spring.person.service.PersonService;
import spring.person.service.PersonServiceImpl;

public class Application {
	public final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("jpa");
	public final static EntityManager EM = EMF.createEntityManager();

	public static void main(String[] args) {

		PersonService personService = new PersonServiceImpl();
		Person p = new Person("Tom");
		personService.save(p);
		
		
		EM.close();
		EMF.close();
		System.out.println("DONE!");

	}
}
