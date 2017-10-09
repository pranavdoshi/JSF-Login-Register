package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


@ManagedBean(name = "user")
@SessionScoped
public class user {

	private String name;
    private String userid;
    private String email;
    private String address;
    private String password;
    private String dbPassword;
    private String dbName;
    DataSource ds;
  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String register()
	{
		

			// Setup the DataSource object
			int i = 0;
			System.out.println("HELLO");
//			if(name != null && userid != null && email != null && address != null && password != null  )
//			{
				System.out.println("HELLOkjhfkljwneflkjne");
				Connection con = null;
				  try {
					  	com.mysql.jdbc.jdbc2.optional.MysqlDataSource ds = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
						ds.setServerName(System.getenv("ICSI518_SERVER"));
						ds.setPortNumber(Integer.parseInt(System.getenv("ICSI518_PORT")));
						ds.setDatabaseName(System.getenv("ICSI518_DB"));
						ds.setUser(System.getenv("ICSI518_USER"));
						ds.setPassword(System.getenv("ICSI518_PASSWORD"));
						con = ds.getConnection();
						System.out.println("Pranav Here");
						String sql = "INSERT INTO user(username, name, password,email) VALUES(?,?,?,?,?)";
						PreparedStatement st = con.prepareStatement(sql);
						System.out.println("Pranav Here afterwards");
						st.setString(1, this.userid);
			             st.setString(2, this.name);
			             st.setString(3, this.password);
			             st.setString(4, this.address);
			             st.setString(5, this.email);
			             st.executeUpdate();
			             System.out.println("Data Added Successfully");
			             i++;
					}
				  catch (Exception e) {
						System.err.println("Exception: " + e.getMessage());
					} finally {
						try {
							con.close();
						} 
						catch (SQLException e) {
						}
					}
	 //if bracket close
			if (i > 0) {
	         return "registered";
		        } 
			else
			return "failed";
		    }

	public void dbData(String uname) {
         if (uname != null) {
            PreparedStatement ps = null;
            Connection con = null;
            ResultSet rs = null;
         
           // if (ds != null) {
                try {
                	com.mysql.jdbc.jdbc2.optional.MysqlDataSource ds = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
					ds.setServerName(System.getenv("ICSI518_SERVER"));
					ds.setPortNumber(Integer.parseInt(System.getenv("ICSI518_PORT")));
					ds.setDatabaseName(System.getenv("ICSI518_DB"));
					ds.setUser(System.getenv("ICSI518_USER"));
					ds.setPassword(System.getenv("ICSI518_PASSWORD"));
					con = ds.getConnection();
                    if (con != null) {
                        String sql = "select username,password from user where username = '"
                                + userid + "'";
                        ps = con.prepareStatement(sql);
                        rs = ps.executeQuery();
                        rs.next();
                        dbName = rs.getString("username");
                        System.out.println(dbName);
                        dbPassword = rs.getString("password");
                        System.out.println(dbPassword);
                    }
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
//            }
        }
    }

	public String log() {
        dbData(userid);
        if (userid.equals(dbName) && password.equals(dbPassword)) {
            return "successAttempt";
        } else
            return "failureAttempt";
    }

    public String logout() {
    	 FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
         return "index.xhtml?faces-redirect=true";
     
    }
}



