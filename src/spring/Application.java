package spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.person.model.Person;
import spring.person.service.PersonService;

public class Application {
	public final static AbstractApplicationContext AC = new ClassPathXmlApplicationContext("appContext.xml");
	public static void main(String[] args) {

		PersonService personService = AC.getBean(PersonService.class);
		Person p = new Person("Ivan");
		try {
			personService.save(p);
		} 
		finally{
			AC.close();
		}
		System.out.println(personService.getClass());
		
		System.out.println("DONE!");

	}
}
