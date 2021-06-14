package com.realtimeodds.common.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LiveEventResponse {

protected List<LiveEvent> liveEvents = new ArrayList<>();

protected Group group ;
	
	public LiveEventResponse() {
		super();
	}

	public List<LiveEvent> getLiveEvents() {
		return liveEvents;
	}

	public void setLiveEvents(List<LiveEvent> liveEvents) {
		this.liveEvents = liveEvents;
	}

	public Group getGroup() {
		return group;
	}
	
}
