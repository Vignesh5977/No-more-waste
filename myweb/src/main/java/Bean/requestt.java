package Bean;

public class requestt {
	private String Name;
	private String Quantity;
	
	
	public requestt(String name, String quantity, String email, String phno, String address) {
		super();
		Name = name;
		Quantity = quantity;
		Email = email;
		Phno = phno;
		Address = address;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhno() {
		return Phno;
	}
	public void setPhno(String phno) {
		Phno = phno;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	private String Email;
	private String Phno;
	private String Address;
}
