package com.realtimeodds.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LiveEvent {
	
	protected Event event ;
	
	protected MainBetOffer mainBetOffer;
	
	protected LiveData liveData;
	
	public LiveEvent() {
		super();
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public MainBetOffer getMainBetOffer() {
		return mainBetOffer;
	}

	public void setMainBetOffer(MainBetOffer mainBetOffer) {
		this.mainBetOffer = mainBetOffer;
	}

	public LiveData getLiveData() {
		return liveData;
	}
	
	

}
