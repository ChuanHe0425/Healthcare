package org.roncare.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.roncare.util.EncryptionUtil;

public class EncryptionUtilTest {

	@Test
	public void EncryptTest() {
		final String expected = "69d508b3aeb65c170e06810b1cb530aeb0f5381a12b775028bbb2d3d5bb32a2794be2e1dc3940cef1920c93f90ab33c7c280546169799ab36ce7017c9627118b";
					
		String result = EncryptionUtil.encryptSHA512("amazing");
		assertTrue(result.equals(expected));
	}

}