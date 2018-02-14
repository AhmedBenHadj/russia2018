/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controller;

import Entite.Entraineur;
import Entite.Equipe;
import Service.ServiceEntraineur;
import Service.ServiceEquipe;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author eloss
 */
public class Conteneur_liste_entraineurController implements Initializable {

    @FXML
    private VBox v_box;
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

    @FXML
    private void afficher(KeyEvent event) {
        List<Entraineur> liste_entraineur = new ArrayList<>();
        
        ServiceEntraineur S = new ServiceEntraineur() ;
        if(recherche.getText().isEmpty())
            liste_entraineur = S.getALL();
        else
            liste_entraineur = new ServiceEntraineur().D_chercher(recherche.getText());
        v_box.setPrefHeight(200*liste_entraineur.size());
        v_box.getChildren().clear();
        for(Entraineur E : liste_entraineur){
            AnchorPane case_joueur = (AnchorPane) loadFXML("/Presentation/view/Case_entraineur.fxml", E);
            v_box.getChildren().add(case_joueur);
        }
    }
    
    public Object loadFXML(String s, Entraineur E) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(s));
        try {
            loader.load();
            Case_entraineurController ac = (Case_entraineurController) loader.getController();
            ac.setEntraineur(E);
            return loader.getRoot();
        } catch (IOException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void afficher_not_on_key(){
        List<Entraineur> liste_entraineur = new ArrayList<>();
        
        ServiceEntraineur S = new ServiceEntraineur() ;
        if(recherche.getText().isEmpty())
            liste_entraineur = S.getALL();
        v_box.setPrefHeight(200*liste_entraineur.size());
        v_box.getChildren().clear();
        for(Entraineur E : liste_entraineur){
            AnchorPane case_joueur = (AnchorPane) loadFXML("/Presentation/view/Case_entraineur.fxml", E);
            v_box.getChildren().add(case_joueur);
        }
    }
    
}
