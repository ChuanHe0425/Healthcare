package org.roncare.test;

import org.roncare.util.EncryptionUtil;


public class EncryptionUtilTest {

	public static void main(String[] args) {

		String testString = "Samir_Secret_Word_Test";
		
		System.out.println("Samir Original value: " + testString);
		
		String encrypt = EncryptionUtil.encrypt(testString);
		
		System.out.println("Encrypted word: " + encrypt);
		
		System.out.println("Decrypted word: " + EncryptionUtil.decrypt(encrypt));
    }
}
