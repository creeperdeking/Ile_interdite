/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileInterdite.model.aventurier;

import utilitaires.Role;
import utilitaires.Pion;
import utilitaires.EtatTuile;
import ileInterdite.model.Grille;
import ileInterdite.model.Tuile;
import java.util.ArrayList;

/**
 *
 * @author vinetg
 */
public class Explorateur extends Aventurier {

    /**
     * On définit le constructeur de Explorateur avec une tuile Tuile et un nom
     * String
     *
     * @param tuile
     * @param nom
     */
    public Explorateur(String nom, Tuile tuile) {
        super(nom, tuile);
        setRole(Role.Explorateur);
        setPion(Pion.VERT);
    }

    /**
     * On renvoie une liste des tuiles adjacentes en carré
     *
     * @param g
     * @return
     */
    @Override
    public ArrayList<Tuile> calculDeplacement(Grille g) {
        return enleverTuilesCoulees(g.tuilesAdjacentesCarre(getTuile()));
    }

    @Override
    public ArrayList<Tuile> calculGuide(Grille g) {
        ArrayList<Tuile> tuiles = new ArrayList<>();
        for (Tuile t : g.tuilesAdjacentesCarre(getTuile())) {
            if (t.getEtat() != EtatTuile.COULEE) {
                if (!tuiles.contains(t)) {
                    tuiles.add(t);
                }
                for (Tuile tt : g.tuilesAdjacentesCarre(t)) {
                    if (tt != getTuile() && !tuiles.contains(tt)) {
                        tuiles.add(tt);
                    }
                }
            }
        }
        return enleverTuilesCoulees(tuiles);
    }

    /**
     * On renvoie une liste des tuiles adjacentes en carré
     *
     * @param g
     * @return
     */
    @Override
    public ArrayList<Tuile> calculAssechement(Grille g) {
        ArrayList<Tuile> liste = new ArrayList<Tuile>();

        if (getTuile().getEtat() == EtatTuile.INONDEE) {
            liste.add(getTuile());
        }

        for (Tuile t : g.tuilesAdjacentesCarre(getTuile())) {
            if (t.getEtat() == EtatTuile.INONDEE) {
                liste.add(t);
            }
        }
        return liste;
    }

}
