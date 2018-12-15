package com.flightreservation.utility;

import java.util.List;

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
			}else if(obj instanceof List) {
				List temp = (List) obj;
				if(temp!=null && temp.size()>0) {
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
