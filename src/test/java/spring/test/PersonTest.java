package spring.test;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;



import org.springframework.test.context.web.WebAppConfiguration;

import spring.person.dao.PersonDao;
import  spring.person.service.PersonService;

//1. Configure test context 
@RunWith(SpringJUnit4ClassRunner.class)
//2. Configure context
@ContextConfiguration("classpath:/appContext.xml")
//3. To block transaction roll-back
@TransactionConfiguration(transactionManager= "transactionManager",defaultRollback=false)
//4. NiceTo Have
@FixMethodOrder(MethodSorters.JVM)
//@WebAppConfiguration
public class PersonTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	PersonDao personDao;

	@Autowired
	PersonService service;
	
	@Test
	public void read ()  throws Exception{
		//System.out.println(personDao.getClass());

		//System.out.println("=================================\nfindOne -1L\n==============================");		
		//System.out.println(service.findOne(-1L));
		System.out.println("=================================\nfindOne 1L\n==============================");
		System.out.println(service.findOne(1L));			
	}

}
