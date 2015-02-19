package spring.person.web;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.person.model.Person;
import spring.person.service.PersonService;

@Controller
public class PersonController {

		@Resource
		PersonService service;
		
	
		@RequestMapping("person/view")
		public String showViewForm(){
			return "person/view";
		}
		
		@RequestMapping(value="person/add", method = RequestMethod.GET)
		public String showAddform(){
			return "person/add";
		}
		
		@RequestMapping(value="person/edit", method = RequestMethod.GET)
		public String showEditPersonForm(){
			return "person/edit";
		}					

		@RequestMapping(value={"person/add","person/edit"}, method = RequestMethod.POST)
		public String savePerson(
			@ModelAttribute("person") Person person){
			service.save(person);
			return "redirect:person/view?id="+person.getId();
		}
	
		@RequestMapping(value="person/delete", method = RequestMethod.POST)
		public String deletePerson( @RequestParam("id") Long id){
			service.delete(id);
			return "";
		}
		
		@ModelAttribute ("person")
		public Person getPerson(@RequestParam(value="id",required=false) Long id){
			return id == null ? new Person() : service.findOne(id);
			
		}
}
