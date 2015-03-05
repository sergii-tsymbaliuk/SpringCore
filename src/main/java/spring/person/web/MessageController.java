package spring.person.web;

import javax.annotation.Resource;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {
	//JMS
	@Resource
	JmsTemplate JmsTemplate;
	
	@RequestMapping("msg")
	public @ResponseBody String sendMessage(
			@RequestParam("text") String text
			){
		
		return "The messge \'"+text+"\' has been sent";
	}

}
