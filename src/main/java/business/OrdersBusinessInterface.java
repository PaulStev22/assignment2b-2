package business;


import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import beans.Order;
import beans.Orders;

@Local
public interface OrdersBusinessInterface {

	public static void test() {
		
	}
	
	public List<Order> getOrders() throws SQLException;

	void setOrders(List<Order> orders);

	void sendOrder(Order order);

	
	
}


