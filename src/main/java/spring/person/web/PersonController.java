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
		
//		@RequestMapping("person")
//		public String getPerson(HttpServletRequest request, Map<String,Object> model){
//			Long id = Long.valueOf(request.getParameter("id"));
//			System.out.println("id = "+id);
//			//Person p = new Person("Philipp");
//			//p.setAge(48);			
//			Person p = service.findOne(id);
//			System.out.println("person="+p);
//
//			model.put("person",p);
//			return "person/view";
//		}
//		
		@RequestMapping("view")
		public String getPerson(@RequestParam(value="id",required=false) Long id, 
					Map<String,Object> model){
			Person p = service.findOne(id);
			model.put("person",p);
			return "person/view";
		}
		
		@RequestMapping(value="add", method = RequestMethod.GET)
		public String showAddform(){
			return "person/add";
		}

		@RequestMapping(value="add", method = RequestMethod.POST)
		public String addPerson(@ModelAttribute("person") Person person){
			person.setCreateDate(new Date());
			service.save(person);
			return "redirect:view?id="+person.getId();
		}

		@RequestMapping(value="edit", method = RequestMethod.GET)
		public String showEditPersonForm(
				@RequestParam("id") Long id,
				Map<String,Object> model ){
			model.put("person",service.findOne(id));
			return "person/edit";
		}			
		
		@RequestMapping(value="edit", method = RequestMethod.POST)
		public String editPerson(
			@ModelAttribute("person") Person person){
			
			service.save(person);
			return "redirect:person?id="+person.getId();
		}				
				
		@ModelAttribute ("person")
		public Person getPerson(@RequestParam(value="id",required=false) Long id){
			return id == null ? new Person() : service.findOne(id);
			
		}
}
