package JUnit;

public class OrderService {
	private int stock=10;
	private double discount =0.10;
	public int getstock(){
		return stock;
		
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getDiscout() {
		return discount;
		
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double calPrice(double price, int quantity) {
		return price*quantity*(1-discount);
		
	}
	public boolean placeOrder(int quantity) {
		if (quantity > stock) {
			throw new IllegalArgumentException ("Insuffient stock");
		}
		stock -= quantity;
		return true;
	}

}
