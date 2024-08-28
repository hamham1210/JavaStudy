package web.http.vo;

public class Product {
	private int Num;
	private String name;
	private int price;
	private String explain;
	
	public Product() {
	
	}
	
	public Product(int num, String name, int price, String explain) {
		super();
		Num = num;
		this.name = name;
		this.price = price;
		this.explain = explain;
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	@Override
	public String toString() {
		return "Product [Num=" + Num + ", name=" + name + ", price=" + price + ", explain=" + explain + "]";
	}
}
