/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileInterdite.vues;

import utilitaires.Role;
import ileInterdite.message.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import utilitaires.Action;

/**
 *
 * @author vinetg
 */
public class VuePrincipale extends Observable {

    public enum Bouton {
        DONNER, RECUPERER, ASSECHER, DEPLACER, TERMINER_TOUR;
    };

    private JFrame window;

    private JPanel panelPlateau = new JPanel(new BorderLayout());

    private HashMap<Role, VueAventurier> panelAventuriers;
    private JPanel panelPrincipal = new JPanel(new BorderLayout());

    private JButton btnBouger;
    private JButton btnAssecher;
    private JButton btnDonner;
    private JButton btnRecuperer;
    private JButton btnTerminerTour = new JButton("Terminer le Tour");
    private JLabel labelNbPA = new JLabel();
    private JLabel labelNomJoueur = new JLabel("", SwingConstants.CENTER);
    private JPanel panelBoutons;
    private JPanel paneNiveau;
    private JPanel paneBas;
    private JPanel paneCursor=new JPanel(new GridLayout(1,7));
    
    private int width = 1500;
    private int height = 1000;

    private String path = "src/images/";

    private ImageIcon imgNiveau = new ImageIcon(new ImageIcon(path + "NiveauRotated-ConvertImage.png").getImage().getScaledInstance(300, 130, Image.SCALE_SMOOTH));

    /**
     * On définit un constructeur de VueAventurier avec une VueGrille v
     *
     * @param v
     * @param vuesAventuriers
     */
    public VuePrincipale(VueGrille v, HashMap<Role, VueAventurier> vuesAventuriers) {
        btnRecuperer = new JButton(new ImageIcon(path+"icones/iconGet.png"));
        btnRecuperer.setText("Récupérer un trésor");
        btnDonner = new JButton(new ImageIcon(path+"icones/iconGive.png"));
        btnDonner.setText("Donner une carte trésor");
        btnAssecher = new JButton(new ImageIcon(path+"icones/iconDry.png"));
        btnAssecher.setText("Assécher une case");
        btnBouger = new JButton(new ImageIcon(path+"icones/iconMove.png"));
        btnBouger.setText("Se déplacer sur une case");
        
        window = new JFrame();
        window.setSize(width, height);
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setTitle("Ile interdite");
        window.add(panelPrincipal);
        window.setResizable(true);
        
        
        labelNbPA.setFont(new Font("Arial", Font.BOLD, 25));
        btnTerminerTour.setFont(new Font("Arial", Font.BOLD, 25));

        JPanel panelCentre = new JPanel(new BorderLayout());
       
        JPanel panelGrille = new JPanel();
        panelGrille.add(v.getPanelGrille());
        
        
        panelPlateau.add(panelGrille, BorderLayout.CENTER);
        labelNomJoueur.setForeground(Color.WHITE);

        JPanel paneGauche = new JPanel(new BorderLayout());

        JPanel paneDroite = new JPanel(new BorderLayout());

 
        panelPrincipal.add(panelCentre, BorderLayout.CENTER);

        panelCentre.add(panelPlateau, BorderLayout.CENTER);
        //=====================================================================
        paneBas=new JPanel(new BorderLayout());
        
        
        panelBoutons = new JPanel(new GridLayout(2, 2));
        panelBoutons.add(btnBouger);
        panelBoutons.add(btnDonner);
        panelBoutons.add(btnAssecher);
        panelBoutons.add(btnRecuperer);
        
        
        paneNiveau=new JPanel(new BorderLayout());
        JLabel labImage=new JLabel(imgNiveau);
        paneNiveau.add(labImage,BorderLayout.CENTER);
        paneNiveau.add(paneCursor,BorderLayout.NORTH);
        
    
        panelPlateau.add(paneBas, BorderLayout.SOUTH);
        
        paneBas.add(panelBoutons,BorderLayout.EAST);
        paneBas.add(paneNiveau,BorderLayout.CENTER);

        btnBouger.setVisible(true);
        btnBouger.addActionListener((ActionEvent e) -> {
            setChanged();
            notifyObservers(new Message(Action.DEPLACER, null));
            clearChanged();
        });

        btnAssecher.setVisible(true);
        btnAssecher.addActionListener((ActionEvent e) -> {
            setChanged();
            notifyObservers(new Message(Action.ASSECHER, null));
            clearChanged();
        });

        btnTerminerTour.addActionListener((ActionEvent e) -> {
            setChanged();
            notifyObservers(new Message(Action.TERMINER, null));
            clearChanged();
        });
        

        btnDonner.setVisible(true);
        btnDonner.addActionListener((ActionEvent arg0) -> {
            setChanged();
            notifyObservers(new Message(Action.DONNER, null));
            clearChanged();
        });

        btnRecuperer.setVisible(true);
        btnRecuperer.addActionListener((ActionEvent arg) -> {
            setChanged();
            notifyObservers(new Message(Action.RECUPERER_TRESOR, null));
            clearChanged();
        });

        //===================pour chaque aventurier different=================
        panelAventuriers = vuesAventuriers;
        
        JPanel paneSuperGauche=new JPanel(new BorderLayout());
        JPanel paneSuperDroite=new JPanel(new BorderLayout());

        ArrayList<VueAventurier> listeVuesAv = new ArrayList(vuesAventuriers.values());
        paneGauche.add(listeVuesAv.get(0).getPanelGeneral(),BorderLayout.NORTH);
        paneSuperGauche.add(labelNbPA,BorderLayout.SOUTH);
        paneGauche.add(listeVuesAv.get(3).getPanelGeneral(),BorderLayout.SOUTH);
        paneGauche.setPreferredSize(new Dimension(330,200));
        paneSuperGauche.add(paneGauche,BorderLayout.CENTER);
        
        paneDroite.add(listeVuesAv.get(1).getPanelGeneral(),BorderLayout.NORTH);
        paneSuperDroite.add(btnTerminerTour,BorderLayout.SOUTH);
        paneDroite.add(listeVuesAv.get(2).getPanelGeneral(),BorderLayout.SOUTH);
        paneDroite.setPreferredSize(new Dimension(330, 200));
        paneSuperDroite.add(paneDroite,BorderLayout.CENTER);
        
        
        
        panelPrincipal.add(paneSuperGauche, BorderLayout.WEST);
        panelPrincipal.add(paneSuperDroite, BorderLayout.EAST);
    }

    public void actualiserVue(String nomJoueur, Role classe, Color couleur, int nombrePA) {

        getPanelPrincipal().setBorder(BorderFactory.createLineBorder(couleur, 2));

        getPanelAventuriers().get(classe).getPanelGeneral().setBackground(couleur);
        getLabelNomJoueur().setText(classe + " ( " + nomJoueur + " ) ");

        panelPlateau.setBorder(new MatteBorder(0,0,2,0,couleur));

        getLabelNbPA().setText("Nombre d'actions restantes : " + nombrePA);

        
        panelAventuriers.get(classe).getPanelGeneral().setBorder(BorderFactory.createLineBorder(Color.MAGENTA,10));
        
        
        
        getWindow().setVisible(true);
    }

    public void activerBouton(Bouton bouton, Boolean b) {
        switch (bouton) {
            case DEPLACER:
                btnBouger.setEnabled(b);
                break;
            case ASSECHER:
                btnAssecher.setEnabled(b);
                break;
            case DONNER:
                btnDonner.setEnabled(b);
                break;
            case RECUPERER:
                btnRecuperer.setEnabled(b);
                break;
            case TERMINER_TOUR:
                btnTerminerTour.setEnabled(b);
        }
    }

    //Getters et Setters :
    /**
     * Ferme la fenêtre
     */
    public void close() {
        getWindow().dispose();
    }

    /**
     * @return the window
     */
    public JFrame getWindow() {
        return window;
    }

    /**
     * @return the panelAventuriers
     */
    public HashMap<Role, VueAventurier> getPanelAventuriers() {
        return panelAventuriers;
    }

    /**
     * @return the panelPrincipal
     */
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    /**
     * @return the btnBouger
     */
    public JButton getBtnBouger() {
        return btnBouger;
    }

    /**
     * @return the btnAssecher
     */
    public JButton getBtnAssecher() {
        return btnAssecher;
    }

    /**
     * @return the btnDonner
     */
    public JButton getBtnDonner() {
        return btnDonner;
    }

    /**
     * @return the btnRecuper
     */
    public JButton getBtnRecuperer() {
        return btnRecuperer;
    }

    /**
     * @return the labelNbPA
     */
    public JLabel getLabelNbPA() {
        return labelNbPA;
    }

    /**
     * @return the labelNomJoueur
     */
    public JLabel getLabelNomJoueur() {
        return labelNomJoueur;
    }

}
