/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controller;

import Entite.Equipe;
import Entite.Joueur;
import Service.ServiceEquipe;
import Service.ServiceJoueur;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author eloss
 */
public class Conteneur_liste_equipeController implements Initializable {

    @FXML
    private JFXTextField recherche;
    @FXML
    private VBox v_box;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher_not_on_key();
        recherche.setOnKeyReleased(this::afficher);
    }    

    
    public Object loadFXML(String s, Equipe p) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(s));
        try {
            loader.load();
            Case_equipeController ac = (Case_equipeController) loader.getController();
            ac.setEquipe(p);
            return loader.getRoot();
        } catch (IOException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void afficher_not_on_key(){
        List<Equipe> liste_equipe = new ArrayList<>();
        
        ServiceEquipe S = new ServiceEquipe() ;
        if(recherche.getText().isEmpty())
            liste_equipe = S.getALL();
        v_box.setPrefHeight(200*liste_equipe.size());
        v_box.getChildren().clear();
        for(Equipe E : liste_equipe){
            AnchorPane case_joueur = (AnchorPane) loadFXML("/Presentation/view/Case_equipe.fxml", E);
            v_box.getChildren().add(case_joueur);
        }
    }

    @FXML
    private void afficher(KeyEvent event) {
        List<Equipe> liste_equipe = new ArrayList<>();
        
        ServiceEquipe S = new ServiceEquipe() ;
        if(recherche.getText().isEmpty())
            liste_equipe = S.getALL();
        else
            liste_equipe = new ServiceEquipe().D_chercher(recherche.getText());
        v_box.setPrefHeight(200*liste_equipe.size());
        v_box.getChildren().clear();
        for(Equipe E : liste_equipe){
            AnchorPane case_joueur = (AnchorPane) loadFXML("/Presentation/view/Case_equipe.fxml", E);
            v_box.getChildren().add(case_joueur);
        }
    }
}
