package org.roncare.api;

import java.util.regex.Pattern;

import org.roncare.dao.impl.CustomerDAO;

public class InputValidation {

	private static final Pattern EMAIL_PATTERN = 
			Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
								+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
	private static final Pattern DOB_PATTERN = 	Pattern.compile("^\\d{4}[.\\/-]\\d{2}[.\\/-]\\d{2}$");
	private static final Pattern ZIPCODE_PATTERN = Pattern.compile("^\\d{5}$");
	private static final Pattern SSN_PATTERN = Pattern.compile("^\\d{9}$");
	private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10,11}$");
	
	private static final int MIN_PASSWORD_LENGTH = 6;

	private CustomerDAO customerDAO;
	
	private InputValidation()	{
		customerDAO = new CustomerDAO();
	}
	
	public static InputValidation createInputValidation()	{
		return new InputValidation();
	}
	
	public boolean validateEmail(String email)	{
		if (!EMAIL_PATTERN.matcher(email).matches())	{
			return false;
		}
		return customerDAO.getCustomer(email) == null;
	}
	
	public static boolean validateFirstName(String firstName)	{
		return NAME_PATTERN.matcher(firstName).matches();
	}
	
	public static boolean validateLastName(String lastName)	{
		return NAME_PATTERN.matcher(lastName).matches();
	}
	
	public static boolean validatePassword(String password, String confirmPassword)	{
		return password.length() >= MIN_PASSWORD_LENGTH ? password.equals(confirmPassword) : false;
	}
	
	public boolean validateRegister(String email, String firstName, String lastName, String password, String confirmPassword, String dob)	{
		return validateEmail(email) 
				&& validateFirstName(firstName)
				&& validateLastName(lastName)
				&& validatePassword(password, confirmPassword)
				&& validateDOB(dob);
	}
	
	public static boolean validateDOB(String dob)	{
		return DOB_PATTERN.matcher(dob).matches();
	}
	
	public static boolean validateZipCode(String zipCode)	{
		return ZIPCODE_PATTERN.matcher(zipCode).matches();
	}
	
	public static boolean validateSSN(String ssn)	{
		return SSN_PATTERN.matcher(ssn).matches();
	}
	
	public static boolean validatePhone(String phone)	{
		return PHONE_PATTERN.matcher(phone).matches();
	}
	
	public static boolean validateAge(int age){
		return age > 0 && age < 120;
	}
}
