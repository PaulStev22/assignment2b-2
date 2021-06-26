package business;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import beans.Order;
import data.OrdersDataService;

import javax.ejb.MessageDriven;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;






@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/Order"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/Order")


public class OrderMessageService implements MessageListener {

	
	
	@EJB
	OrdersDataService service;
	Order send;
    /**
     * Default constructor. 
     */
    public OrderMessageService() {
        // TODO Auto-generated constructor stub
    }
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message)  {
    	if (message instanceof Message) {
            try {
        		ObjectMessage objectMessage = (ObjectMessage) message;
        		send = new Order(null, null, 0, 0, null);
        		send = (Order)objectMessage.getObject();
        		service.send(send);
        		System.out.println("ON Message method:  "+ send.getOrderNumber());
            	
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }};
    
        }

}
	
	
	
	
	
	
	
	
