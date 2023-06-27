package com.example.springvaxaexo.business.logic;

import com.example.springvaxaexo.business.data.MonstreInfo;

public class Foret {
    private Poring poring;

    public Foret() {
        this.poring = new Poring();
    }

    public Foret(MonstreInfo monstreInfo) {
        this.poring = new Poring(monstreInfo);
    }

    public Poring getPoring() {
        return poring;
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
