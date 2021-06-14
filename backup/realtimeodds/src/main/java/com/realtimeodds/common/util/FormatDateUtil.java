package com.realtimeodds.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDateUtil {
	
	public static String localTime() {  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Date date = new Date();  
	    System.out.println(formatter.format(date));  
	    return formatter.format(date);
	}  

}
