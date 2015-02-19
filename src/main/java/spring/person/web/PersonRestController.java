package spring.person.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.person.model.Person;


@Controller
@RequestMapping("ws/person")
public class PersonRestController extends PersonAbstractController{

	@RequestMapping(value = "{id}",  method = RequestMethod.GET)
	public String showViewForm(	
		@PathVariable("id") Person person, Model model){

		System.out.println("id = "+person.getId()+"\nPerson:\n"+ person);
		
		model.addAttribute("person", person);
		return "person/view";
	}
}
