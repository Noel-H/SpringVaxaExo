package com.example.springvaxaexo.business.logic;

import com.example.springvaxaexo.business.data.MonstreInfo;
import com.example.springvaxaexo.business.enums.TypeObjet;

import java.util.Arrays;

public class Poring extends Personnage {
    private final MonstreInfo dataMonstre;

    public Poring() {
        this(new MonstreInfo(
                "Poring",
                50,
                50,
                3,
                true,
                Arrays.asList(TypeObjet.EMPTY_BOTTLE, TypeObjet.STICKY_MUCUS, TypeObjet.JELLOPY),
                100 * 100));
    }

    public Poring(MonstreInfo monstreInfo) {
        this.data = monstreInfo;
        this.dataMonstre = (MonstreInfo) this.data;
    }

    @Override
    public void comportementVictoire(Personnage personnage) {
        depouiller(personnage);
    }

    public int getValeurExp() {
        return this.dataMonstre.getValeurExp();
    }
}