/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Entite.Evenement;
import Entite.Evenement.TypeCarton;
import Entite.Joueur_P;
import Entite.Match;
import Service.ServiceEvenement;
import Service.ServiceJoueur;
import Service.ServiceJoueur_P;
import Service.ServiceMatch;

/**
 * FXML Controller class
 *
 * @author hseli
 */
public class FormulaireAjoutEventController implements Initializable {

    @FXML
    private JFXComboBox<Integer> id_match;
    @FXML
    private JFXComboBox<String> id_joueur;
    @FXML
    private JFXComboBox<Enum> id_carton;
    @FXML
    private JFXComboBox<Integer> id_but;
    @FXML
    private JFXTextField id_temps;
    @FXML
    private JFXButton id_ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillCombo();
        id_ajouter.setOnAction(this::ajouter);
    }    
    public void fillCombo(){
        ObservableList<Integer> data = FXCollections.observableArrayList();
          ServiceMatch S = new ServiceMatch();
        List<Match> LM=S.get_Match();
        for(Match J : LM){
            data.add(J.getId());
        }
        id_match.setItems(null);
        id_match.setItems(data);
        ObservableList<String> data1 = FXCollections.observableArrayList();
        ServiceJoueur_P SJ=new ServiceJoueur_P();
        List<Joueur_P> LJ=SJ.getALL();
        for (Joueur_P joueur_P : LJ) {
             data1.add(joueur_P.getJ().getNom());
        }
        id_joueur.setItems(data1);
        ObservableList<Enum> data2 = FXCollections.observableArrayList();
        data2.add(Evenement.TypeCarton.PasC);
        data2.add(Evenement.TypeCarton.Jaune);
        data2.add(Evenement.TypeCarton.Rouge);
        id_carton.setItems(data2);
        ObservableList<Integer> data3 = FXCollections.observableArrayList();
        data3.add(0);
        data3.add(1);
        id_but.setItems(data3);
    }
     private void ajouter(ActionEvent event) {
        ServiceJoueur_P SJ=new ServiceJoueur_P();
        ServiceMatch SM=new ServiceMatch();
        ServiceEvenement SE=new ServiceEvenement();
         Evenement M = new Evenement();
         M.setM(SM.get(id_match.getValue()));
         M.setJoueur(SJ.get(SJ.recuperer_Id_par_nom((String)id_joueur.getValue())));
         M.setCarton((TypeCarton)id_carton.getValue());
         M.setBut(id_but.getValue());
         M.setTemps(Integer.parseInt(id_temps.getText()));
         if(id_but.getValue()==0)
         {            
            SE.ajouter_Evenement(M);
         }
         else
       
           SE.ajouter_Evenement1(M);
        
    }
    
}
