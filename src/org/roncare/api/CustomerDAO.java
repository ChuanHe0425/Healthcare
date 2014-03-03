package org.roncare.api;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
	public List<Customer> getAllCustomers();
	public Customer getCustomer(int id);
	public void addCustomer(Customer c) throws SQLException;
	public void deleteCustomer(int id);
	public void updateCustomer(Customer c);
}
