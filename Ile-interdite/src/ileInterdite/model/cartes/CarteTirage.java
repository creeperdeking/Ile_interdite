/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileInterdite.model.cartes;

/**
 *
 * @author vinetg
 */
public class CarteTirage {

    private String nom;
    private Boolean utilisable;

    protected CarteTirage(Boolean utilisable) {
        this.utilisable = utilisable;
    }

    
    //Getters et Setter :
    
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    protected void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the utilisable
     */
    public Boolean getUtilisable() {
        return utilisable;
    }
}
