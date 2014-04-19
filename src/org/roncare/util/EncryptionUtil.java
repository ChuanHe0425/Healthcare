package org.roncare.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

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

	//Must be a multiple of 16 chars
	private static final String SECRET_CODE = 
		//"code__must__be__multiple__of__16";
		"123544342234321454343643ggfddfga";

	public static String encrypt(String value)
	{
		if (value == null || value.equals(""))
		{
			return null;
		}
		
		String encryptedValueResult = null;
		
		try
		{
			byte[] byteSecreteKey = Base64.decodeBase64(SECRET_CODE);
			SecretKeySpec secrteKeySpec = new SecretKeySpec(byteSecreteKey, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, secrteKeySpec);
			
			byte[] byteValue = value.getBytes();
			encryptedValueResult = Base64.encodeBase64String(cipher.doFinal(byteValue));
		}
		catch (Exception e)
		{
			System.out.println("{EncryptionUtil} - Error encountered during the encryption");
			e.printStackTrace();
		}

		return encryptedValueResult;
	}
	
	public static String decrypt(String value)
	{
		if (value == null || value.equals(""))
		{
			return null;
		}
		
		String dencryptedValueResult = null;
		
		try
		{
			byte[] byteSecreteKey = Base64.decodeBase64(SECRET_CODE);
			SecretKeySpec secrteKeySpec = new SecretKeySpec(byteSecreteKey, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secrteKeySpec);
			
			byte[] byteValue = Base64.decodeBase64(value);
			dencryptedValueResult = new String(cipher.doFinal(byteValue));
		}
		catch (Exception e)
		{
			System.out.println("{EncryptionUtil} - Error encountered during the decryption");
			e.printStackTrace();
		}

		return dencryptedValueResult;
	}
}
