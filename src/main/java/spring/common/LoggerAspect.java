package spring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LoggerAspect {

//	@Before("execution(* spring..*.sav*(..))")
//	public void before(){
//		System.out.println("Before");
//	}
	
//	@Before("execution(* spring..*.*(..)) && args(id)") // with args
//	public void begfore(JoinPoint jp){
	
	@Before("execution(* spring..*.*(..))") // with args	
	public void before(JoinPoint jp, Long id){	
		System.out.println("======================= Before =======================");
		System.out.println("== getKind =======================");		
		System.out.println(jp.getKind());
		System.out.println("== getTarget =======================");		
		System.out.println(jp.getTarget());		
		System.out.println("== getThis =======================");		
		System.out.println(jp.getThis());
		System.out.println("== getSignature =======================");		
		System.out.println(jp.getSignature());
		System.out.println("== getArgs =======================");		
		System.out.println(jp.getArgs());
		System.out.println("== toLongString =======================");		
		System.out.println(jp.toLongString());
		System.out.println("== toShortString =======================");		
		System.out.println(jp.toShortString());
		System.out.println("== toString =======================");		
		System.out.println(jp.toString());		
		System.out.println("== arg");		
		System.out.println("arg : " +id);		
	}
	
	@AfterReturning(value="execution(* spring..*.*(..))",returning = "ret")
	public void after(JoinPoint jp, Object ret){	
		System.out.println("======================= After Returning =======================");
		System.out.println("== getKind ");		
		System.out.println(jp.getKind());
		System.out.println("== getTarget");		
		System.out.println(jp.getTarget());		
		System.out.println("== getThis ");		
		System.out.println(jp.getThis());
		System.out.println("== getSignature ");		
		System.out.println(jp.getSignature());
		System.out.println("== getArgs ");		
		System.out.println(jp.getArgs());
		System.out.println("== toLongString");		
		System.out.println(jp.toLongString());
		System.out.println("== toShortString ");		
		System.out.println(jp.toShortString());
		System.out.println("== toString ==");		
		System.out.println(jp.toString());		
		System.out.println("== ret");		
		System.out.println("ret : " +ret);
		System.out.println("======================= End After Returning =======================");
	}
	
	
	@AfterThrowing(value="execution(* spring..*.*(..))", throwing="ex")
	public void afterThrowning(JoinPoint jp, Throwable ex ){
		System.out.println("======================= AfterThrowing =======================");		
		System.out.println("JP:" + jp.toString());
		System.out.println("JP:" + ex);		
	}
	
	@After(value="execution(* spring..*.*(..))")
	public void after(JoinPoint jp){
		System.out.println("======================= After =======================");		
		System.out.println("JP:" + jp.toString());
		//System.out.println("JP:" + ex);
	}
	
	@Around(value="execution(* spring..*.*(..))")
	public void around(JoinPoint jp){
		System.out.println("======================= Around =======================");		
		System.out.println("JP:" + jp.toString());		
	}
}
