package com.edu.array.test;



public class TonysArrayTest {

	public static void main(String[] args) {
		ContactService service = new ContactService();
		service.sendMessage("회의는 10시에 시작됩니다.");

	}

}
class Contact{
	String name;

	public Contact(String name) {
		this.name = name;
	}
	
	public void printName() {
		System.out.println(name+"...print!!");
	}
}
class ContactService{
	public void sendMessage(String msg) {
	//Bob's Code... Contact Type Array
	Contact[] contacts = new Contact[10];
	int x = 0;
	while(x<10) {
		contacts[x] = new Contact(msg);
		System.out.println(x+"th Contact..."+contacts[x]);
		contacts[x].printName();
	}
}
}
