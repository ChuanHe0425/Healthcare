package org.roncare.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Pattern;

import org.roncare.dao.impl.CustomerDAO;

public class InputValidation {

	private static final Pattern EMAIL_PATTERN = 
			Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
								+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	private static final int MIN_PASSWORD_LENGTH = 1;
	private static final int MIN_FIRSTNAME_LENGTH = 1;
	private static final int MIN_LASTNAME_LENGTH = 1;
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
		return firstName.length() >= MIN_FIRSTNAME_LENGTH;
	}
	
	public static boolean validateLastName(String lastName)	{
		return lastName.length() >= MIN_LASTNAME_LENGTH;
	}
	
	public static boolean validatePassword(String password, String confirmPassword)	{
		return password.length() >= MIN_PASSWORD_LENGTH ? password.equals(confirmPassword) : false;
	}
	
	public boolean validateRegister(String email, String firstName, String lastName, String password, String confirmPassword)	{
		return validateEmail(email) 
				&& validateFirstName(firstName)
				&& validateLastName(lastName)
				&& validatePassword(password, confirmPassword);
	}
}
