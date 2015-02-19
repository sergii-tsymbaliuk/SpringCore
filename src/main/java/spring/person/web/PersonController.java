package spring.person.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.person.model.Person;

@Controller
@RequestMapping("person")
public class PersonController extends PersonAbstractController {

		@RequestMapping("view")
		public String showViewForm(){
			return "person/view";
		}
		
		@RequestMapping("")
		public String showPersonList(Model model){
			model.addAttribute("personList", service.findAll());
			return "person/list";
		}
		
		@RequestMapping(value="add", method = RequestMethod.GET)
		public String showAddform(){
			return "person/add";
		}
		
		@RequestMapping(value="edit", method = RequestMethod.GET)
		public String showEditPersonForm(){
			return "person/edit";
		}					

		@RequestMapping(value={"add","person/edit"}, method = RequestMethod.POST)
		public String savePerson(
			@ModelAttribute("person") Person person){
			service.save(person);
			return "redirect:person/view?id="+person.getId();
		}
	
		@RequestMapping(value="delete", method = RequestMethod.POST)
		public String deletePerson( @RequestParam("id") Person person){ //thanks to data binder !
			service.delete(person);
			return "";
		}
		
		@ModelAttribute ("person")
		public Person getPerson(@RequestParam(value="id",required=false) Person person){
			return person == null ? new Person() : person;
			
		}
}
