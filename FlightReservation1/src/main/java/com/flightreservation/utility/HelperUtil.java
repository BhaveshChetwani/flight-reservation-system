package com.flightreservation.utility;

import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class HelperUtil {

	private static HelperUtil utilObj;
	
	private HelperUtil() {
		
	}
	
	public static HelperUtil getInstance() {
		if(!notNull(utilObj)) {
			utilObj = new HelperUtil();
		}
		
		return utilObj;
	}
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
		return true;
		}
		return false;
	}
	
	private static final String key = "encaptureyouthEK";
	private static final String initVector = "encryptionIntVec";
	 
	public String encrypt(String value) {
	    try {
	        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
	        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
	 
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
	 
	        byte[] encrypted = cipher.doFinal(value.getBytes());
	        return Base64.getEncoder().encodeToString(encrypted);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
	
	public String decrypt(String encrypted) {
	    try {
	        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
	        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
	 
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
	        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
	 
	        return new String(original);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	 
	    return null;
	}
}
