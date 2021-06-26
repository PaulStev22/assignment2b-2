package business;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Order;

@RequestScoped
@Path("/orders")
public class OrdersRestService {
	
	@Inject
    OrdersBusinessInterface service;

    @GET
    @Path("/getjson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getOrdersAsJson() throws SQLException{//GET a JSON of all stored orders
        return service.getOrders();
    }

    @GET
    @Path("/getxml")
    @Produces(MediaType.APPLICATION_XML)
    public Order[] getOrdersAsXml() throws SQLException{//GET an XML of all stored orders
        List<Order> list = service.getOrders();
        Order[] xml = new Order[list.size()];
        for (int i =0; i < list.size(); i++)
            xml[i] = list.get(i);
        return xml;
    }
    

}

	
	


