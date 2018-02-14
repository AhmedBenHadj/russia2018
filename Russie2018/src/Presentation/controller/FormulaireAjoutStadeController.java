/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controller;

import Entite.Stade;
import Service.ServiceStade;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


/**
 * FXML Controller class
 *
 * @author hseli
 */
public class FormulaireAjoutStadeController implements Initializable {

    @FXML
    private JFXTextField id_nom;
    @FXML
    private JFXTextField id_adresse;
    @FXML
    private JFXTextField id_capacite;
    @FXML
    private JFXTextField id_image;
    @FXML
    private JFXButton id_ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id_ajouter.setOnAction(this::ajouter);
    }    
    public void ajouter(ActionEvent event){
        ServiceStade SS=new ServiceStade();
        Stade S=new Stade();
        S.setNom(id_nom.getText());
        S.setAdresse(id_adresse.getText());
        S.setCapacite(Integer.parseInt(id_capacite.getText()));
        S.setImage(id_image.getText());
        SS.ajouter_Stade(S);
    }
    
}
