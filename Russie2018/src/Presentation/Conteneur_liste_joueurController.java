/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Joueur;
import Service.ServiceJoueur;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author eloss
 */
public class Conteneur_liste_joueurController implements Initializable {

    @FXML
    private ScrollPane scrollpane;
    @FXML
    private VBox vbox;
    @FXML
    private JFXTextField recherche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher_not_on_key();
        recherche.setOnKeyReleased(this::afficher);
    }    
    public Object loadFXML(String s, Joueur p) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(s));
        try {
            loader.load();
            Case_joueur_1Controller ac = (Case_joueur_1Controller) loader.getController();
            ac.setJoueur(p);
            return loader.getRoot();
        } catch (IOException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @FXML
    private void afficher(KeyEvent event) {
        List<Joueur> liste_joueur = new ArrayList<>();
        
        ServiceJoueur S = new ServiceJoueur() ;
        if(recherche.getText().isEmpty())
            liste_joueur = S.getALL();
        else
            liste_joueur = new ServiceJoueur().D_chercher(recherche.getText());
        vbox.setPrefHeight(200*liste_joueur.size());
        vbox.getChildren().clear();
        for(Joueur J : liste_joueur){
            AnchorPane case_joueur = (AnchorPane) loadFXML("Case_joueur_1.fxml", J);
            vbox.getChildren().add(case_joueur);
        }
    }
    public void afficher_not_on_key(){
        List<Joueur> liste_joueur = new ArrayList<>();
        
        ServiceJoueur S = new ServiceJoueur() ;
        if(recherche.getText().isEmpty())
            liste_joueur = S.getALL();
        vbox.setPrefHeight(200*liste_joueur.size());
        vbox.getChildren().clear();
        for(Joueur J : liste_joueur){
            AnchorPane case_joueur = (AnchorPane) loadFXML("case_joueur_1.fxml", J);
            vbox.getChildren().add(case_joueur);
        }
    }
}
