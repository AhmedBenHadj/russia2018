/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Entraineur;
import Service.ServiceEntraineur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author eloss
 */
public class Formulaire_modifier_entraineurController implements Initializable {

    @FXML
    private JFXComboBox<String> nom;
    @FXML
    private JFXComboBox<Integer> id;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextArea description;
    private Entraineur entraineur ;
    @FXML
    private VBox v_box;
    @FXML
    private JFXTextField nom_field;
    @FXML
    private JFXButton modifier;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setItems(null);
        id.setItems(this.get_obs_id());
        nom.setItems(null);
        nom.setItems(this.get_obs_nom());
        modifier.setOnAction(this::modifier);
    }    

    @FXML
    private void afficher_1(ActionEvent event) {
       entraineur = new ServiceEntraineur().get((String)nom.getValue());
       id.setValue(entraineur.getId());
       nom_field.setText(entraineur.getNom());
       prenom.setText(entraineur.getPrenom());
       description.setText(entraineur.getDescription());
       v_box.setVisible(true);
       modifier.setVisible(true);
       nom_field.setVisible(true);
       prenom.setVisible(true);
       description.setVisible(true);
    }

    @FXML
    private void afficher_2(ActionEvent event) {
       entraineur = new ServiceEntraineur().get(id.getValue());
       nom.setValue(entraineur.getNom());
       nom_field.setText(entraineur.getNom());
       prenom.setText(entraineur.getPrenom());
       description.setText(entraineur.getDescription());
       v_box.setVisible(true);
       modifier.setVisible(true);
       nom_field.setVisible(true);
       prenom.setVisible(true);
       description.setVisible(true);
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
    private void modifier(ActionEvent event) {
        new ServiceEntraineur().modifier(entraineur.getId(), nom_field.getText(), prenom.getText(), description.getText());
    }
    
}
