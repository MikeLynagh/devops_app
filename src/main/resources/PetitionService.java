

import java.util.Arraylist;
import java.util.List;
import java.time.LocalDateTime;

import com.example.web_app.model.Petition;
import com.example.web_app.model.Signature;

public class PetitionService {
	private List<Petition> petitions;
	private int nextId;
	
	//create new petition
	
	public PetitionService() {
		this.petitions = new ArrayList<>();
		this.nextId = 1;
	}
	
	public Petition createPetition(String title, String description) {
		// create a new petition with current nextid, then increment it
		Petition newPetition = new Petition(nextId++, title, description);
		
		// add new petition to list
		petitions.add(newPetition);
		
		// return petition
		return newPetition;
		
		
	}
	
	
	
	// get all petitions
	public List<Petition> getAllPetitions(){
		return petitions;
	}
	
	// find petition by id
	public Petition getPetitionById(int id) {
		for (Petition petition: petitions) {
			if(petition.getId() == id) {
				return petition;
			} 
			
		}
		return null; 
	}
	
	// search petitions 
	public List<Petition> searchPetitions(String searchTerm){
		//create list for results
		List<Petition> matchingPetition = new ArrayList<>();
		 for (Petition petition : petitions) {
			 if(petition.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
				 matchingPetition.add(petition)
			 } 
				
		 }
		 return matchingPetition;
	}
	
	// add a signature to a petition 
	public void signPetition(int petitionId, String name, String email) {
		Petition petition = getPetitionById(petitionId);
		// check if petition exists
		if (petition != null) {
			Signature newSignature = new Signature(name, email, LocalDateTime.now());
			petition.add(newSignature);
		}
	}
}
