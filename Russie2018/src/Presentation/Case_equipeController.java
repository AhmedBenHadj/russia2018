/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Equipe;
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
public class Case_equipeController implements Initializable {

    @FXML
    private ImageView drapeau;
    @FXML
    private ImageView maillot;
    @FXML
    private Label nom;
    @FXML
    private Label groupe;
    @FXML
    private Label entraineur;
    @FXML
    private Label points;
    @FXML
    private Label progress;

    private Equipe equipe ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setEquipe(Equipe equipe ){
        this.equipe = equipe ;
        nom.setText(equipe.getNom());
        groupe.setText(equipe.getGroupe().getNom());
        entraineur.setText(equipe.getEntraineur().getNom());
        points.setText(Integer.toString(equipe.getPts()));
        progress.setText(equipe.getProgress().toString());
        drapeau.setImage(new Image("file:"+equipe.getDrapeau()));
        maillot.setImage(new Image("file:"+equipe.getMaillot()));
    }
}
