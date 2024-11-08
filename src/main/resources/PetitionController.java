

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

 // @Controller - tells Spring this class handles web requests

// @autowired - connecting petitionService

// 

public class PetitionController {
	
	
	
	@Controller 
	public class PetitionController {
		private final PetitionService petitionService;
		
		// constructor to get service
		public PetitionController(PetitionService petitionService) {
			this.petitionService = petitionService;
		}
		
		
		// get request for showing all petitions(list.html)
		
		@GetMapping("/petitions")
		public String showAllPetitions(Model model) {
			// get all petitions from service
			List<Petition> petitions = petitioService.getAllPetitions();
			
			// add them to the model
			model.addAttribute("petitions", petitions);
			
			// return the template name (list.html)
			return "List";
		}
	}
	
	// get requests for showing create form(create.html)
	
		
	@GetMapping("/petitions/create"){
		public String showCreateForm(Model model) {
			return "create";
		}
	}
	
	// post requests for creating new petition 
	
	@PostMapping("/petitions/create"){
		public String createPetition(@RequestParam String title, @RequestParam String description) {
						
			// use your petitionService to create the petition, 
			petitionService.createPetition(title, description);
			
			// send user to list of petitions
			return "redirect:/petitions;
			
			
		}
		
	}
	

	// get request for searching (search.html)
	@GetMapping("/petitions/search"){
		
		public String searchPetitions(@RequestParam(required = false) String searchTerm, Model model) {
			
			if(searchTerm == null) {
				return "search";
			}
			
			List<Petition> results = PetitionService.searchPetitions(searchTerm);
			
			// add results to model for display
			model.addAttribute("petitions", results);
			model.addAttribute("searchTerm", searchTerm);
			
			return "results";
			
		
		}
	}
	
		// get request for viewing single petition (view.html)
		
		// post reqest for adding signature

}
