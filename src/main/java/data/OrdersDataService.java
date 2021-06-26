package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Order;


@Stateless
@LocalBean
public class OrdersDataService implements DataAccessInterface{

	
	
	
	
	@Override
	public List<Order> findAll() throws SQLException {
		
		
		
		
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String username = "postgres";
			String password = "1e73A41182!";
			Connection conn = null;
			List<Order> orders = new ArrayList<Order>(); 
			
			System.out.println("Find All method");
		
			try
			{
				conn = DriverManager.getConnection(url, username, password );
				if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
				String query = "SELECT * FROM testapp.orders";
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(query);
				
				while(result.next()) {
			    	  Order order = new Order(null, null, 0, 0, query);;
			          order.setID(result.getString("ID"));
			          order.setProductName(result.getString("PRODUCT_NAME"));
			          order.setPrice(result.getFloat("PRICE"));
			          order.setQuantity(result.getInt("QUANTITY"));
			          orders.add(order);
			       }
			    result.close();
			    statement.close();conn.close();
			    System.out.println(orders.toString());
			    

			}
			catch (SQLException e)
			{
				System.out.println("failure!!");
			}

			return orders;
		
		
		
		
		
		
		
		//Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1e73A41182!");

		//Statement statement = conn.createStatement();

		//String sqlCommand = "SELECT * FROM testapp.ORDERS";

		//ResultSet rs = statement.executeQuery(sqlCommand) ;
				
		//System.out.println(rs.next());
		//System.out.println(rs.getInt(0));
		//System.out.println(rs.getString(sqlCommand));
		//System.out.println(rs.getFloat(0));
		//System.out.println(orders);
				
				
		//conn.close();
		//return null;
				
		
				
		
	}
	
	List<Order> orders = new ArrayList<Order>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
		
	};
		

	public  Order findById(int id) {
		return null;
	}
	
	public void create(Order order) {
		
	}
	
	public void update(Order order) {
		
	}
	
	public void delete(Order order) {
		
	}

	public void send(Order send) {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "1e73A41182!";
		Connection conn = null;
		
		try
		{
			conn = DriverManager.getConnection(url, username, password );
			if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
			String sql = String.format("INSERT INTO  testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES"
					+ "('%s', '%s', %f, %d)", send.getOrderNumber(), send.getProductName(), send.getPrice(), send.getQuantity());

			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
			statement.close();conn.close();

		}
		catch (SQLException e)
		{
			System.out.println("failure!!");
		}
		
	}
		
	}

	
	
	


