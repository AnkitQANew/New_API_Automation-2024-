package POJO_Nested_JSON;

public class Employes_Details
{
	private String FirstName;
	private String lastname;
	private String gender;
	private int age;
	private double salary;
	private Employee_Address Address;
	
	
	public Employee_Address getAddress() {
		return Address;
	}
	public void setAddress(Employee_Address address) {
		Address = address;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setgetFirstName(String firstname) {
		this.FirstName = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	

}
