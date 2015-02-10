package spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.person.model.Person;
import spring.person.service.PersonService;
import spring.person.service.PersonServiceImpl;

public class Application {
	public final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("jpa");
	public final static EntityManager EM = EMF.createEntityManager();
	public final static ApplicationContext AC = new ClassPathXmlApplicationContext("appContext.xml");

	public static void main(String[] args) {

		//PersonService personService = new PersonServiceImpl();
		PersonService personService = AC.getBean(PersonService.class);
		//PersonService personService2 = AC.getBean(PersonService.class);
		Person p = new Person("John");
		personService.save(p);
		
		
		EM.close();
		EMF.close();
		System.out.println("DONE!");

	}
}
