/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Entraineur;
import Service.ServiceEntraineur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author eloss
 */
public class Formulaire_ajout_entraineurController implements Initializable {

    @FXML
    private JFXButton ajouter;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextArea description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ajouter.setOnAction(this::ajouter);
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        Entraineur E = new Entraineur();
        E.setNom(nom.getText());
        E.setPrenom(prenom.getText());
        E.setDescription(description.getText());
        new ServiceEntraineur().ajouter(E);
    }
    
}
