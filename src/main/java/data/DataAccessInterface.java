package data;

import java.sql.SQLException;
import java.util.List;

import beans.Order;

public interface DataAccessInterface {

	public List<Order> findAll() throws SQLException;
	
	
	
}
