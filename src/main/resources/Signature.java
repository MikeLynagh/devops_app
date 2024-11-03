

import java.time.LocalDateTime;

public class Signature {
	
	private String name;
	private String email;
	private LocalDateTime date;
	
	public Signature(String name, String email, LocalDateTime date) {
		this.name = name;
		this.email = email;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public localDateTime getDate() {
		return date;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	

}
