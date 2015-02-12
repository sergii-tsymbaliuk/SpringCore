package springtest;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import spring.person.dao.PersonDao;

//1. Configure test context 
@RunWith(SpringJUnit4ClassRunner.class)
//2. Configure context
@ContextConfiguration("classpath:/appContext.xml")
//3. To block transaction roll-back
@TransactionConfiguration(transactionManager= "transactionManager",defaultRollback=false)
//4. NiceTo Have
@FixMethodOrder(MethodSorters.JVM)
public class PersonTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	PersonDao personDao;
	
	@Test
	public void read(){
		System.out.println(personDao.findByName("John"));
	}

}
