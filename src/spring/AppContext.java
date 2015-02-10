package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import spring.person.service.PersonService;
import spring.person.service.PersonServiceImpl;


@Configuration
@ComponentScan(
		basePackages= {"spring"},
		excludeFilters = @Filter(
					type = FilterType.REGEX, pattern = "spring.*Test*.*"
				)
		)

public class AppContext {
	@Bean
	public PersonService javaPersonService(){
		PersonService ps = new PersonServiceImpl();
		System.out.println("javaPersonService : "+ps);
		return ps ;
	}
}
