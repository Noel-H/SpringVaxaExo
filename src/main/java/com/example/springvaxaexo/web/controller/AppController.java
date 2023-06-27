package com.example.springvaxaexo.web.controller;

import com.example.springvaxaexo.business.data.JoueurInfo;
import com.example.springvaxaexo.business.data.MonstreInfo;
import com.example.springvaxaexo.business.enums.Job;
import com.example.springvaxaexo.business.logic.*;
import com.example.springvaxaexo.web.dto.GameDataDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AppController {

    @GetMapping("/newGame")
    public GameDataDTO getNewGameWithName(@RequestParam(value = "nomJoueur", required = false) String nomJoueur) {
        Joueur joueur = nomJoueur == null ? new Joueur() : new Joueur(nomJoueur);
        Poring poring = new Poring();
        return new GameDataDTO((JoueurInfo) joueur.getData(), (MonstreInfo) poring.getData());
    }

    @GetMapping("/newPlayer")
    public JoueurInfo newPlayer(@RequestParam(value = "nomJoueur", required = false) String nomJoueur) {
        Joueur joueur = nomJoueur == null ? new Joueur() : new Joueur(nomJoueur);
        return (JoueurInfo) joueur.getData();
    }

    @PostMapping("/visiterForet")
    public GameDataDTO visiterForet(@RequestBody GameDataDTO gameDataDTO) {
        Foret foret = new Foret(gameDataDTO.getMonstreDeLaForet());
        Joueur joueur = new Joueur(gameDataDTO.getJoueur());
        foret.visiter(joueur);
        return new GameDataDTO((JoueurInfo) joueur.getData(), (MonstreInfo) foret.getPoring().getData());
    }

    @PostMapping("/vendreGary")
    public GameDataDTO vendreGary(@RequestBody GameDataDTO gameDataDTO) {
        Gary gary = new Gary();
        Joueur joueur = new Joueur(gameDataDTO.getJoueur());
        gary.vendreTout(joueur);
        return new GameDataDTO((JoueurInfo) joueur.getData(), gameDataDTO.getMonstreDeLaForet());
    }

    @PostMapping("/voirSoigneur")
    public GameDataDTO voirSoigneur(@RequestBody GameDataDTO gameDataDTO) {
        Soigneur soigneur = new Soigneur();
        Joueur joueur = new Joueur(gameDataDTO.getJoueur());
        soigneur.soigner(joueur);
        return new GameDataDTO((JoueurInfo) joueur.getData(), gameDataDTO.getMonstreDeLaForet());
    }

    @PostMapping("/changerJob")
    public GameDataDTO changerJob(@RequestBody GameDataDTO gameDataDTO,
                                  @RequestParam("job") Job job) {
        Joueur joueur = new Joueur(gameDataDTO.getJoueur());
        JobChanger jobChanger = new JobChanger();
        jobChanger.promotion(joueur, job);
        return new GameDataDTO((JoueurInfo) joueur.getData(), gameDataDTO.getMonstreDeLaForet());
    }
}
