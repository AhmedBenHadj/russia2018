/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.controller;

import Entite.Abonnement;
import Entite.Joueur;
import Entite.User;
import Service.ServiceAbonnement;
import Service.ServiceUser;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author eloss
 */
public class Case_joueur_1Controller implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label age;
    @FXML
    private Label club;
    @FXML
    private Label equipe;
    @FXML
    private Label poste;
    private Joueur joueur ;
    @FXML
    private ImageView image;
    @FXML
    private JFXButton abonner;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setJoueur(Joueur J){
        this.joueur = J ;
        nom.setText(J.getNom());
        prenom.setText(J.getPrenom());
        poste.setText(J.getPoste());
        age.setText(Integer.toString(J.getAge()));
        club.setText(J.getClub());
        equipe.setText(J.getEquipe().getNom());
        image.setImage(new Image("file:"+J.getImage()));
        //System.out.println(new ServiceAbonnement().get_users_etleur_Joueur().get(new ServiceUser().retrieveId(1)));
        //System.out.println(new ServiceUser().retrieveId(1));
        if(new ServiceAbonnement().get_users_etleur_Joueur().get(new ServiceUser().retrieveId(1)) != null){
            if(new ServiceAbonnement().get_users_etleur_Joueur().get(new ServiceUser().retrieveId(1)).contains(J)){
            abonner.setText("Abonnée");
        }
        else
            abonner.setText("s'abonner");
        }
    }

    @FXML
    private void s_abonner(ActionEvent event) {
        boolean aux=false ;
        User U = new User();
        U = new ServiceUser().retrieveId(1);
        Abonnement A = new Abonnement(U, joueur);
        if(abonner.getText().equals("s'abonner")){
            new ServiceAbonnement().s_abonner_a(U, joueur);
            abonner.setText("Abonnée");
        }
        else{
            new ServiceAbonnement().supprimer(new ServiceAbonnement().get(U, joueur));
            abonner.setText("s'abonner");
        }
    }
}
