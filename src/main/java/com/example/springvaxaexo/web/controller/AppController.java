package com.example.springvaxaexo.web.controller;

import com.example.springvaxaexo.business.data.JoueurInfo;
import com.example.springvaxaexo.business.data.MonstreInfo;
import com.example.springvaxaexo.business.logic.Joueur;
import com.example.springvaxaexo.business.logic.Poring;
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
        Joueur joueur = nomJoueur == null ? new Joueur() : new Joueur(nomJoueur);
        Poring poring = new Poring();
        return new NewGameResponseDTO((JoueurInfo) joueur.getData(), (MonstreInfo) poring.getData());
    }
}
