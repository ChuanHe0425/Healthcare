package org.roncare.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncryptionUtil
{
	//Must be a multiple of 16 chars
	private static final String SECRET_CODE = "1235443422343214";
	private static final String algorithm = "AES";
		
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
	
	/*
	 * Encrypts using AES and with key hard-coded into this class: "SECRET_CODE"
	 * Encrypted result is base64 encoded for easy DB storage
	 */
	public static String encrypt(String value)
	{
		if (value == null || value.equals(""))
		{
			return null;
		}
	
		String encryptedString = null;
		
		try
		{
			SecretKeySpec symKey = new SecretKeySpec(SECRET_CODE.getBytes(), algorithm);
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, symKey);
			
			byte[] encryptedValue = cipher.doFinal(value.getBytes());
			encryptedString = Base64.encodeBase64String(encryptedValue);
		}
		catch (Exception e)
		{
			System.out.println("{EncryptionUtil} - Error encountered during the encryption");
			e.printStackTrace();
		}

		return encryptedString;
	}
	
	/*
	 * Assumes Encrypted Value was base64 encoded
	 * Decodes String, then decrypts with AES using the key harded-coded into this class: "SECRET_CODE"
	 */
	public static String decrypt(String value)
	{
		if (value == null || value.equals(""))
		{
			return null;
		}
		
		String decryptedString = null;
		
		try
		{
			SecretKeySpec symKey = new SecretKeySpec(SECRET_CODE.getBytes(), algorithm);
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.DECRYPT_MODE, symKey);
			
			byte[] decryptedValue = cipher.doFinal(Base64.decodeBase64(value));
			decryptedString = new String(decryptedValue);
		}
		catch (Exception e)
		{
			System.out.println("{EncryptionUtil} - Error encountered during the decryption");
			e.printStackTrace();
		}

		return decryptedString;
	}
}
