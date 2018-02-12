/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author eloss
 */
public class AcceuilController implements Initializable {

    @FXML
    private AnchorPane Main_Anchor;
    @FXML
    private GridPane Main_grid;
    @FXML
    private GridPane Login_grid;
    @FXML
    private Label Id_titre;
    @FXML
    private TabPane Main_tabpane;
    @FXML
    private Tab Acceuil;
    @FXML
    private AnchorPane Acceuil_Anchor;
    @FXML
    private Tab Galerie;
    @FXML
    private AnchorPane Galerie_Anchor;
    @FXML
    private Tab Pari;
    @FXML
    private AnchorPane Pari_Anchor;
    @FXML
    private SplitPane Pari_Splitpane;
    @FXML
    private AnchorPane Anchor_1;
    @FXML
    private AnchorPane Anchor_2;
    @FXML
    private Tab Fantasy;
    @FXML
    private AnchorPane Fantasy_Anchor;
    @FXML
    private Tab Profil;
    @FXML
    private AnchorPane Profil_Anchor;
    @FXML
    private GridPane Profil_Grid;
    @FXML
    private GridPane Down_Grid;
    @FXML
    private ImageView Photo_profil;
    @FXML
    private TabPane Profil_Tabpane;
    @FXML
    private Tab Mes_Abonnements;
    @FXML
    private AnchorPane Abonnements_Anchor;
    @FXML
    private Tab Mes_Paris;
    @FXML
    private AnchorPane Paris_Anchor;
    @FXML
    private Tab Ma_Fantasy;
    @FXML
    private AnchorPane Fantasy_Anchor_1;
    @FXML
    private Tab Mes_Publications;
    @FXML
    private AnchorPane Publication_Anchor;
    @FXML
    private Tab Dashboard;
    @FXML
    private AnchorPane Dashboard_Anchor;
    @FXML
    private SplitPane Split_Anchor;
    @FXML
    private AnchorPane Anchor_Split_1;
    @FXML
    private Accordion Dashboard_Accordion;
    @FXML
    private AnchorPane Anchor_Split_2;
    @FXML
    private VBox Id_vbox;
    @FXML
    private Accordion Id_accordion;
    @FXML
    private TitledPane Joueur;
    @FXML
    private AnchorPane Joueur_Anchor;
    @FXML
    private TitledPane Match;
    @FXML
    private AnchorPane Match_anchor;
    @FXML
    private TitledPane Calendrier;
    @FXML
    private AnchorPane Calendrier_anchor;
    @FXML
    private TitledPane Equipes;
    @FXML
    private AnchorPane Equipe_Anchor;
    @FXML
    private GridPane Grid_chat;
    @FXML
    private Label Id_Chat;
    @FXML
    private JFXListView<String> Gerer_match_list;
    @FXML
    private JFXListView<String> Gere_Evenement_list;
    @FXML
    private TitledPane Gere_Groupe;
    @FXML
    private JFXListView<String> Gere_Groupe_List;
    @FXML
    private TitledPane Gere_Stade;
    @FXML
    private JFXListView<String> Gerer_Stade_List;
    @FXML
    private TitledPane Gere_Joueur;
    @FXML
    private JFXListView<String> Gerer_Joueur_List;
    @FXML
    private TitledPane Gere_Equipe;
    @FXML
    private JFXListView<String> Gerer_Equipe_List;
    @FXML
    private TabPane Dashboard_tabpane;
    @FXML
    private JFXListView<String> Joueur_List;
    @FXML
    private JFXListView<String> Mach_list;
    @FXML
    private JFXListView<String> Calendrier_List;
    @FXML
    private JFXListView<String> Equipe_List;
    @FXML
    private JFXTextArea Liste_discussion;
    @FXML
    private JFXTextField id_ecriture;
    
    private void loadListview(){
        ObservableList<String> ols=FXCollections.observableArrayList();
        ols.add("Ajouter Match");
        ols.add("Modifier Match");
        Gerer_match_list.setItems(ols);
        ObservableList<String> liste_joueur=FXCollections.observableArrayList();
        liste_joueur.add("Ajouter joueur");
        liste_joueur.add("Modifier joueur");
        liste_joueur.add("Supprimer joueur");
        Gerer_Joueur_List.setItems(liste_joueur);
        ObservableList<String> liste_option_joueur=FXCollections.observableArrayList();
        liste_option_joueur.add("Tout les joueurs");
        Joueur_List.setItems(liste_option_joueur);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadListview();
        selectMenu();
    }    
    private void selectMenu(){
        Gerer_Joueur_List.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int i=Gerer_Joueur_List.getSelectionModel().getSelectedIndex();
                if(i==0){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("formulaire_ajout_joueur.fxml"));
                        Tab tb=new Tab("Ajout joueur",node);
                        Dashboard_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(i==1){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("formulaire_modifier_joueur.fxml"));
                        Tab tb=new Tab("Modifier joueur",node);
                        Dashboard_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(i==2){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("supprimer_joueur.fxml"));
                        Tab tb=new Tab("Supprimer joueur",node);
                        Dashboard_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        Joueur_List.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                int i=Joueur_List.getSelectionModel().getSelectedIndex();
                if(i==0){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("conteneur_liste_joueur.fxml"));
                        Tab tb=new Tab("Tout les joueurs",node);
                        Main_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
}
