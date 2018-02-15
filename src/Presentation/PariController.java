package Presentation;

import Entite.Equipe;
import Entite.FichePari;
import Entite.Match;
import Entite.Pari;
import Entite.User;
import Service.ServiceFichePari;
import Service.ServicePari;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAttribute;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author skanderbejaoui
 */
public class PariController implements Initializable {

    @FXML
    private Label ctotlab;

    @FXML
    private Label gtotlab;

    @FXML
    private TextField gtot;

    @FXML
    private Button vmp;

    @FXML
    private TextField ctot;

    @FXML
    private CheckBox multiple;

    @FXML
    private CheckBox simple;

    @FXML
    private TableColumn<Pari, Float> c;

    @FXML
    private TableColumn<Pari, String> e11;

    @FXML
    private TableColumn<Pari, String> e22;

    @FXML
    private TableColumn<Pari, String> g;

    @FXML
    private TableColumn<Pari, Float> m;
    @FXML
    private TableView<Match> table;
    @FXML
    private TableView<Pari> table2;
    @FXML
    private TableColumn<Match, String> e1;
    @FXML
    private TableColumn<Match, String> e2;
    @FXML
    private TableColumn<Match, Float> c1;
    @FXML
    private TableColumn<Match, Float> cn;
    @FXML
    private TableColumn<Match, Float> c2;
    private ObservableList<Match> data;
    private ObservableList<Pari> dataa;
    private ToggleButton button11;
    private ToggleButton button22;
    private ToggleButton button33;
    @FXML
    private Button bpari;

    private TextField tff;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gtot.setVisible(false);
        ctotlab.setVisible(false);
        gtotlab.setVisible(false);
        vmp.setVisible(false);
        gtot.setVisible(false);
        ctot.setVisible(false);
        multiple.setVisible(false);
        simple.setVisible(false);
        table2.setVisible(false);
        data = FXCollections.observableArrayList();
        ServicePari sp = new ServicePari();
        List<Integer> listee = sp.get_idMatch();
        for (Integer integer : listee) {

            Match M = sp.get_Match_Pari(integer);
            M.setId(integer);
            data.add(new Match((M.getE1().getNom()), M.getE2().getNom(), M.getCote_eq1(), M.getCote_nul(), M.getCote_eq2(), M.getId()));

            M.setNom1(M.getE1().getNom());
            M.setNom2(M.getE2().getNom());
            button11 = new ToggleButton(String.valueOf(M.getCote_eq1()));
            M.setButton1(button11);
            button22 = new ToggleButton(String.valueOf(M.getCote_nul()));
            M.setButton2(button22);
            button33 = new ToggleButton(String.valueOf(M.getCote_eq2()));
            M.setButton3(button33);
            e1.setCellValueFactory(new PropertyValueFactory<>("nom1"));
            e2.setCellValueFactory(new PropertyValueFactory<>("nom2"));
            c1.setCellValueFactory(new PropertyValueFactory<>("button1"));
            cn.setCellValueFactory(new PropertyValueFactory<>("button2"));
            c2.setCellValueFactory(new PropertyValueFactory<>("button3"));

        }

        table.setItems(null);
        table.setItems(data);

    }

    @FXML
    private void parier(ActionEvent event) {
        ServicePari spp = new ServicePari();
        List<Integer> liste = spp.get_idMatch();

        tff = new TextField("0.0");
        multiple.setVisible(true);
        simple.setVisible(true);
        table2.setVisible(true);
        dataa = FXCollections.observableArrayList();

        ServicePari sp = new ServicePari();
        List<Integer> listee = sp.get_idMatch();
        for (Match match : data) {
            if (match.getButton1().isSelected()) {
                for (Integer integer : listee) {

                    Match M = sp.get_Match_Pari(integer);

                    Pari P = new Pari();
                    P.getGain().setText("0.0");
                    P.setM(M);
                    P.getM().setId(match.getId());

                    P.setCote(Float.valueOf(match.getButton1().getText()));

                    P.setTf(tff);

                    dataa.add(new Pari(match.getNom1(), match.getNom2(), P.getCote(), P.getTf().getText(), P.getGain(), P.getM().getId()));

                    e11.setCellValueFactory(new PropertyValueFactory<>("nom1"));
                    e22.setCellValueFactory(new PropertyValueFactory<>("nom2"));
                    c.setCellValueFactory(new PropertyValueFactory<>("cote"));
                    m.setCellValueFactory(new PropertyValueFactory<>("tf"));
                    g.setCellValueFactory(new PropertyValueFactory<>("gain"));
                    break;

                }
            }
            if (match.getButton2().isSelected()) {
                for (Integer integer : listee) {

                    Match M = sp.get_Match_Pari(integer);
                    M.setId(match.getId());
                    Pari P = new Pari();
                    P.getGain().setText("0.0");
                    P.setM(M);
                    P.getM().setId(match.getId());
                    P.setCote(Float.valueOf(match.getButton2().getText()));

                    P.setTf(tff);

                    dataa.add(new Pari(match.getNom1(), match.getNom2(), P.getCote(), P.getTf().getText(), P.getGain(), P.getM().getId()));

                    e11.setCellValueFactory(new PropertyValueFactory<>("nom1"));
                    e22.setCellValueFactory(new PropertyValueFactory<>("nom2"));
                    c.setCellValueFactory(new PropertyValueFactory<>("cote"));
                    m.setCellValueFactory(new PropertyValueFactory<>("tf"));
                    g.setCellValueFactory(new PropertyValueFactory<>("gain"));
                    break;
                }
            }
            if (match.getButton3().isSelected()) {
                for (Integer integer : listee) {

                    Match M = sp.get_Match_Pari(integer);
                   
                    Pari P = new Pari();
                    P.setM(M);
                    P.getM().setId(match.getId());
                    P.getGain().setText("0.0");
                    P.setTf(tff);
                    P.setM(M);
                    P.setCote(Float.valueOf(match.getButton3().getText()));

                    dataa.add(new Pari(match.getNom1(), match.getNom2(), P.getCote(), P.getTf().getText(), P.getGain(), P.getM().getId()));
                    e11.setCellValueFactory(new PropertyValueFactory<>("nom1"));
                    e22.setCellValueFactory(new PropertyValueFactory<>("nom2"));
                    c.setCellValueFactory(new PropertyValueFactory<>("cote"));
                    m.setCellValueFactory(new PropertyValueFactory<>("tf"));
                    g.setCellValueFactory(new PropertyValueFactory<>("gain"));
                    break;
                }
            }
            table2.setItems(null);
            table2.setItems(dataa);

            for (Pari p : dataa) {
                p.getTf().setOnKeyReleased(new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        float m = 0;
                        float t = Float.parseFloat(p.getTf().getText()) * p.getCote();
                        p.setMise(Float.parseFloat(p.getTf().getText()));
                        p.getGain().setText(String.valueOf(t));

                        float c = 1;
                        float g = 0;
                        if (multiple.isSelected()) {
                            for (Pari p : dataa) {

                                m += p.getMise();

                                c *= p.getCote();

                                if (c != 0) {
                                    ctot.setText(String.valueOf(c));
                                    gtot.setText(String.valueOf(c * m));
                                } else {
                                    ctot.setText("0");
                                    gtot.setText("0");
                                }

                            }

                        } else if (simple.isSelected()) {
                            for (Pari p : dataa) {
                                g += Float.parseFloat(p.getGain().getText());
                                if (g != 0) {
                                    gtot.setText(String.valueOf(g));
                                } else {
                                    gtot.setText("0");
                                }
                            }
                        }
                    }
                });
            }

        }
    }

    public void simple(ActionEvent event) {
        float g = 0;
        gtot.setText("0");
        if (simple.isSelected()) {
            vmp.setVisible(true);
            multiple.setDisable(true);
            gtotlab.setVisible(true);
            gtot.setVisible(true);
            for (Pari p : dataa) {
                g += Float.parseFloat(p.getGain().getText());
                if (g != 0) {
                    gtot.setText(String.valueOf(g));
                } else {
                    gtot.setText("0");
                }
            }

        } else {
            multiple.setDisable(false);
            gtotlab.setVisible(false);
            gtot.setVisible(false);
            gtot.setText("0");
            vmp.setVisible(false);
        }

    }

    public void multiple(ActionEvent event) {
        float m = 0;
        float c = 1;
        if (multiple.isSelected()) {
            simple.setDisable(true);
            gtotlab.setVisible(true);
            gtot.setVisible(true);
            ctotlab.setVisible(true);
            ctot.setVisible(true);
            vmp.setVisible(true);
            for (Pari p : dataa) {

                m += p.getMise();

                c *= p.getCote();

                if (c != 0) {
                    ctot.setText(String.valueOf(c));
                    gtot.setText(String.valueOf(c * m));
                } else {
                    ctot.setText("0");
                    gtot.setText("0");
                }

            }

        } else {
            simple.setDisable(false);
            gtotlab.setVisible(false);
            gtot.setVisible(false);
            ctotlab.setVisible(false);
            ctot.setVisible(false);
            vmp.setVisible(false);
        }

    }

    public void valider(ActionEvent event) {
      User u = new User();
         u.setId(5);
        if(simple.isSelected()){
         for (Pari p : dataa) {
             ServiceFichePari sfp = new ServiceFichePari();
             FichePari fp = new FichePari();
             ServicePari sp = new ServicePari();
             fp.setCote_total(p.getCote());
             fp.setEtat(FichePari.EtatFiche.Encours);
             fp.getU().setId(u.getId());
             fp.setMisetotal(p.getMise());
             fp.setDate(new Date(System.currentTimeMillis()));
             fp.setGain(Float.parseFloat(p.getGain().getText()));
             sfp.ajouterfichepari(fp);
             p.getM().setId(p.getId());
             fp.getParis().add(p);
             p.setFp(fp);
             sp.ajouterPari(p);
         }
     }
           
     else if(multiple.isSelected()){
         float m =0;

         ServiceFichePari sfp = new ServiceFichePari();
         ServicePari sp = new ServicePari();
         FichePari fp = new FichePari();
         String t = ctot.getText();
         String g = gtot.getText();
         
         for (Pari pari : dataa) {
            m+=pari.getMise();
            pari.getM().setId(pari.getId());
             fp.getParis().add(pari);
             
         }
         fp.setCote_total(Float.parseFloat(t));
         fp.setEtat(FichePari.EtatFiche.Encours);
         fp.getU().setId(u.getId());
         fp.setMisetotal(m);
         fp.setDate(new Date(System.currentTimeMillis()));
         fp.setGain(m);
         fp.setGain(Float.parseFloat(g));
         sfp.ajouterfichepari(fp);
         for (Pari pari : fp.getParis()) {
             pari.setFp(fp);
             sp.ajouterPari(pari);
         }
     }
            
    }
}
