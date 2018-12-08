package com.flightreservation.utility;

public class HelperUtil {

	public static boolean notNull(Object obj) {
		if(obj!= null) {
			if(obj instanceof String) {
				String temp = (String) obj;
				if(temp!=null && temp.length()>0) {
					return true;
				}else {
					return false;
				}
			}
		System.gc();
		}
		return false;
	}
}
