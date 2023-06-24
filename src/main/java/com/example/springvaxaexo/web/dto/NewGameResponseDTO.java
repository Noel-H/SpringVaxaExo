package com.example.springvaxaexo.web.dto;

import com.example.springvaxaexo.business.data.JoueurInfo;

public class NewGameResponseDTO {

    private JoueurInfo joueur;

    public JoueurInfo getJoueur() {
        return joueur;
    }

    public void setJoueur(JoueurInfo joueur) {
        this.joueur = joueur;
    }
}
