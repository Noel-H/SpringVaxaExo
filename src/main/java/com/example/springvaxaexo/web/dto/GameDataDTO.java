package com.example.springvaxaexo.web.dto;

import com.example.springvaxaexo.business.data.JoueurInfo;
import com.example.springvaxaexo.business.data.MonstreInfo;

public class GameDataDTO {

    private JoueurInfo joueur;
    private MonstreInfo monstreDeLaForet;

    public GameDataDTO(JoueurInfo joueur) {
        this.joueur = joueur;
    }

    public GameDataDTO(JoueurInfo joueur, MonstreInfo monstreDeLaForet) {
        this.joueur = joueur;
        this.monstreDeLaForet = monstreDeLaForet;
    }

    public JoueurInfo getJoueur() {
        return joueur;
    }

    public void setJoueur(JoueurInfo joueur) {
        this.joueur = joueur;
    }

    public MonstreInfo getMonstreDeLaForet() {
        return monstreDeLaForet;
    }

    public void setMonstreDeLaForet(MonstreInfo monstreDeLaForet) {
        this.monstreDeLaForet = monstreDeLaForet;
    }
}
