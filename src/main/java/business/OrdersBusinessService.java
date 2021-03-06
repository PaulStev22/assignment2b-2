package business;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import beans.Order;
import beans.Orders;
import data.OrdersDataService;



/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@LocalBean
@Alternative
@Local(OrdersBusinessInterface.class)
public class OrdersBusinessService implements OrdersBusinessInterface{

	
	@Resource(mappedName="java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName="java:/jms/queue/Order")
    private Queue queue;
	
    @EJB
    OrdersDataService service;
	
	List<Order> orders1;
	
	
    /**
     * Default constructor. 
     * @param orders 
     */
    
	public OrdersBusinessService() {
        
    	//orders1 = Arrays.asList(new Order("#1", "Cook Book", 1, 20), new Order("#2","Exercise Book", 1, 10));
    	
    	
    }
    
    

	public static void test() {
    	System.out.println("Hello From the OrdersBusinessService");
    	
    }

	@Override
	public List<Order> getOrders() throws SQLException {
		
		return service.findAll();
	}

	@Override
    public void sendOrder(Order order) {
        //send a Message for an Order
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
         //   TextMessage message1 = session.createTextMessage();
            ObjectMessage message2 = session.createObjectMessage();
            message2.setObject((Serializable) order);
         //   message1.setText("This is test message");
        //    messageProducer.send(message1);
            messageProducer.send(message2);
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }



	@Override
    public void setOrders(List<Order> orders) {
        // TODO Auto-generated method stub
    }
 

}
