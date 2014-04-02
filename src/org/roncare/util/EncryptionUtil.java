package org.roncare.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil
{
	public static String encryptSHA512(String input)
	{
		MessageDigest md;
		StringBuffer sb = new StringBuffer();
		String result = null;
		
		try 
		{
			md = MessageDigest.getInstance("SHA-512");
			md.update(input.getBytes("UTF-8"));
			
			byte[] bytes = md.digest();
			
			for (byte byt : bytes)
			{
				sb.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
		    }
			
			result = sb.toString();
		} 
		catch (NoSuchAlgorithmException e)
		{	
			e.printStackTrace();
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
        
		
		return result;
	}
}
