package spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@EnableAutoConfiguration
@ComponentScan("spring")
//To load config from xml file:
@ImportResource("classpath:securityContext.xml")
// The default /application.properties may be overriden:
//@PropertySource("classpath:app.prop")
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		
		//customize app properties
//		Map<String,Object> prop = new HashMap<String, Object>();
//		prop.put("server.port","8088");
//		prop.put("server.contextPath","/SpringBoot");		
//		prop.put("server.address","127.0.0.1");
//		app.setDefaultProperties(prop);
		
		app.run();

	}

}
