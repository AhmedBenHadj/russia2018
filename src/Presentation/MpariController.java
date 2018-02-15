/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.FichePari;
import Entite.Pari;
import Service.ServiceFichePari;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author skanderbejaoui
 */
public class MpariController implements Initializable {

    @FXML
    private ListView<?> list;
     ObservableList observableList = FXCollections.observableArrayList();
    @FXML
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //  ServicePari sp = new ServicePari();
        ServiceFichePari sfp = new ServiceFichePari();
        List<Integer> listee = sfp.get_idPari();
        FichePari fp = new FichePari();
        for (Integer integer : listee) {
            fp = sfp.afficherModerateur(integer);
            for (Pari pari : fp.getParis()) {
               observableList.add(pari.toString()+fp.toString2());
               
            }
        }
         list.setItems(observableList);
    }    
    
}
