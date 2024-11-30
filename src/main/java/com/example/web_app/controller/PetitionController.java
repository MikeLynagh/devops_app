package com.example.web_app.controller;

import com.example.web_app.model.Petition;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PetitionController {
    private List<Petition> petitions = new ArrayList<>();

    @GetMapping("/create-petition")
    public String showCreatePetitionForm() {
        return "create-petition";
    }

    @PostMapping("/petition/create")
    public String createPetition(@RequestParam String title, 
                               @RequestParam String description,
                               @RequestParam int target) {
        Petition petition = new Petition(title, description, target);
        petitions.add(petition);
        return "redirect:/view-petitions";
    }
}