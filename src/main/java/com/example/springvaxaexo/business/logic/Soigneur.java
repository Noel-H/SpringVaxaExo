package com.example.springvaxaexo.business.logic;

import com.example.springvaxaexo.business.logic.Joueur;

public class Soigneur {
    public void soigner(Joueur joueur) {
        if (!joueur.payer(30)) {
            return;
        }

        System.out.println("Voilà votre soin");
        joueur.recupererPV(joueur.getPvMax());
    }
}
