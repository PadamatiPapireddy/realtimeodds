package com.realtimeodds.realtimeodds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.realtimeodds.common.model.LiveEvent;
import com.realtimeodds.common.model.LiveEventResponse;
import com.realtimeodds.common.util.Constants;
import com.realtimeodds.common.util.FormatDateUtil;
import com.realtimeodds.common.util.LiveEventOutput;
import com.realtimeodds.common.util.RealtimeOddsInfoRestServiceUtil;

@SpringBootApplication
@EnableScheduling
public class RealtimeoddsApplication implements CommandLineRunner{
	
	
	private static final Logger log =
			LoggerFactory.getLogger(RealtimeoddsApplication.class);
	
	LiveEventResponse liveEventResponse = new LiveEventResponse();
	LiveEventOutput liveEventOutput = new LiveEventOutput();
	
	long id =0;
	
	

	public static void main(String[] args) {
		SpringApplication.run(RealtimeoddsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			id=Long.valueOf(args[0]);
		//	id=1007707897;
			
			}catch(Exception e){
				log.error("Exception:", e);
			}

	}
		
	
	@Scheduled(cron = "*/10 * * * * *")
	private void oddsInfoApiCall() throws Exception {
			
			LiveEvent liveEvent= new LiveEvent();
		
			String currentTime = FormatDateUtil.localTime();
			try {
				liveEventResponse = RealtimeOddsInfoRestServiceUtil.oddsInfoAPICaller(id);
			
				if(liveEventResponse.getLiveEvents()!=null) {
					liveEvent=	liveEventResponse.getLiveEvents().stream()
							.filter(event->event.getEvent()!=null 
								&& event.getEvent().getId()==id).findAny().orElse(null);
					if(liveEvent.getEvent().getTags() !=null 
							&&liveEvent.getEvent().getTags().contains(Constants.TAGS)
							) {
							System.out.println("Event: " + liveEvent.getEvent().getName());
							System.out.print(  "[" + currentTime + "]");
						
					//	liveEventOutput.setName(liveEvent.getEvent().getName());
					//	liveEventOutput.setCurrentTime(currentTime);
					if(liveEvent.getMainBetOffer() !=null 
							&& liveEvent.getMainBetOffer().getOutcomes()!=null) {
						liveEvent.getMainBetOffer().getOutcomes().stream()
						.forEach(outcome->{
								
						//	liveEventOutput.setLabel(outcome.getLabel());
						//	liveEventOutput.setOdds(outcome.getOdds()/1000);
							
							System.out.print( " | " + outcome.getLabel() +":     " + Double.valueOf(outcome.getOdds()/1000) +" | " );
						});
					}
					}
				}
			}catch(Exception e){
			log.error("Exception:", e);
		}
		
	}
}

