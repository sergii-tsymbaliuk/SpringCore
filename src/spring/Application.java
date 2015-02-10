package spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.person.model.Person;
import spring.person.service.PersonService;
import spring.person.service.PersonServiceImpl;

public class Application {
	public final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("jpa");
	public final static EntityManager EM = EMF.createEntityManager();
	//With XML
	public final static ApplicationContext AC = new ClassPathXmlApplicationContext("appContext.xml");
	// With Java annotation (see the AppContext.java class)
	//public final static ApplicationContext AC = new AnnotationConfigApplicationContext(AppContext.class);
	public static void main(String[] args) {

		//PersonService personService = new PersonServiceImpl();
		//PersonService personService = AC.getBean(PersonService.class);
		//PersonService personService2 = AC.getBean(PersonService.class);
		//for java PersonService personService = AC.getBean("javaPersonService",PersonService.class);
		PersonService personService = AC.getBean("personServiceImpl",PersonService.class);
//		Person p = new Person("John");
//		personService.save(p);
		//test map mapping from CommonContext.xml
		//((PersonServiceImpl)personService).printMap();
		
		EM.close();
		EMF.close();
		System.out.println("DONE!");

	}
}
