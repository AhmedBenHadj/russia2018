/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controller;

import Entite.Entraineur;
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
    @FXML
    private TitledPane Gere_Entraineur;
    @FXML
    private JFXListView<String> Gerer_Entraineur_List;
    @FXML
    private TitledPane Gere_Event;
    @FXML
    private JFXListView<String> Gerer_Event_list;
    
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
        ObservableList<String> liste_equipe=FXCollections.observableArrayList();
        liste_equipe.add("Ajout équipe");
        liste_equipe.add("modifier équipe");
        liste_equipe.add("supprimer équipe");
        Gerer_Equipe_List.setItems(liste_equipe);
        ObservableList<String> liste_option_equipe=FXCollections.observableArrayList();
        liste_option_equipe.add("Toutes les équipes");
        liste_option_equipe.add("Toutes les entraineurs");
        Equipe_List.setItems(liste_option_equipe);
        ObservableList<String> liste_entraineur=FXCollections.observableArrayList();
        liste_entraineur.add("Ajouter entraineur");
        liste_entraineur.add("modifier entraineur");
        liste_entraineur.add("supprimer entraineur");
        Gerer_Entraineur_List.setItems(liste_entraineur);
        ObservableList<String> liste_match=FXCollections.observableArrayList();
        liste_match.add("Ajouter match");
        liste_match.add("Modifier match");
        Gerer_match_list.setItems(liste_match);
        ObservableList<String> liste_stade=FXCollections.observableArrayList();
        liste_stade.add("Ajouter stade");
        Gerer_Stade_List.setItems(liste_stade);
        ObservableList<String> liste_event=FXCollections.observableArrayList();
        liste_event.add("Ajouter event");
        Gerer_Event_list.setItems(liste_event);
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
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/formulaire_ajout_joueur.fxml"));
                        Tab tb=new Tab("Ajout joueur",node);
                        Dashboard_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(i==1){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/formulaire_modifier_joueur.fxml"));
                        Tab tb=new Tab("Modifier joueur",node);
                        Dashboard_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(i==2){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/supprimer_joueur.fxml"));
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
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/conteneur_liste_joueur.fxml"));
                        Tab tb=new Tab("Tout les joueurs",node);
                        tb.setClosable(true);
                        Main_tabpane.getTabs().add(tb); 
                    
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        Equipe_List.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                int i=Equipe_List.getSelectionModel().getSelectedIndex();
                if(i==0){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/Conteneur_liste_equipe.fxml"));
                        Tab tb=new Tab("Toutes les équipes",node);
                        Main_tabpane.getTabs().add(tb);
                        //Equipe_List.getSelectionModel().clearSelection();
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                    catch(java.lang.IndexOutOfBoundsException e){
                        
                    }
                } 
                if(i==1){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/Conteneur_liste_entraineur.fxml"));
                        Tab tb=new Tab("Tout les entraineur",node);
                        Main_tabpane.getTabs().add(tb);
                        //Equipe_List.getSelectionModel().clearSelection();
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                    catch(java.lang.IndexOutOfBoundsException e){
                        
                    }
                }
            }           
        });
        
        Gerer_Equipe_List.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                int i=Gerer_Equipe_List.getSelectionModel().getSelectedIndex();
                if(i==0){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/formulaire_ajout_equipe.fxml"));
                        Tab tb=new Tab("Ajout équipe",node);
                        Dashboard_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i==1){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/modifier_equipe.fxml"));
                        Tab tb=new Tab("Modifier equipe",node);
                        Dashboard_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i==2){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/supprimer_equipe.fxml"));
                        Tab tb=new Tab("Supprimer equipe",node);
                        Dashboard_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        Gerer_Entraineur_List.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                int i=Gerer_Entraineur_List.getSelectionModel().getSelectedIndex();
                if(i==0){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/Formulaire_ajout_entraineur.fxml"));
                        Tab tb=new Tab("Ajout entraineur",node);
                        Dashboard_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i==1){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/Formulaire_modifier_entraineur.fxml"));
                        Tab tb=new Tab("Modifier entraineur",node);
                        Dashboard_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i==2){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/Formulaire_supprimer_entraineur.fxml"));
                        Tab tb=new Tab("Supprimer entraineur",node);
                        Dashboard_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        Gerer_match_list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                int i=Gerer_match_list.getSelectionModel().getSelectedIndex();
                if(i==0){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/FormulaireAjoutMatch.fxml"));
                        Tab tb=new Tab("Ajout Match",node);
                        Dashboard_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i==1){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/FormulaireModifMatch.fxml"));
                        Tab tb=new Tab("Modifier Match",node);
                        Dashboard_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        Gerer_Stade_List.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                int i=Gerer_Stade_List.getSelectionModel().getSelectedIndex();
                if(i==0){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/FormulaireAjoutStade.fxml"));
                        Tab tb=new Tab("Ajout Stade",node);
                        Dashboard_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        Gerer_Event_list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                int i=Gerer_Event_list.getSelectionModel().getSelectedIndex();
                if(i==0){
                    try {
                        Node node=(AnchorPane) FXMLLoader.load(getClass().getResource("/Presentation/view/FormulaireAjoutEvent.fxml"));
                        Tab tb=new Tab("Ajout Event",node);
                        Dashboard_tabpane.getTabs().add(tb);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
}
