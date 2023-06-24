package com.example.springvaxaexo.web.dto;

import com.example.springvaxaexo.business.data.JoueurInfo;
import com.example.springvaxaexo.business.data.MonstreInfo;

public class NewGameResponseDTO {

    private JoueurInfo joueur;
    private MonstreInfo monstreDeLaForet;

    public NewGameResponseDTO(JoueurInfo joueur) {
        this.joueur = joueur;
    }

    public NewGameResponseDTO(JoueurInfo joueur, MonstreInfo monstreDeLaForet) {
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
