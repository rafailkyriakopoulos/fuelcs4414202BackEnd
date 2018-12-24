package teilar.cs4414202.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User {
	@Id
	@Column(length=45)
	private String username;
	
	@Column(length=45)
	@NotNull
	private String password;
	
	@Column(length=255,unique=true)
	@NotNull
	@Email
	private String email;
	
	@OneToMany(mappedBy="user")
	private List<GasStation> gastation;
	
	@OneToMany(mappedBy="user")
	private List<Order> orders;
	
	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<GasStation> getGastation() {
		return gastation;
	}

	public void setGastation(List<GasStation> gastation) {
		this.gastation = gastation;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	
	
	

}
