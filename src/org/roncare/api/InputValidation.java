package org.roncare.api;

import java.util.regex.Pattern;

public class InputValidation {

	private static final Pattern EMAIL_PATTERN = 
			Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
								+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	private static final int MIN_PASSWORD_LENGTH = 1;
	private static final int MIN_FIRSTNAME_LENGTH = 1;
	private static final int MIN_LASTNAME_LENGTH = 1;
	
	public static boolean validateEmail(String email)	{
		return EMAIL_PATTERN.matcher(email).matches();
	}
	
	public static boolean validateFirstName(String firstName)	{
		return firstName.length() >= MIN_FIRSTNAME_LENGTH;
	}
	
	public static boolean validateLastName(String lastName)	{
		return lastName.length() >= MIN_LASTNAME_LENGTH;
	}
	
	public static boolean validatePassword(String password, String confirmPassword)	{
		return password.length() >= MIN_PASSWORD_LENGTH ? password.equals(confirmPassword) : false;
	}
	
	public static boolean validateRegister(String email, String firstName, String lastName, String password, String confirmPassword)	{
		return validateEmail(email) 
				&& validateFirstName(firstName)
				&& validateLastName(lastName)
				&& validatePassword(password, confirmPassword);
	}
}
