package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import business.AnotherOrdersBusinessService;
import business.MyTimerService;
import business.OrdersBusinessInterface;


@ManagedBean
@ViewScoped
@Stateless

public class FormController {
	
	@Inject
	OrdersBusinessInterface service;
	
	@EJB
	MyTimerService timer;
	
	
	//*public String onSubmit(User user) throws SQLException{
		
		//user.getFirstName();
		//user.getLastName();
		
	
		//timer.setTimer(10000);
	
		
		//getAllOrders();
		
		
		//insertOrder();
		
		//getAllOrders();		
		
		
		
		
		
		
		
		
		//return "TestResponse.xhtml";
		
	//}
	

	public String Authenticate(User user) 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//put the user object into the POST request
		user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "CustomerLoginSuccess.xhtml";
	}
	
	public OrdersBusinessInterface getService() {
        return service;
    }
	private void getAllOrders(){
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "1e73A41182!";
		Connection conn = null;
	
		try
		{
			conn = DriverManager.getConnection(url, username, password );
			if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
			String query = "SELECT * FROM testapp.orders";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
		    while(result.next()) {
		    	  System.out.print("ID: "+result.getInt("ID")+", ");
		          System.out.print("Product Name: "+result.getString("PRODUCT_NAME")+", ");
		          System.out.print("Price: "+result.getFloat("PRICE"));
		          System.out.println();
		       }
		    result.close();
		    statement.close();conn.close();

		}
		catch (SQLException e)
		{
			System.out.println("failure!!");
		}
		finally {
			
		}

	}
	
	private void insertOrder() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "1e73A41182!";
		Connection conn = null;
	
		try
		{
			conn = DriverManager.getConnection(url, username, password );
			if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
			String update = "INSERT INTO  testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) "
					+ "VALUES('001122334455', 'This was inserted new', 25.00, 100)";

			Statement statement = conn.createStatement();
			statement.executeUpdate(update);
			statement.close();conn.close();

		}
		catch (SQLException e)
		{
			System.out.println("failure!!");
		}

	}
	
	public String onSendOrder() {
		
		Order test = new Order("1","Burger", 0, (float) 5.00, "Boat");
		test.setID("1");
		service.sendOrder(test);
		return "OrderResponse.xhtml";
	}
	
	public String onLogoff(){
		
		
		// Invalidate the Session to clear the security token
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			
		// Redirect to a protected page (so we get a full HTTP Request) to get Login Page
		return "TestResponse.xhtml?faces-redirect=true";

		
		
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//private Object getAllOrders() throws SQLException {
		
		
		//Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1e73A41182!");

		//Statement statement = conn.createStatement();

		//String sqlCommand = "SELECT * FROM testapp.ORDERS";

		//ResultSet rs = statement.executeQuery(sqlCommand) ;
		
		//System.out.println(rs.next());
		//System.out.println(rs.getInt(0));
		//System.out.println(rs.getString(sqlCommand));
		//System.out.println(rs.getFloat(0));
		
		
		//conn.close();
		
		//return sqlCommand;
		
		
	
	//}
	

	
	//private void insertOrder() throws SQLException {
		
		//Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1e73A41182!");

		//Statement statement = conn.createStatement();

		//String sqlCommand = "INSERT INTO testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY)"

		//+ "VALUES('001122334455', 'This was inserted new', 25.00, 100);";

		//ResultSet rs = statement.executeQuery(sqlCommand) ;
		
		//statement.executeUpdate(sqlCommand);

	//}
	
	
//}
        
	


	
	
	



