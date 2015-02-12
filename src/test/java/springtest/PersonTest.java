package springtest;

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
		System.out.println(personDao.getClass());
		System.out.println("=================================\nfindByName\n==============================");		
		System.out.println(personDao.findByName("John"));
		System.out.println("=================================\nfindOne\n==============================");		
		System.out.println(personDao.findOne(1L));	
		System.out.println("=================================\nfindByNameLength\n==============================");		
		System.out.println(personDao.findByNameLength(6));
		System.out.println("=================================\nfindByNameLengthSQL\n==============================");
		System.out.println(personDao.findByNameLengthSQL(4));		
		System.out.println("=================================\nfindByNameLengthSQL\n==============================");
		System.out.println(personDao.findByNameContainsAndNameLikeOrderByNameAsc("o", "%n%"));
		System.out.println("=================================\nUpdateQuery\n==============================");
		System.out.println(personDao.setNewName("Johnny", "Indy"));				
		
		System.out.println("=================================\n Using Sort\n==============================");
		System.out.println( personDao.findByNameLike("%ohn", new Sort(Direction.ASC, "age")) );				
		
		System.out.println("=================================\n Using Pageaing\n==============================");
		System.out.println( personDao.findByNameLike("%ohn", new PageRequest(1, 1)));	
		
		System.out.println("=================================\n Custom Interface \n==============================");
		personDao.doSomethingSpecific(personDao.findOne(1L));
	}

}
