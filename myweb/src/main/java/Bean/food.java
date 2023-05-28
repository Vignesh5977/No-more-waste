package Bean;

public class food {
	private String Name;
	private String Quanlity;
	private String Email;
	private String Phno;
	private String Address;
	
	public food(String name, String quanlity, String email, String phno, String address) {
		super();
		Name = name;
		Quanlity = quanlity;
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
	public String getQuanlity() {
		return Quanlity;
	}
	public void setQuanlity(String quanlity) {
		Quanlity = quanlity;
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
	
}
