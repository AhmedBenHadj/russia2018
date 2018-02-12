/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Joueur;
import Service.ServiceJoueur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author eloss
 */
public class Supprimer_joueurController implements Initializable {

    @FXML
    private JFXComboBox<Integer> id;
    @FXML
    private JFXComboBox<String> nom;
    @FXML
    private JFXButton supprimer;

    private Joueur joueur ;
    @FXML
    private Label succee;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setItems(null);
        id.setItems(this.get_obs_id());
        nom.setItems(null);
        nom.setItems(this.get_obs_nom());
        nom.setOnAction(this::afficher_2);
        id.setOnAction(this::afficher_1);
        supprimer.setOnAction(this::supprimer);
        
    }    

    @FXML
    private void afficher_2(ActionEvent event) {
        try{
        joueur = new ServiceJoueur().get((String) nom.getValue());
        id.setValue(joueur.getId());
        supprimer.setVisible(true);
        succee.setVisible(false);
        }catch(NullPointerException e){
            System.out.println(e);               
        }
    }

    @FXML
    private void afficher_1(ActionEvent event) {
        try{
        joueur = new ServiceJoueur().get((Integer) id.getValue());
        nom.setValue(joueur.getNom());
        supprimer.setVisible(true);
        succee.setVisible(false);
        }catch(NullPointerException e){
            System.out.println(e);
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        new ServiceJoueur().supprimer(joueur);
        succee.setVisible(true);
        id.setItems(null);
        id.setItems(this.get_obs_id());
        nom.setItems(null);
        nom.setItems(this.get_obs_nom());
    }
    
    private ObservableList<Integer> get_obs_id(){
        ObservableList<Integer> data = FXCollections.observableArrayList();
        ServiceJoueur S = new ServiceJoueur();
        for(Joueur J : S.getALL()){
            data.add(J.getId());
        }
        return data ;
    }
    private ObservableList<String> get_obs_nom(){
        ObservableList<String> data = FXCollections.observableArrayList();
        ServiceJoueur S = new ServiceJoueur();
        for(Joueur J : S.getALL()){
            data.add(J.getNom());
        }
        return data ;
    }
    
}
