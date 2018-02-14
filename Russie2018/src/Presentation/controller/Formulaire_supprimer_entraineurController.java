/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controller;

import Entite.Entraineur;
import Entite.Equipe;
import Service.ServiceEntraineur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author eloss
 */
public class Formulaire_supprimer_entraineurController implements Initializable {

    @FXML
    private JFXComboBox<String> nom;
    @FXML
    private JFXComboBox<Integer> id;
    @FXML
    private JFXButton supprimer;
    private Entraineur entraineur ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setItems(null);
        id.setItems(this.get_obs_id());
        nom.setItems(null);
        nom.setItems(this.get_obs_nom());
        supprimer.setOnAction(this::supprimer);
    }    

    @FXML
    private void supprimer(ActionEvent event) {
        new ServiceEntraineur().supprimer(entraineur);
    }
    private ObservableList<String> get_obs_nom(){
        ObservableList<String> data = FXCollections.observableArrayList();
        for(Entraineur E : new ServiceEntraineur().getALL()){
            data.add(E.getNom());
        }
        return data ;
    }
    
    private ObservableList<Integer> get_obs_id(){
        ObservableList<Integer> data = FXCollections.observableArrayList();
        for(Entraineur E : new ServiceEntraineur().getALL()){
            data.add(E.getId());
        }
        return data ;
    }

    @FXML
    private void afficher_1(ActionEvent event) {
       entraineur = new ServiceEntraineur().get((String)nom.getValue());
       id.setValue(entraineur.getId());
    }

    @FXML
    private void afficher_2(ActionEvent event) {
       entraineur = new ServiceEntraineur().get(id.getValue());
       nom.setValue(entraineur.getNom());
    }
}
