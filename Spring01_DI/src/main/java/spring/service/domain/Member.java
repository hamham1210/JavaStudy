package spring.service.domain;



public class Member {
	
	private String id;
	private String password;
	private String name;
	private String address;
	
	public static final String DEFAULT_NAME = "아무개";
	public static final String DEFAULT_ADDR = "서울시";	
	
	public Member() {}// 기본생성자를 꼭 만들어야한다. 생성자를 내가 아닌 spring이 해주기 때문이다.
	public Member(String id, String password) {
		//같은 클래스에서 또 다른 생성자 호출
		this(id, password, DEFAULT_NAME, DEFAULT_ADDR );
	}
	
	public Member(String id, String password, String name, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + "]";
	}
	
}