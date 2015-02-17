package spring.person.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {

		@RequestMapping("hello")
		public String sayHello(){
			return "hello";
		}
}
