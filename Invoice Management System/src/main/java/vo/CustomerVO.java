package vo;

public class CustomerVO {
	private int id;
	private String fname;
	private String lname;
	private String email;
	public CustomerVO() {
		
	}
	
	public CustomerVO(int id, String fname, String lname, String email, String phone, String address, String country) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.country = country;
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return fname;
	}


	public void setFirstname(String fname) {
		this.fname = fname;
	}


	public String getLastname() {
		return lname;
	}


	public void setLastname(String lname) {
		this.lname = lname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	private String phone;
	private String address;
	private String country;

}
