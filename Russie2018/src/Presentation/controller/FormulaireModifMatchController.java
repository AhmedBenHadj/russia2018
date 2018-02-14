/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controller;
import Entite.Match;
import Service.ServiceEquipe;
import Service.ServiceMatch;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author hseli
 */
public class FormulaireModifMatchController implements Initializable {

   /* @FXML
    private JFXComboBox<Integer> id_match;*/
    @FXML
    private JFXDatePicker id_date;
    @FXML
    private JFXTimePicker id_time;
    @FXML
    private JFXComboBox<Enum> id_etat1;
    @FXML
    private JFXButton id_modifier;
    @FXML
    private VBox hbox_id;
    
    private Match match;
    @FXML
    private JFXTextField id_nombre_spectateur;
    @FXML
    private JFXComboBox<String> id_equipe_1;
    @FXML
    private JFXComboBox<String> id_equipe_2;
    @FXML
    private JFXButton id_button;

    /**
     * Initializes the controller class.
     */
    private void modifier(ActionEvent event) {
         Match M=new Match();
         ServiceMatch SM=new ServiceMatch();
         ServiceEquipe SE=new ServiceEquipe();
        int i1=SE.recuperer_Id_par_nom(this.id_equipe_1.getValue());
        int i2=SE.recuperer_Id_par_nom(this.id_equipe_2.getValue());
        M.setId(SM.get2(i1, i2));
        M.setDate(Date.valueOf(id_date.getValue()));
        M.setHeure(Time.valueOf(id_time.getValue()));
        M.setEtat((Match.EtatMatch)id_etat1.getValue());
        M.setNombre_spectateur(Integer.parseInt(id_nombre_spectateur.getText()));
        SM.modifier_Match(M);
        
    }
     private void afficher(ActionEvent event) {
        hbox_id.setVisible(true);
        ServiceMatch S = new ServiceMatch();
        ServiceEquipe SE=new ServiceEquipe();
        int i1=SE.recuperer_Id_par_nom(this.id_equipe_1.getValue());
        int i2=SE.recuperer_Id_par_nom(this.id_equipe_2.getValue());
        match=S.get1(i1, i2);
        id_date.setValue(match.getDate().toLocalDate());
        id_time.setValue(match.getHeure().toLocalTime());
        id_etat1.setValue((Match.EtatMatch)id_etat1.getValue());
        id_nombre_spectateur.setText(String.valueOf(match.getNombre_spectateur())); //A regler

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        hbox_id.setVisible(false);
        fillCombo();
        id_button.setOnAction(this::afficher);
        
        id_modifier.setOnAction(this::modifier);
        
    }    
    private void fillCombo(){
        ObservableList<Integer> data = FXCollections.observableArrayList();
        ObservableList<String> data1 = FXCollections.observableArrayList();
        ObservableList<String> data2 = FXCollections.observableArrayList();
        ServiceMatch S = new ServiceMatch();
        List<Match> LM=S.get_Match();
        for(Match J : LM){
            data.add(J.getId());
            data1.add(J.getE1().getNom());
            data2.add(J.getE2().getNom());
        }
        ObservableList<Enum> data_Et = FXCollections.observableArrayList();
        data_Et.add(Match.EtatMatch.Debut);
        data_Et.add(Match.EtatMatch.Encours);
        data_Et.add(Match.EtatMatch.Terminé);
        id_etat1.setItems(data_Et);
        id_equipe_1.setItems(data1);
        id_equipe_2.setItems(data2);
    }
     
    
}
