

import java.util.Arraylist;
import java.util.List;
import java.util.UUID;

import com.example.web_app.model.Petition;
import com.example.web_app.model.Signature;

public class PetitionService {
	private List<Petition> petitions;
	private int nextId;
	
	//create new petition
	public Petition createPetition(String title, String description) {
		this.title = title;
		this.description;
		this.nextId = id;
	}
	
	// function to generate uniqueId
	function uniqueId() {
		String uniqueId = UUID.randomUUID().toString();
	}
	
	// get all petitions
	public List<Petition> getAllPetitions(){
		return petitions;
	}
	
	// find petition by id
	public Petition getPetitionById(int id) {
		return id;
	}
	
	// search petitions 
	public List<Petition> searchPetitions(String searchTerm){
		 for (List element : petitions) {
			 if(element.contains(searchTerm)) {
				 return element;
			 }
		 }
	}
	
	// add a signature to a petition 
	public void signPetition(int petitionId, String name, String email) {
		this.getPetitionById = petitionId;
		this.name = name;
		this.email = email;
	}
	
	

}
