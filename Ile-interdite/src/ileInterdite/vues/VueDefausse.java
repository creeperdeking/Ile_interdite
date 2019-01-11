/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileInterdite.vues;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class VueDefausse extends Observable{
    private JFrame fenetre;
    private ArrayList<JButton> buttonCartes;
    private JPanel panelCarte;
    private JPanel panelPrincipal;

    public VueDefausse(){

        
        fenetre=new JFrame();
        fenetre.setTitle("cartes");
        
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        fenetre.setSize(600, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        fenetre.setLocation(dim.width/2-fenetre.getSize().width/2, dim.height/2-fenetre.getSize().height/2);
        fenetre.setResizable(true);
        
        
        panelPrincipal=new JPanel(new BorderLayout());
        JLabel explication=new JLabel("on met les explications ici");
        
        

        
        panelCarte=new JPanel(new GridLayout(1,1)); 
        
        panelPrincipal.add(explication,BorderLayout.NORTH);
        panelPrincipal.add(panelCarte,BorderLayout.CENTER);
        
        
        actualiser(new ArrayList<>());
        
        
        
        close();
        fenetre.add(panelPrincipal);
    }
    
      public void actualiser(ArrayList<String> listeCartes){ 
        panelPrincipal.remove(panelCarte);
          
        buttonCartes=new ArrayList<>();
        
        panelCarte=new JPanel(new GridLayout(1,listeCartes.size()));
        for(String c: listeCartes){
            JButton buttonCarte=new JButton();
            buttonCarte.setText(c);
            buttonCarte.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    setChanged();
                    notifyObservers(new Message());
                    clearChanged();
                }
            });
            buttonCartes.add(buttonCarte);
            panelCarte.add(buttonCarte);
        }
        panelPrincipal.add(panelCarte,BorderLayout.CENTER);
        afficher();
      }
    
      public void afficher(){
        this.fenetre.setVisible(true);
    }
      
      public void close(){
        this.fenetre.dispose();
    }

}
