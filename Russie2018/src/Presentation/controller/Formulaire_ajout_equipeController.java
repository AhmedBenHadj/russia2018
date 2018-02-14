/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controller;

import Entite.Entraineur;
import Entite.Equipe;
import Entite.Groupe;
import Service.ServiceEntraineur;
import Service.ServiceEquipe;
import Service.ServiceGroupe;
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
public class Formulaire_ajout_equipeController implements Initializable {

    @FXML
    private JFXButton ajouter;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXComboBox<String> groupe;
    @FXML
    private JFXButton drapeau;
    @FXML
    private JFXButton maillot;
    @FXML
    private Label titre;
    @FXML
    private JFXComboBox<String> entraineur;
    @FXML
    private Label succee;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        drapeau.setOnAction(this::upload_1);
        maillot.setOnAction(this::upload_2);
        groupe.setItems(null);
        groupe.setItems(this.get_obs_groupe());
        entraineur.setItems(null);
        entraineur.setItems(this.get_obs_entraineur());
        ajouter.setOnAction(this::ajouter);
    }    
    

    @FXML
    private void ajouter(ActionEvent event) {
        Equipe E = new Equipe() ;
        E.setEntraineur(new ServiceEntraineur().get((String)entraineur.getValue()));
        E.setMaillot(maillot.getText());
        E.setDrapeau(drapeau.getText());
        E.setGroupe(new ServiceGroupe().get(groupe.getValue()));
        E.setNom(nom.getText());
        new ServiceEquipe().ajouter(E);
        groupe.setItems(null);
        groupe.setItems(this.get_obs_groupe());
        entraineur.setItems(null);
        entraineur.setItems(this.get_obs_entraineur());
        succee.setVisible(true);
    }

    @FXML
    private void upload_1(ActionEvent event) {
        FileChooser F = new FileChooser();
        F.setTitle("image drapeaue");
        F.getExtensionFilters().addAll();
        File f = F.showOpenDialog(titre.getScene().getWindow());
        if(f != null){
            drapeau.setText(f.toString());
        }
    }

    @FXML
    private void upload_2(ActionEvent event) {
        FileChooser F = new FileChooser();
        F.setTitle("image maillot");
        F.getExtensionFilters().addAll();
        File f = F.showOpenDialog(titre.getScene().getWindow());
        if(f != null){
            maillot.setText(f.toString());
        }
    }
    private ObservableList<String> get_obs_entraineur(){
        boolean aux=false ;
        ObservableList<String> data = FXCollections.observableArrayList();
        ServiceEntraineur S1 = new ServiceEntraineur();
        ServiceEquipe S2 = new ServiceEquipe();
        List<Entraineur> LE = S1.getALL();
        for (Entraineur entraineur : LE) {
            aux=false ;
            for(Equipe equipe : S2.getALL()){
                if(equipe.getEntraineur().equals(entraineur))
                    aux=true ;
            }
            if(!aux)
                data.add(entraineur.getNom());
        }
        return data ;
    }
    private ObservableList<String> get_obs_groupe(){
        ObservableList<String> data = FXCollections.observableArrayList();
        ServiceGroupe S1 = new ServiceGroupe();
        ServiceEquipe S2 = new ServiceEquipe();
        List<Groupe> LG = S1.get_Groupe();
        for (Groupe groupe : LG) {
            if(S2.get_by_group(groupe.getNom()).size()<4)
                data.add(groupe.getNom());
        }
        return data ;
    }
}
