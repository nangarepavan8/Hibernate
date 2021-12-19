package pojos;

import java.util.Date;
import javax.persistence.*;


@Entity                  //class level anotations : mandatory
@Table(name = "my_users")
public class User {
	

	private Integer userId;   // int works(autoBoxing)  long also work
	private String name,email,passwod;
	private double	 reAmount;
	private Date regDate;
	private Role userRole;      // role as a enum
	private byte[] image;
	// must supply def argument less contructor
	
	public User() {
		
		System.out.println("in user contructor");	
	}
	
	
	// add parametrized constructors
	public User(String name, String email, String passwod, double reAmount, Date regDate, Role userRole) {
		super();
		this.name = name;
		this.email = email;
		this.passwod = passwod;
		this.reAmount = reAmount;
		this.regDate = regDate;
		this.userRole = userRole;
	}


	
	// all getter settet : must 

	@Id // filed level or getter (property level)  --> PK
	
	//automatic id generartion
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // auto increment
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	@Column(length = 20)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Column(length = 30, unique = true)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20)
	public String getPasswod() {
		return passwod;
	}


	public void setPasswod(String passwod) {
		this.passwod = passwod;
	}

	@Column(name = "reg_amount")
	public double getReAmount() {
		return reAmount;
	}


	public void setReAmount(double reAmount) {
		this.reAmount = reAmount;
	}

	@Temporal(TemporalType.DATE)  //date type
	@Column(name = "reg_Date")
	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Enumerated(EnumType.STRING)    // col type varchar
	@Column(name = "role", length = 20)
	public Role getUserRole() {
		return userRole;
	}


	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}


	@Lob      // large object , col type : blob
	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}

	//optionally override toString

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", passwod=" + passwod + ", reAmount="
				+ reAmount + ", regDate=" + regDate + ", userRole=" + userRole + "]";
	}
	
	
	
	
}
