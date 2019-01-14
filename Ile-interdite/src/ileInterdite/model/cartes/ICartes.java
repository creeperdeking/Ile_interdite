/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileInterdite.model.cartes;

import ileInterdite.message.MessageCarte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JButton;
import utilitaires.Action;
import utilitaires.Role;

/**
 *
 * @author vinetg
 */
public class ICartes extends Observable {
    
    private JButton boutonCarte;
    private ActionListener actions;
    private Role role; 
    
    public ICartes(JButton boutonCarte,ActionListener actions,Role role){
        this.actions=actions;
        this.boutonCarte=boutonCarte;
        this.role=role;
    }
    
    
    public void rendreCarteCliquable(){
        //Couleur a implémenter

        setActions(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
               setChanged();
               notifyObservers(new MessageCarte(boutonCarte.getText(),Action.DONNER,getRole()));
               clearChanged();
               System.out.println("3");
           }
       });
        
        
        //rendre les joueurs cliquables
    }
    
    

    /**
     * @return the boutonCarte
     */
    public JButton getBoutonCarte() {
        return boutonCarte;
    }

    /**
     * @return the actions
     */
    public ActionListener getActions() {
        return actions;
    }

    /**
     * @param actions the actions to set
     */
    public void setActions(ActionListener actions) {
        this.actions = actions;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }
    
}
