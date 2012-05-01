package eu.choreos.model;

public class User {
	
	private String id;
	private String age;
	private String name;
	private String address;

	public User(){}
	
	public User(String id, String name, String age, String address) {
		setId(id);
		setName(name);
		setAge(age);
		setAddress(address);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
