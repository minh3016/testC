package VendingMachine;

public class Product {
	private String name;
	private long  price;
	private int quantity;
	
	public Product(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isAvailable()
	{
		return quantity > 0;
	}
	public void dispense()
	{
		if(quantity > 0)
		{
			quantity --;
		}
	}
}
