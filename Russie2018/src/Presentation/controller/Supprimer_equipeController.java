/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controller;

import Entite.Equipe;
import Service.ServiceEquipe;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.lang.reflect.InvocationTargetException;
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
public class Supprimer_equipeController implements Initializable {

    @FXML
    private JFXComboBox<String> combo_nom;
    @FXML
    private JFXComboBox<Integer> combo_id;

    private Equipe equipe ;
    @FXML
    private JFXButton supprimer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo_id.setItems(null);
        combo_id.setItems(this.get_obs_id());
        combo_nom.setItems(null);
        combo_nom.setItems(this.get_obs_nom());
        supprimer.setOnAction(this::supprimer);
    }    

    @FXML
    private void affiche_1(ActionEvent event) {
        try{
        this.equipe = new ServiceEquipe().get_by_name((String) combo_nom.getValue());
        combo_id.setValue(equipe.getId());
        }catch(RuntimeException e){
            
        }
    }

    @FXML
    private void affiche_2(ActionEvent event) {
        try{
        this.equipe = new ServiceEquipe().get(combo_id.getValue());
        combo_nom.setValue(equipe.getNom());
        }catch(RuntimeException e){
            
        }
    }
    
    private ObservableList<Integer> get_obs_id(){
        ObservableList<Integer> data = FXCollections.observableArrayList();
        for(Equipe e : new ServiceEquipe().getALL()){
            data.add(e.getId());
        }
        return data ;
    }
    private ObservableList<String> get_obs_nom(){
        ObservableList<String> data = FXCollections.observableArrayList();
        for(Equipe e : new ServiceEquipe().getALL()){
            data.add(e.getNom());
        }
        return data ;
    }

    @FXML
    private void supprimer(ActionEvent event) {
        new ServiceEquipe().supprimer(equipe);
        combo_id.setItems(null);
        combo_id.setItems(this.get_obs_id());
        combo_nom.setItems(null);
        combo_nom.setItems(this.get_obs_nom());
    }
    
}
