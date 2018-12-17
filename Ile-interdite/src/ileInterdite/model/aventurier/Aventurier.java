/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileInterdite.model.aventurier;

import ileInterdite.model.EtatTuile;
import ileInterdite.model.Grille;
import ileInterdite.model.Position;
import ileInterdite.model.Tuile;
import java.util.ArrayList;

/**
 *
 * @author vinetg
 */
public abstract class Aventurier {
    private int nbAction;
    private Tuile tuile;
    private Boolean pouvoir = true;
    private Role Role;
    private String nomJoueur;
    private Pion pion;
    
    public Aventurier(String nom,Tuile tuile) {
<<<<<<< HEAD
        this.tuile=tuile;
        setNomJoueur(nom);
=======
        this.tuile = tuile;
        nomJoueur = nom;
>>>>>>> 1c48084db385905fb5b6db1c614682d155fdfa7a
        reset();
    }

    /**
     * On renvoie la liste des tuiles adjacentes en croix
     * @param g
     * @return 
     */
    public ArrayList<Tuile> calculDeplacement(Grille g){
        return g.tuilesAdjacentesCroix(getTuile()); 
    }
    
    /**
     * On renvoie la liste des tuiles adjacentes en croix
     * @param g
     * @return 
     */
    public ArrayList<Tuile> calculAssechement(Grille g){
        ArrayList<Tuile> liste = new ArrayList();
        if (tuile.getEtat() == EtatTuile.INONDEE){
            liste.add(getTuile());
        }
        for (Tuile t : g.tuilesAdjacentesCroix(tuile)){
            if (t.getEtat() == EtatTuile.INONDEE){
                liste.add(t);
            }
        }
        return liste;
    }
    
    /**
     * On remet le nombre d'actions à 3
     */
    public void reset(){
        nbAction = 3;
        setPouvoir(true);
    }
    
    /**
     * Fais diminuer le nombre d'actions de 1
     */
    public void decremente(){
        nbAction --;
    }

    /**
    * Permet de déplacer un aventurier sur une nouvelle Tuile
    * en supprimant sa position précédente
     * @param tuile
    */
    public void setTuile(Tuile tuile) {
        tuile.removeAventurier(this);
        tuile.addAventurier(this);
        this.tuile = tuile;
    }
    
    //Getters et Setters :
    
    
    public Position getPosition() {
        return tuile.getPosition();
    }
    
      /**
     * @return the tuile
     */   
    public Tuile getTuile(){
        return tuile;
    }
    
     /**
     * @return the nbAction
     */
    public int getNbAction() {
        return nbAction;
    }
    
    /**
     * @return the pouvoir
     */
    public Boolean getPouvoir() {
        return pouvoir;
    }

    /**
     * @param pouvoir the pouvoir to set
     */
    public void setPouvoir(Boolean pouvoir) {
        this.pouvoir = pouvoir;
    }

    /**
     * @return the Role
     */
    public Role getRole() {
        return Role;
    }

    /**
     * @return the nomJoueur
     */
    public String getNomJoueur() {
        return nomJoueur;
    }

    /**
     * @param nomJoueur the nomJoueur to set
     */
    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    /**
     * @param Role the Role to set
     */
    public void setRole(Role Role) {
        this.Role = Role;
    }

    /**
     * @return the pion
     */
    public Pion getPion() {
        return pion;
    }

    /**
     * @param pion the pion to set
     */
    public void setPion(Pion pion) {
        this.pion = pion;
    }
}
