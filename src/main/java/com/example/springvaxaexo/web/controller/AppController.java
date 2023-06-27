package com.example.springvaxaexo.web.controller;

import com.example.springvaxaexo.business.data.JoueurInfo;
import com.example.springvaxaexo.business.data.MonstreInfo;
import com.example.springvaxaexo.business.enums.Job;
import com.example.springvaxaexo.business.logic.*;
import com.example.springvaxaexo.web.dto.NewGameResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AppController {

    @GetMapping("/newGame")
    public NewGameResponseDTO getNewGameWithName(@RequestParam(value = "nomJoueur", required = false) String nomJoueur) {
        Joueur joueur = nomJoueur == null ? new Joueur() : new Joueur(nomJoueur);
        Poring poring = new Poring();
        return new NewGameResponseDTO((JoueurInfo) joueur.getData(), (MonstreInfo) poring.getData());
    }

    @GetMapping("/newPlayer")
    public JoueurInfo newPlayer(@RequestParam(value = "nomJoueur", required = false) String nomJoueur) {
        Joueur joueur = nomJoueur == null ? new Joueur() : new Joueur(nomJoueur);
        return (JoueurInfo) joueur.getData();
    }


    @PostMapping("/visiterForet")
    public NewGameResponseDTO visiterForet(@RequestBody NewGameResponseDTO newGameResponseDTO) {
        Foret foret = new Foret(newGameResponseDTO.getMonstreDeLaForet());
        Joueur joueur = new Joueur(newGameResponseDTO.getJoueur());
        foret.visiter(joueur);
        return new NewGameResponseDTO((JoueurInfo) joueur.getData(), (MonstreInfo) foret.getPoring().getData());
    }

    @PostMapping("/vendreGary")
    public NewGameResponseDTO vendreGary(@RequestBody NewGameResponseDTO newGameResponseDTO) {
        Gary gary = new Gary();
        Joueur joueur = new Joueur(newGameResponseDTO.getJoueur());
        gary.vendreTout(joueur);
        return new NewGameResponseDTO((JoueurInfo) joueur.getData(), newGameResponseDTO.getMonstreDeLaForet());
    }

    @PostMapping("/voirSoigneur")
    public NewGameResponseDTO voirSoigneur(@RequestBody NewGameResponseDTO newGameResponseDTO) {
        Soigneur soigneur = new Soigneur();
        Joueur joueur = new Joueur(newGameResponseDTO.getJoueur());
        soigneur.soigner(joueur);
        return new NewGameResponseDTO((JoueurInfo) joueur.getData(), newGameResponseDTO.getMonstreDeLaForet());
    }

    @PostMapping("/changerJob")
    public NewGameResponseDTO changerJob(@RequestBody NewGameResponseDTO newGameResponseDTO,
                                         @RequestParam("job") Job job) {
        Joueur joueur = new Joueur(newGameResponseDTO.getJoueur());
        JobChanger jobChanger = new JobChanger();
        jobChanger.promotion(joueur, job);
        return new NewGameResponseDTO((JoueurInfo) joueur.getData(), newGameResponseDTO.getMonstreDeLaForet());
    }
}
