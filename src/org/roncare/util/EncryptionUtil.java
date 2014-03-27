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
	
	static String expected = "69d508b3aeb65c170e06810b1cb530aeb0f5381a12b775028bbb2d3d5bb32a2794be2e1dc3940cef1920c93f90ab33c7c280546169799ab36ce7017c9627118b";
	
	public static void main(String [] args)
	{
		
		
		encryptSHA512("amazing");
		
		//System.out.print();
	}
}
