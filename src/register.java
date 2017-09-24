import javax.faces.bean.ManagedBean;

@ManagedBean(name="reg")
public class register {

	private String fname;
	private String lname;
	private String contactno;
	private String email;
	private String password;
 	
		
	
	
	public String getFname() {
		return fname;
	}




	public void setFname(String fname) {
		this.fname = fname;
	}




	public String getLname() {
		return lname;
	}




	public void setLname(String lname) {
		this.lname = lname;
	}




	public String getContactno() {
		return contactno;
	}




	public void setContactno(String contactno) {
		this.contactno = contactno;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String registerValidate()
	{
		return "registered";
	}
	
}
