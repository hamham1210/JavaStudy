package web.servlet.controller.workshop03;

public class User {

	private String id;
	private int password;
	private String name;
	private String adress;
	
	public User() {
		
	}
	public User(String id, int password, String name, String adress) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.adress = adress;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", adress=" + adress + "]";
	}
	
}
