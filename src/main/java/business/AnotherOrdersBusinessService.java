package business;


import java.util.Arrays;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Order;
import beans.Orders;

/**
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@LocalBean
public class AnotherOrdersBusinessService implements OrdersBusinessInterface{

	
	
	List<Order> orders;
	

	
    /**
     * Default constructor. 
     * @param orders 
     */
    public AnotherOrdersBusinessService() {
    	orders = Arrays.asList(new Order("#1", "Math Book", 1, 100, "100"), new Order("#2","English Book", 1, 100, "200"),new Order("#3", "Easy Book", 1, 100, "100"), new Order("#4","New Book", 1, 150, "200"),new Order("#5", "Old Book", 1, 100, "100"), new Order("#6","Okay Book", 1, 200, "200"),new Order("#7", "Wicked Book", 1, 300, "100"), new Order("#8","Table Book", 1, 150, "20"),new Order("#9", "Dangerous Book", 1, 100, "90"), new Order("#10","Light Book", 1, 170, "200"));
    	
    	
    }

    public static void test() {
    	System.out.println("Hello from the AnotherOrdersBusinessService");
    }

	

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orders;
	
	}

	@Override
	public void setOrders(List<Order> orders) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendOrder(Order order) {
		// TODO Auto-generated method stub
		
	}
}
