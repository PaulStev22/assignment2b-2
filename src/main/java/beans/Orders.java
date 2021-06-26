package beans;




import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped


public class Orders {
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}



	private String ProductName;
	private String OrderNumber;
	private int Quantity;
	private float Price;
	private int ID;
	
	
	private static final ArrayList<Orders> orders = new ArrayList<Orders>(Arrays.asList(
			
			new Orders(), new Orders(),new Orders(),new Orders()));
	
	
	
	
	
	
	
	
	
	
	public String getProductName() {
		return ProductName;
	}



	public void setProductName(String productName) {
		ProductName = productName;
	}



	public String getOrderNumber() {
		return OrderNumber;
	}



	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}



	public int getQuantity() {
		return Quantity;
	}



	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}



	public float getPrice() {
		return Price;
	}



	public void setPrice(float Price) {
		this.Price = Price;
	}

	
	
	public ArrayList<Orders> getOrders(){
		
		
		return orders;
		
		
		
	}



	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}
	
	
	

}
