import javax.faces.bean.ManagedBean;

@ManagedBean(name="obj")
public class Login {

	private String userName;
	private String password;
	
		
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String loginValidate()
	{
		if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin"))
		{
			return "successAttempt";
		}
		else
		{
			return "failureAttempt";
		}
	}
	
}
