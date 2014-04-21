package org.roncare.api;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
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
	private static InputValidation inputValidation;
	
	@BeforeClass
	public static void createInputValidation()	{
		inputValidation = InputValidation.createInputValidation();
	}
	
	@Test
	public void validateEmail_localAndDomain_valid()	{
		assertTrue(inputValidation.validateEmail("unregisteredEmail@test.com"));
	}
	
	@Test
	public void validateEmail_localAndSubDomain_valid()	{
		assertTrue(inputValidation.validateEmail("unregistered@test.subdomain.com"));
	}
	
	@Test
	public void validateEmail_localOnly_invalid()	{
		assertFalse(inputValidation.validateEmail("test"));
	}
	
	@Test
	public void validateEmail_domainOnly_invalid()	{
		assertFalse(inputValidation.validateEmail("@test.com"));
	}
	
	@Test
	public void validateEmail_empty_invalid()	{
		assertFalse(inputValidation.validateEmail(""));
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
		assertTrue(inputValidation.validateRegister("email@email.com", "first", "last", "password", "password"));
	}
	
	@Test 
	public void validateRegistration_passwordInvalid_invalid()	{
		assertFalse(inputValidation.validateRegister("email@email.com", "first", "last", "password", "passwordNoMatch"));
	}
	
	@Test 
	public void validateRegistration_firstNameInvalid_invalid()	{
		assertFalse(inputValidation.validateRegister("email@email.com", "", "last", "password", "password"));
	}
	
	@Test 
	public void validateRegistration_lastNameInvalid_invalid()	{
		assertFalse(inputValidation.validateRegister("email@email.com", "first", "", "password", "password"));
	}
	
	@Test 
	public void validateRegistration_allInvalid_invalid()	{
		assertFalse(inputValidation.validateRegister("@test", "", "", "password", "noMatch"));
	}
	
	@Test
	public void validateDOB_valid()	{
		assertTrue(InputValidation.validateDOB("01.01.2010"));
		assertTrue(InputValidation.validateDOB("01-01-2010"));
		assertTrue(InputValidation.validateDOB("01/01/2010"));
	}
	
	@Test
	public void validateDOB_formatInvalid_invalid()	{
		assertFalse(InputValidation.validateDOB("01012010"));
	}
	
	@Test
	public void validateZipCode_value()	{
		assertTrue(InputValidation.validateZipCode("90210"));
	}
	
	@Test
	public void validateZipCode_invalidFormat_invalid()	{
		assertFalse(InputValidation.validateZipCode("a9021"));
	}
	
	@Test
	public void validateSSN_valid()	{
		assertTrue(InputValidation.validateSSN("123121234"));
	}
	
	@Test
	public void validateSSN_invalidFormat_invalid()	{
		assertFalse(InputValidation.validateSSN("123"));
	}
	
	@Test	
	public void validatePhone()	{
		assertTrue(InputValidation.validatePhone("15553334444"));
		assertTrue(InputValidation.validatePhone("5553334444"));
	}
	
	@Test
	public void validatePhone_invaidFormat_invalid()	{
		assertFalse(InputValidation.validatePhone("123213"));
	}
	
	@Test
	public void validateAge_valid()	{
		assertTrue(InputValidation.validateAge(50));
	}
	
	@Test
	public void validateAge_tooOld_invalid()	{
		assertFalse(InputValidation.validateAge(120));
	}
	
	@Test
	public void validateAge_tooYoung_invaid()	{
		assertFalse(InputValidation.validateAge(0));
	}
}
