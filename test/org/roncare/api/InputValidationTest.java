package org.roncare.api;

import static org.junit.Assert.*;

//import java.util.Arrays;
//import java.util.Collection;
//
import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;

//@RunWith(Parameterized.class)
public class InputValidationTest {
/*
 *Wanted to use Parameterized Testing, but that runs every test X times, where X is number of Parameters in @Parameters.
 *Decided to write individual tests for email. Other option was to have a dedication class to test email
 *
	private boolean expected;	//used for parameterized email test
	private String email;		//used for parameterized email test
	
	@Parameters
	public static Collection<Object[]> emailList()	{
		return Arrays.asList(new Object[][]	{
				{true, "test@test.com"},
				{true, "test@sub.domain.com"},
				{false, "@test.com"},
				{false, "test"},
				{false, "test@test"},
				{false, ""}
		});
	}
	
	public InputValidationTest(boolean expected, String email)	{
		this.expected = expected;
		this.email = email;
	}
	
	@Test
	public void validateEmail_Test()	{
		assertEquals(expected, InputValidation.validateEmail(email));
	}
*/
	@Test
	public void validateEmail_localAndDomain_valid()	{
		assertTrue(InputValidation.validateEmail("test@test.com"));
	}
	
	@Test
	public void validateEmail_localAndSubDomain_valid()	{
		assertTrue(InputValidation.validateEmail("test@sub.domain.com"));
	}
	
	@Test
	public void validateEmail_localOnly_invalid()	{
		assertFalse(InputValidation.validateEmail("test"));
	}
	
	@Test
	public void validateEmail_domainOnly_invalid()	{
		assertFalse(InputValidation.validateEmail("@test.com"));
	}
	
	@Test
	public void validateEmail_empty_invalid()	{
		assertFalse(InputValidation.validateEmail(""));
	}
	
	@Test
	public void validateFirstName_emptyString_invalid()	{
		assertFalse(InputValidation.validateFirstName(""));
	}
	
	@Test
	public void validateFirstName_3charString_valid()	{
		assertTrue(InputValidation.validateFirstName("bob"));
	}
	
	@Test
	public void validateLastName_emptyString_invalid()	{
		assertFalse(InputValidation.validateLastName(""));
	}
	
	@Test
	public void validateLastName_3charString_valid()	{
		assertTrue(InputValidation.validateLastName("kim"));
	}
	
	@Test
	public void validatePassword_equalAndLongEnough_valid()	{
		assertTrue(InputValidation.validatePassword("hunter2", "hunter2"));
	}
	
	@Test
	public void validatePassword_notEqualAndLongEnough_invalid()	{
		assertFalse(InputValidation.validatePassword("hunter2", "hunter4"));
	}
	
	@Test
	public void validatePassword_EqualAndNotLongEnough_invalid()	{
		assertFalse(InputValidation.validatePassword("", ""));
	}
	
	@Test
	public void validateRegistration_valid()	{
		assertTrue(InputValidation.validateRegister("email@email.com", "first", "last", "password", "password"));
	}
	
	@Test 
	public void validateRegistration_passwordInvalid_invalid()	{
		assertFalse(InputValidation.validateRegister("email@email.com", "first", "last", "password", "passwordNoMatch"));
	}
	
	@Test 
	public void validateRegistration_firstNameInvalid_invalid()	{
		assertFalse(InputValidation.validateRegister("email@email.com", "", "last", "password", "password"));
	}
	
	@Test 
	public void validateRegistration_lastNameInvalid_invalid()	{
		assertFalse(InputValidation.validateRegister("email@email.com", "first", "", "password", "password"));
	}
	
	@Test 
	public void validateRegistration_allInvalid_invalid()	{
		assertFalse(InputValidation.validateRegister("@test", "", "", "password", "noMatch"));
	}
}
