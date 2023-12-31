package com.example.springvaxaexo.business.logic;

public class Foret {
    private Poring poring;

    Foret() {
        this.poring = new Poring();
    }

    public void visiter(Personnage personnage) {
        while (personnage.estVivant() && this.poring.estVivant()) {
            personnage.attaquer(this.poring);
            this.poring.attaquer(personnage);
        }

        if (!this.poring.estVivant()) {
            personnage.comportementVictoire(this.poring);
            this.poring = new Poring();
        }

        if (!personnage.estVivant()) {
            this.poring.comportementVictoire(personnage);
        }
    }
}
