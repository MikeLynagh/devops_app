package com.example.web_app.controller;

import com.example.web_app.model.Petition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PetitionController {
    private List<Petition> petitions = new ArrayList<>();

    public PetitionController() {
        // Sample petitions
        Petition greenway = new Petition(
            "Moycullen Greenway",
            "Create a greenway to remove traffic from main roads commuting from Oughterard to Galway",
            5000);
        petitions.add(greenway);

        Petition gluas = new Petition(
            "GLUAS for Galway",
            "Create a light rail line from Knocknacarra to Oranmore to improve traffic congestion within the city",
            10000);
        petitions.add(gluas);
    }

    @GetMapping("/create-petition")
    public String showCreatePetitionForm() {
        return "forward:/create-petition.html";
    }

    @GetMapping("/view-petitions")
    public String showPetitions(Model model) {
        model.addAttribute("petitions", petitions);
        return "forward:/view-petitions.html";
    }

    @PostMapping("/petition/create")
    public String createPetition(@RequestParam String title,
                               @RequestParam String description,
                               @RequestParam int target) {
        Petition petition = new Petition(title, description, target);
        petitions.add(petition);
        return "redirect:/view-petitions";
    }

    @GetMapping("/api/petitions")
    @ResponseBody
    public List<Petition> getPetitions() {
        return petitions;
    }
}