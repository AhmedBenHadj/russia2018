/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.FichePari;
import Entite.Pari;
import Entite.User;
import Service.ServiceFichePari;
import Service.ServicePari;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author skanderbejaoui
 */
public class UpariController implements Initializable {

    @FXML
    private ListView<FichePari> list;
    ObservableList observableList = FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<String> choix;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choix.getItems().add("Afficher les paris gagnés");
        choix.getItems().add("Afficher les paris perdus");
        choix.setValue("Afficher les paris en cours");
        User u = new User();
        u.setId(5);
        FichePari fp = new FichePari();
        fp.setU(u);
        //System.out.println(fp.getU().getId());
        ServicePari sp = new ServicePari();
        ServiceFichePari sfp = new ServiceFichePari();
        List<Integer> listee = sfp.get_idPari();
        for (Integer integer : listee) {
            fp.getU().setId(u.getId());
            fp = sfp.affichertousFP(integer, fp.getU().getId());
            for (Pari pari : fp.getParis()) {
               observableList.add(pari.toString()+fp.toString());
               
            }
        }
        list.setItems(observableList);
    }
    

}
