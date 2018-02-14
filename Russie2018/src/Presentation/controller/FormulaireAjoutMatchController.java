/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controller;

import Configuration.MyConnexion;
import Entite.Equipe;
import Entite.Groupe;
import Entite.Match;
import Entite.Match.EtatMatch;
import Entite.Match.progress;
import Entite.Stade;
import Service.ServiceEquipe;
import Service.ServiceGroupe;
import Service.ServiceMatch;
import Service.ServiceStade;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author hseli
 */
public class FormulaireAjoutMatchController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ComboBox id_groupe;
    
    @FXML
    private ComboBox id_equipe_1;
    
    @FXML
    private ComboBox id_equipe_2;
    
    @FXML
    private ComboBox id_stade;
    
    
    @FXML
    private ComboBox id_etat;
    
    @FXML
    private TextField id_nombre_spectateur;
    
    @FXML
    private Button id_ajouter;
    @FXML
    private DatePicker id_date;
    @FXML
    private JFXTimePicker id_time;
    @FXML
    private ComboBox<Enum> id_type;
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        fillCombo();
        id_ajouter.setOnAction(this::ajouter);
        
    }
    public void fillCombo(){
        ObservableList<String> data = FXCollections.observableArrayList();
        ObservableList<String> data_Eq1 = FXCollections.observableArrayList();
        ObservableList<String> data_Eq2 = FXCollections.observableArrayList();
        ObservableList<String> data_St = FXCollections.observableArrayList();
        ObservableList<Enum> data_Et = FXCollections.observableArrayList();
        ObservableList<Enum> data_Pro = FXCollections.observableArrayList();
        ServiceGroupe SG=new ServiceGroupe();
      
        List<Groupe> LG = SG.get_Groupe();
        for (Groupe groupe : LG) {
            data.add(groupe.getNom());
        }
        id_groupe.setItems(null);
        id_groupe.setItems(data);
        
        ServiceEquipe SE=new ServiceEquipe();
        List<Equipe> LE=SE.getALL();
        for (Equipe equipe : LE) {
            data_Eq1.add(equipe.getNom());
            data_Eq2.add(equipe.getNom());
        }
        id_equipe_1.setItems(null);
        id_equipe_1.setItems(data_Eq1);
        id_equipe_2.setItems(null);
        id_equipe_2.setItems(data_Eq2);
        
        ServiceStade SS=new ServiceStade();
        List<Stade> LS=SS.get_Stade();
        for (Stade stade : LS) {
            data_St.add(stade.getNom());
        }
        id_stade.setItems(null);
        id_stade.setItems(data_St);
       /* ServiceMatch SM=new ServiceMatch();
        List<Match> LM=SM.get_Match();
        for (Match match : LM) {
            
          
        }*/
        data_Et.add(Match.EtatMatch.Debut);
        data_Et.add(Match.EtatMatch.Encours);
        data_Et.add(Match.EtatMatch.Terminé);
            data_Pro.add(Match.progress.pool);
            data_Pro.add(Match.progress.last_16);
            data_Pro.add(Match.progress.demi_final);
            data_Pro.add(Match.progress.quart_final);
            data_Pro.add(Match.progress.final_);
        id_etat.setItems(data_Et);
        id_type.setItems(null);
        id_type.setItems(data_Pro);
    }
    
    @FXML
    private void ajouter(ActionEvent event) {
        ServiceEquipe SE=new ServiceEquipe();
        ServiceGroupe SG=new ServiceGroupe();
        ServiceStade SS=new ServiceStade();
        ServiceMatch SM=new ServiceMatch();
         Match M = new Match();
         M.setG(SG.get(SG.recuperer_Id_par_nom((String)id_groupe.getValue())));
         M.setE1(SE.get(SE.recuperer_Id_par_nom((String)id_equipe_1.getValue())));
         M.setE2(SE.get(SE.recuperer_Id_par_nom((String)id_equipe_2.getValue())));
         M.setS(SS.get(SS.recuperer_Id_par_nom((String)id_stade.getValue())));
         M.setDate(Date.valueOf(id_date.getValue()));
         M.setHeure(Time.valueOf(id_time.getValue()));
         M.setEtat((EtatMatch)id_etat.getValue());
         M.setType((progress)id_type.getValue());
         M.setNombre_spectateur(Integer.parseInt(id_nombre_spectateur.getText()));
         SM.ajouter_Match(M);
        
      
        System.out.println(Date.valueOf(id_date.getValue()));
        System.out.println((EtatMatch)id_etat.getValue());
        System.out.println(SE.get(SE.recuperer_Id_par_nom((String)id_equipe_1.getValue())));
        System.out.println(new ServiceEquipe().recuperer_Id_par_nom((String)id_equipe_1.getValue()));

    }
    
}
