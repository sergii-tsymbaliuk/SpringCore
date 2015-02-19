package spring.person.web;

import java.beans.PropertyEditorSupport;

import javax.annotation.Resource;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import spring.person.model.Person;
import spring.person.service.PersonService;


abstract public class PersonAbstractController {

	@Resource
	protected PersonService service;

	public PersonAbstractController() {
		super();
	}

	@InitBinder
	public void registerBinders(WebDataBinder binder) {
		binder.registerCustomEditor(
				Person.class, 
				new PropertyEditorSupport(){
	
					@Override
					public void setAsText(String personId)
							throws IllegalArgumentException {
						Person person = null;
						if ( !(personId == null || personId.trim().isEmpty()) ) {
							Long id = Long.valueOf(personId);
							person = service.findOne(id);
						}
						setValue(person);
					}
					
				});
		
	}

}