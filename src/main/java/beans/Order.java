package beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class Order {
	
	private String OrderNumber;
	private String ProductName;
	private String ID;
	
	
	private int Quantity;
	
	private float Price;
	
	public Order(String OrderNumber, String ProductName, int Quantity, float Price, String ID) {
		this.OrderNumber = OrderNumber;
		this.ProductName = ProductName;
		
		this.Quantity = Quantity;
		this.Price = Price;
		this.setID(ID);
		
		
	}

	public String getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	
	
	
	

}
