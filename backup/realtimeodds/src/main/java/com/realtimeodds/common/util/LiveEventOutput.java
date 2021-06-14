package com.realtimeodds.common.util;

public class LiveEventOutput {
	
	protected String name;
	protected String currentTime;
	protected String label;
	protected int odds;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getOdds() {
		return odds;
	}
	public void setOdds(int odds) {
		this.odds = odds;
	}
	@Override
	public String toString() {
		
		return " [currentTime +  label + odds ]";
		
				//		+ "]";
	//	return " [name=" + name + ", currentTime=" + currentTime + ", label=" + label + ", odds=" + odds
		//		+ "]";
	}
	
}
