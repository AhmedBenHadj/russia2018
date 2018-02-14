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
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author eloss
 */
public class Formulaire_ajout_joueurController implements Initializable {

    @FXML
    private JFXComboBox<String> nom_equipe;
    @FXML
    private JFXComboBox<String> nom_poste;
    @FXML
    private JFXTextField joueur_nom;
    @FXML
    private JFXTextField prenom_joueur;
    @FXML
    private JFXTextField age_joueur;
    @FXML
    private JFXTextField club_joueur;
    @FXML
    private JFXTextField numero_joueur;
    @FXML
    private JFXButton Ajouter;
    @FXML
    private Label titre;
    @FXML
    private JFXButton image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nom_equipe.setItems(null);
        nom_equipe.setItems(this.get_obs_equipes());
        nom_poste.setItems(null);
        nom_poste.setItems(this.get_obs_poste());
        Ajouter.setOnAction(this::ajouter);
    }

    private ObservableList<String> get_obs_equipes(){
        ObservableList<String> data = FXCollections.observableArrayList();
        ServiceEquipe S1 = new ServiceEquipe();
        
        List<Equipe> LE = S1.getALL();
        for (Equipe equipe : LE) {
            data.add(equipe.getNom());
        }
        return data ;
    }
    private ObservableList<String> get_obs_poste(){
        ObservableList<String> data = FXCollections.observableArrayList();
        data.add("AC");
        data.add("Dg");
        data.add("R10");
        data.add("Dd");
        data.add("P");
        data.add("AG");
        data.add("A");
        data.add("G");
        data.add("AD");
        return data ;
    }

    @FXML
    private void ajouter(ActionEvent event) {
        Joueur J = new Joueur();
        J.setNom(joueur_nom.getText());
        J.setPrenom(prenom_joueur.getText());
        J.setAge(Integer.parseInt(age_joueur.getText()));
        J.setNumero(Integer.parseInt(numero_joueur.getText()));
        J.setClub(club_joueur.getText());
        J.setPoste((String)nom_poste.getValue());
        Equipe E= new Equipe();
        E = new ServiceEquipe().get_by_name((String)nom_equipe.getValue());
        J.setEquipe(E);
        J.setImage(image.getText());
        new ServiceJoueur().ajouter(J);
        System.out.println("Ajout joueur OK");
    }

    @FXML
    private void upload(ActionEvent event) {
        FileChooser F = new FileChooser();
        F.setTitle("image joueur");
        F.getExtensionFilters().addAll();
        File f = F.showOpenDialog(titre.getScene().getWindow());
        if(f != null){
            image.setText(f.toString());
        }
    }
    
}
