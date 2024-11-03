

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Petition {
	
	private int id;
	private String title;
	private String description;
	private List<Signature> signatures;
	private LocalDateTime creationDate;
	
	public Petition(int id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.signatures = new ArrayList<>();
		this.creationDate = LocalDateTime.now();
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public List<Signature> getSignatures(){
		return signatures;
	}
	
	public LocalDateTime getDate() {
		return creationDate;
	}
	
	public void setDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	
	public void setId(int id) {
		this.id = id;
				}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setSignatures(List<Signature> signatures) {
		this.signatures = signatures;
	}
	
	public void addSignature(Signature signature) {
		this.signatures.add(signature);
	}
	
	

}
