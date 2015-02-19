package spring.person.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.person.model.Person;
import spring.person.service.PersonService;


@Controller
@RequestMapping("ws/person")
public class PersonRestController {
	@Resource
	PersonService service;

	@RequestMapping(value = "{id}",  method = RequestMethod.GET)
	public String showViewForm(	
		@PathVariable("id") Long id, Model model){
		Person person = service.findOne(id);
		System.out.println("id = "+id+"\nPerson:\n"+ person);
		
		model.addAttribute("person", person);
		return "person/view";
		
	}
	
}
