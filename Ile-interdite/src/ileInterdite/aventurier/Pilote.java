/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileInterdite.aventurier;

import ileInterdite.Grille;
import ileInterdite.Tuile;
import java.util.ArrayList;

/**
 *
 * @author vinetg
 */
public class Pilote extends Aventurier {
    
       public Pilote(int nbAction,Tuile tuile){
       super(nbAction,tuile);       
    }
    
    
        
    @Override
    public ArrayList<Tuile> calculDeplacement(Grille g){
        return g.tuilesSeches();
    }
    
   
}
