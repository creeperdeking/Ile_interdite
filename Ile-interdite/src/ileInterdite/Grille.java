/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileInterdite;

import java.util.ArrayList;

/**
 *
 * @author grosa
 */
public class Grille {
    private static int longueurTerrain = 6;
    private Tuile[][] tuiles = new Tuile[longueurTerrain][longueurTerrain];
    
    public Grille() {
        
    }
    
    public Tuile getTuile(Position p) {
        return tuiles[p.x][p.y];
    }
    
    // Retourne un tableau des 4 tuiles adjascentes à la position pos selon ce
    // pattern:
    //           tuile[0]
    //    tuile[3] pos tuile[1]
    //           tuile[2]
    public Tuile[] tuilesAdjacentesCroix(Position posTuile) {
        Tuile[] tuilesAdjacentes = new Tuile[4];
        tuilesAdjacentes[0] = tuiles[posTuile.x][posTuile.y+1];
        tuilesAdjacentes[1] = tuiles[posTuile.x+1][posTuile.y];
        tuilesAdjacentes[2] = tuiles[posTuile.x][posTuile.y-1];
        tuilesAdjacentes[3] = tuiles[posTuile.x-1][posTuile.y];
        
        return tuilesAdjacentes;
    }
    
    // Retourne un tableau des 4 tuiles adjascentes à la position pos selon ce
    // pattern:
    //    tuile[0] tuile[1] tuile[2]
    //    tuile[3]   pos    tuile[4]
    //    tuile[5] tuile[6] tuile[7]
    public Tuile[] tuilesAdjacentesCarre(Position posTuile) {
        Tuile[] tuilesAdjacentes = new Tuile[8];
        
        int i = 0;
        for (int y = 1; y <= -1; y--) {
            for (int x = -1; x <= 1; x++) {
                if (x == 0 && y == 0)
                    continue;
                else {
                    tuilesAdjacentes[i] = tuiles[posTuile.x+x][posTuile.y+y];
                    i += 1;
                }
            }
        }
        
        return tuilesAdjacentes;
    }
    
    //TODO: Remplir
    public ArrayList<Tuile> tuilesSeches() {
        ArrayList<Tuile> tuilesSeches = new ArrayList();
        
        for (int x = 0; x <= longueurTerrain; x++) {
            for (int y = 0; y != longueurTerrain; y++) {
                if (tuiles[x][y].getEtat() == EtatTuile.SECHE) {
                    tuilesSeches.add(tuiles[x][y]);
                }
            }
        }
        
        return tuilesSeches;
    }
    
    public ArrayList<Tuile> tuilesAccessiblesPlongeur(Position posTuile) {
        ArrayList<Tuile> tuilesSeches = new ArrayList();
        return tuilesSeches;
    }
}