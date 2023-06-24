package com.example.springvaxaexo.web.controller;

import com.example.springvaxaexo.business.data.JoueurInfo;
import com.example.springvaxaexo.business.logic.Joueur;
import com.example.springvaxaexo.web.dto.NewGameResponseDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AppController {

    @GetMapping("/newGame")
    public NewGameResponseDTO getNewGameWithName(@RequestParam(value = "nomJoueur", required = false) String nomJoueur) {
        NewGameResponseDTO newGameResponseDTO = new NewGameResponseDTO();
        Joueur joueur = nomJoueur == null ? new Joueur() : new Joueur(nomJoueur);
        newGameResponseDTO.setJoueur((JoueurInfo) joueur.getData());
        return newGameResponseDTO;
    }
}
