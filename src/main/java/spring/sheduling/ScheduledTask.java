package spring.sheduling;

import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Synchronize;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTask {

	Logger log = Logger.getLogger(getClass());
	
	String message = null;
	

	synchronized public String getMessage() {
		return message;
	}

	synchronized public void setMessage(String message) {
		this.message = message;
	}

//	@Scheduled(fixedRate = 1000) // Fixed rate
//	@Scheduled(fixedDelay = 1000) // Fixed delay between tasks
//	@Scheduled(fixedDelay = 5000, initialDelay= 7000) 	// Run on fixed delay after prog started
//	@Scheduled(cron="0/5 * * * * MON-FRI", zone="GMT+2") 	// cron-like config, zone for the timezone
	public void job() {
		log.info("Start Job");
		try{
			Thread.sleep(2000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		setMessage("Result ");
		log.info("End Job");		
	}
	
//	@Async
//	public void doAsyncTask(){
//		log.info("doAsyncTask");
//	}
	
	@Async
	public Future<String> getAsyncResult(){
		log.info("Into getAsyncResult");
		while(getMessage() == null) {
			log.info("getAsyncResult: Still no message recevied: " + getMessage());
			try {		
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		log.info("getAsyncResult: Message recevied: " + getMessage());		
		return new AsyncResult<>("Message: "+ getMessage());
	}
}
