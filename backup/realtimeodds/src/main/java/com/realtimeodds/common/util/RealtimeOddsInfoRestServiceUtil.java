package com.realtimeodds.common.util;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realtimeodds.common.model.LiveEventResponse;

public class RealtimeOddsInfoRestServiceUtil {
	
	private static final Logger log =
			LoggerFactory.getLogger(RealtimeOddsInfoRestServiceUtil.class);
	
	
	public static LiveEventResponse oddsInfoAPICaller(long id) throws Exception {
		//System.out.println("event uid :"+id);
		
		//log.info("OddsInfoRestServiceUtil.oddsInfoAPICaller started calling Kambi Rest ApI " );
		
		ObjectMapper mapper = new ObjectMapper();
		
		URL url = new URL("file:C:/Users/PAPIREDDY.PADAMATI/Training/odds.json");
		try {
			//Map usrPcost = mapper.readValue(new URL(Constants.url), Map.class);
			//LiveEventResponse liveEventResponse = mapper.readValue(new URL(Constants.url), LiveEventResponse.class);
			//LiveEventResponse liveEventResponse = mapper.readValue(new URL(Constants.url), LiveEventResponse.class);
			LiveEventResponse liveEventResponse = mapper.readValue(url, LiveEventResponse.class);
		//	System.out.println(liveEventResponse.getLiveEvents().get(0).getEvent().getName());
			return liveEventResponse;
		} catch (IOException e) {
			log.error("Failed with following exception:" + e.getMessage());
			return null;
		
		}
		//step1: give local path
		//step2: 
		
		/*
		RestTemplate restTemplate = new RestTemplate();
		RequestEntity<Void> requestEntity;
		ResponseEntity<LiveEventResponse> response = null;
		try{
			requestEntity = RequestEntity.get(Constants.url).build();
			response = restTemplate.exchange(requestEntity, LiveEventResponse.class);
			if (response.getStatusCodeValue() !=200){
				log.error("Runtime Exception: Failed with HTTP error code" +
						response.getStatusCodeValue()+ "" + response.getHeaders());
				return null;
			}
			return response.getBody();
		
		}catch (HttpClientErrorException.NotFound ex) {
			log.error("Failed with following exception:" + ex.getMessage());
		}
		return response.getBody();
	}*/
	}
}
