package spring.person.dao;

import java.util.List;






import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import spring.person.model.Person;

public interface PersonDao extends 
				CrudRepository<Person, Long>
				//JpaRepository<Person, Long> // Extends CrudRepository providing sorting and pagination
				,PersonCustomDao //To avoid erorrs while Dao implements methods by name from the custom interface
								 //Class with the same name +Impl should be implemented. See PersonCustomDaoImpl
{	
	//Removed implementation, was replaced by JpaRepository default implementations
	public List<Person> findByName(String name);
	public List<Person> getByName(String name);	
	
	//public List<Person> findByName(String name);
	
	
	// Custom find method using JPQL
	@Query("from Person p where length(p.name)=?1")
	public List<Person> findByNameLength(int length);
	
	// Custom find method using native SQ:
	@Query(value="select * from person p where length(p.name)=?1",nativeQuery = true )
	public List<Person> findByNameLengthSQL(int length);
	
	//Custom find methods using method name expressions
	public List<Person> findByNameLike(String name);
	public List<Person> findByNameContainsAndNameLikeOrderByNameAsc(String contains,String like);
	
	//Using @Modifiyng to update records
	@Query("update Person p set p.name=?2 where p.name=?1")
	@Modifying
	// For named parameters
	public int setNewName(String name,String newName);
	
	// Using sorting
	public List<Person> findByNameLike(String pattern, Sort sort);	
	
	// Using paging
	public List<Person> findByNameLike(String pattern, Pageable pageable);	

}
