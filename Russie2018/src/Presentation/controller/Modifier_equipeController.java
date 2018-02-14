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
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author eloss
 */
public class Modifier_equipeController implements Initializable {

    @FXML
    private JFXComboBox<String> combo_nom;
    @FXML
    private JFXComboBox<Integer> combo_id;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXComboBox<String> entraineur;
    @FXML
    private JFXButton drapeau;
    @FXML
    private JFXButton maillot;
    @FXML
    private JFXComboBox<String> progress;
    @FXML
    private JFXTextField points;
    @FXML
    private JFXComboBox<String> groupe;
    @FXML
    private JFXButton modifier;
    @FXML
    private Label titre;
    @FXML
    private VBox v_box_1;
    @FXML
    private VBox v_box_2;

    private Equipe equipe ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo_id.setItems(null);
        combo_id.setItems(this.get_obs_id());
        combo_nom.setItems(null);
        combo_nom.setItems(this.get_obs_nom());
        groupe.setItems(null);
        groupe.setItems(this.get_obs_groupe());
        progress.setItems(null);
        progress.setItems(this.get_obs_progress());
        entraineur.setItems(null);
        entraineur.setItems(this.get_obs_entraineur());
        modifier.setOnAction(this::modifier);
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

    @FXML
    private void modifier(ActionEvent event) {
        if(entraineur.getValue().equals("")){
            new ServiceEquipe().modifier(equipe.getId(),equipe.getEntraineur(), equipe.getNom(),drapeau.getText(), maillot.getText(), Equipe.Progress.valueOf(progress.getValue()),Integer.parseInt(points.getText()));
        }
        else
            new ServiceEquipe().modifier(equipe.getId(),new ServiceEntraineur().get(entraineur.getValue()), equipe.getNom(),drapeau.getText(), maillot.getText(), Equipe.Progress.valueOf(progress.getValue()),Integer.parseInt(points.getText()));
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
    private ObservableList<String> get_obs_progress(){
        ObservableList<String> data = FXCollections.observableArrayList();
        for(Equipe.Progress p : Equipe.Progress.values()){
            data.add(p.toString());
        }
        return data ;
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
    private void afficher_1(ActionEvent event) {
        try{
            equipe = new ServiceEquipe().get_by_name((String)combo_nom.getValue());
            combo_id.setValue(equipe.getId());
            this.nom.setText(equipe.getNom());
            this.drapeau.setText(equipe.getDrapeau());
            this.maillot.setText(equipe.getMaillot());
            this.entraineur.setValue(equipe.getEntraineur().getNom());
            this.groupe.setValue(equipe.getGroupe().getNom());
            this.points.setText(Integer.toString(equipe.getPts()));
            this.progress.setValue(equipe.getProgress().toString());
            v_box_1.setVisible(true);
            v_box_2.setVisible(true);
            modifier.setVisible(true);
        }catch(NullPointerException e){
            System.out.println(e);
        }
    }

    @FXML
    private void afficher_2(ActionEvent event) {
        try{
            equipe = new ServiceEquipe().get(combo_id.getValue());
            combo_nom.setValue(equipe.getNom());
            this.nom.setText(equipe.getNom());
            this.drapeau.setText(equipe.getDrapeau());
            this.maillot.setText(equipe.getMaillot());
            this.entraineur.setValue(equipe.getEntraineur().getNom());
            this.groupe.setValue(equipe.getGroupe().getNom());
            this.points.setText(Integer.toString(equipe.getPts()));
            this.progress.setValue(equipe.getProgress().toString());
            v_box_1.setVisible(true);
            v_box_2.setVisible(true);
            modifier.setVisible(true);
        }catch(NullPointerException e){
            System.out.println(e);
        }
    }
    
}
