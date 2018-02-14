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
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author eloss
 */
public class Formulaire_modifier_joueurController implements Initializable {

    @FXML
    private JFXComboBox<Integer> id;
    @FXML
    private JFXButton modifier;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField age;
    @FXML
    private JFXTextField club;
    @FXML
    private JFXComboBox<String> poste;
    @FXML
    private VBox labels_box;
    @FXML
    private VBox text_box;

    private Joueur joueur ;
    @FXML
    private Label succee;
    @FXML
    private JFXComboBox<String> combo_nom;
    @FXML
    private Label titre;
    @FXML
    private JFXButton image;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setItems(null);
        id.setItems(this.get_obs_id());
        combo_nom.setItems(null);
        combo_nom.setItems(this.get_obs_nom());
        poste.setItems(null);
        poste.setItems(this.get_obs_poste());
        id.setOnAction(this::afficher);
        combo_nom.setOnAction(this::afficher_1);
        modifier.setOnAction(this::modifier);
    }    

    @FXML
    private void modifier(ActionEvent event) {
        joueur.setAge(Integer.parseInt(age.getText()));
        joueur.setClub(club.getText());
        joueur.setNom(nom.getText());
        joueur.setPrenom(prenom.getText());
        joueur.setPoste(poste.getValue());
        new ServiceJoueur().modifier(joueur.getId(), joueur.getEquipe(), joueur.getNom(), joueur.getPrenom(), joueur.getAge(), joueur.getPoste(), joueur.getNumero(), joueur.getClub(),image.getText());
        succee.setVisible(true);
        try{
            id.setItems(null);
            id.setItems(this.get_obs_id());
            combo_nom.setItems(null);
            combo_nom.setItems(this.get_obs_nom());
        }catch(NullPointerException e){
            
        }
    }

    @FXML
    private void afficher(ActionEvent event) {
        try{
        labels_box.setVisible(true);
        text_box.setVisible(true);
        ServiceJoueur S = new ServiceJoueur();
        joueur = S.get((Integer) this.id.getValue());
        combo_nom.setValue(joueur.getNom());
        nom.setText(joueur.getNom());
        prenom.setText(joueur.getPrenom());
        club.setText(joueur.getClub());
        age.setText(Integer.toString(joueur.getAge()));
        poste.setValue(joueur.getPoste());
        modifier.setVisible(true);
        succee.setVisible(false);
        }catch(NullPointerException e){
            
        }
    }
    private void afficher_1(ActionEvent event){
        try{
        labels_box.setVisible(true);
        text_box.setVisible(true);
        ServiceJoueur S = new ServiceJoueur();
        joueur = S.get(combo_nom.getValue());
        id.setValue((Integer) joueur.getId());
        nom.setText(joueur.getNom());
        prenom.setText(joueur.getPrenom());
        club.setText(joueur.getClub());
        age.setText(Integer.toString(joueur.getAge()));
        poste.setValue(joueur.getPoste());
        modifier.setVisible(true);
        succee.setVisible(false);
        } catch(NullPointerException e){
            
        }
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
