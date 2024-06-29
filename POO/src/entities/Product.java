package entities;

public class Product {

	// Attributes
	public String name;
	public double price;
	public int quantity;
	
	// Constructor
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// Methods
	public void addQuantity(int value) {
		quantity += value; 
	}
	
	public void removeQuantity(int value) {
		quantity -= value;
	}
	
	public double valueTotal() {
		return quantity * price;
	}
	
	// toString overrided
	@Override
	public String toString() {
		return "Product data:"
				+ name
				+ " $ "
				+ String.format("%.2f", price)
				+ ", "
				+ quantity
				+ " units, Total: $ " 
				+ String.format("%.2f", valueTotal());
	}
	
	
}
