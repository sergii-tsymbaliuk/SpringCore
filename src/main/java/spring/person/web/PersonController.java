package spring.person.web;


import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import spring.person.Person;
import spring.sheduling.ScheduledTask;

@Scope() //("session") //Singleton for session/request/server
@Controller
@RequestMapping({"","/person"})
//@SessionAttributes("test")
public class PersonController extends PersonAbstractController {
		
		@Autowired
		ScheduledTask scheduledTask;  
	
//		@Secured("ROLE_USER")
		@RequestMapping({"","list"})
		public String showPersonList(Model model){
			model.addAttribute("personList", service.findAll());
			return "person/list";
		}

//		@Secured("ROLE_USER")
		@RequestMapping("view")
		public String showViewForm(Model model){
			model.addAttribute("test", new Date());
			return "person/view";
		}		
		
		@Secured("ROLE_ADMIN")
		@RequestMapping(value="add", method = RequestMethod.GET)
		public String showAddform(){
			return "person/add";
		}

		@Secured("ROLE_ADMIN")		
		@RequestMapping(value="edit", method = RequestMethod.GET)
		public String showEditPersonForm(){
			return "person/edit";
		}					

		@Secured("ROLE_ADMIN")		
		@RequestMapping(value={"add","edit"}, method = RequestMethod.POST)
		public String savePerson(
			@ModelAttribute("person") Person person){
			service.save(person);
			return "redirect:view?id="+person.getId();
		}
	
		@Secured("ROLE_ADMIN")		
		@RequestMapping(value="delete", method = RequestMethod.POST)
		public String deletePerson( @RequestParam("id") Person person){ //thanks to data binder !
			service.delete(person);
			return "";
		}
		
//		@Secured("ROLE_USER")		
		@ModelAttribute ("person")
		public Person getPerson(@RequestParam(value="id",required=false) Person person){
			return person == null ? new Person() : person;
			
		}

		public PersonController() {
			super();
			System.out.println("new PersonController()");
		}
		
		
}
