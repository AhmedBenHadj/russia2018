/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.FichePari;
import Entite.Match;
import Entite.Pari;
import Service.ServiceFichePari;
import Service.ServicePari;
import java.awt.Checkbox;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author skanderbejaoui
 */
public class PromoController implements Initializable {

    @FXML
    private TableView<Match> table;
    @FXML
    private TableColumn<Match, String> e1;
    @FXML
    private TableColumn<Match, String> e2;
    @FXML
    private TableColumn<Match, CheckBox> check;
    @FXML
    private ListView<Match> list;
    @FXML
    private Button ajouter;
    @FXML
    private Button annuler;
    @FXML
    private Button valider;

    private CheckBox ckk;
    private ObservableList<Match> data;
    private ObservableList dataa = FXCollections.observableArrayList();
    private List<Match> listmatch = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.setVisible(false);
        ajouter.setVisible(false);
        annuler.setVisible(false);
        data = FXCollections.observableArrayList();
        ServicePari sp = new ServicePari();
        List<Integer> listee = sp.get_idMatch();
        for (Integer integer : listee) {

            Match M = sp.get_Match_Pari(integer);
            M.setId(integer);
            data.add(new Match((M.getE1().getNom()), M.getE2().getNom(), M.getCk(),M.getId()));

            M.setNom1(M.getE1().getNom());
            M.setNom2(M.getE2().getNom());
            M.setCk(M.getCk());
            
            e1.setCellValueFactory(new PropertyValueFactory<>("nom1"));
            e2.setCellValueFactory(new PropertyValueFactory<>("nom2"));
            check.setCellValueFactory(new PropertyValueFactory<>("ck"));
            // cn.setCellValueFactory(new PropertyValueFactory<>("button2"));
            // c2.setCellValueFactory(new PropertyValueFactory<>("button3"));

        }

        table.setItems(null);
        table.setItems(data);

    }

    public void valider(ActionEvent event) {
        
        ServicePari sp = new ServicePari();
        ajouter.setVisible(true);
        annuler.setVisible(true);
        list.setVisible(true);
        List<Integer> listee = sp.get_idMatch();
        for (Match match : data) {
          if (match.getCk().isSelected()) {
                for (Integer integer : listee) {
                         dataa.add(match.toString4());
                         listmatch.add(match);
                          break;
                }
               
            }
list.setItems(dataa);
        }
    }
    
   public void ajouter(ActionEvent event){
       ServicePari sp = new ServicePari();
      ServiceFichePari sfp = new ServiceFichePari();
       FichePari fp = new FichePari();
       fp.setCote_total(0);
       fp.setEtat(FichePari.EtatFiche.Encours);
       fp.getU().setId(1);
       fp.setMisetotal(5);
       fp.setDate(new Date(System.currentTimeMillis()));
       fp.setGain(100);
       for (Match match : listmatch) {
           Pari p = new Pari();
           p.getM().setId(match.getId());
           fp.getParis().add(p);
          
       }
      sfp.ajouterfichepari(fp);
       for (Pari pari : fp.getParis()) {
           
            pari.setFp(fp);
            pari.setGain(new Label("10"));
            sp.ajouterPari(pari);
       }
   }
   
   public void annuler(ActionEvent event){
       dataa.clear();
   }
    
}
