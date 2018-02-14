/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Joueur;
import java.net.URL;
import java.util.ResourceBundle;
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
public class Case_joueurController implements Initializable {

    @FXML
    private ImageView image;
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
    }
}
