/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author skanderbejaoui
 */
public class Pari {
    private int id;
    private Match m;
    private float cote;
    private float mise;
   private FichePari fp;
   private Label gain;
   private String nom1;
   private String nom2;
   private TextField tf;
    public TextField getTf() {
        return tf;
    }

    public void setTf(TextField tf) {
        this.tf = tf;
    }
     public void setTf(String tf) {
        this.tf =new TextField(tf);
    }
   
    public String getNom1() {
        return nom1;
    }

    public void setNom1(String nom1) {
        this.nom1 = nom1;
    }

    public String getNom2() {
        return nom2;
    }

    public void setNom2(String nom2) {
        this.nom2 = nom2;
    }

    public Label getGain() {
        return gain;
    }

    public void setGain(Label gain) {
        this.gain = gain;
    }

   
    public float getMise() {
        return mise;
    }

    public void setMise(float mise) {
        this.mise = mise;
    }
    public FichePari getFp() {
        return fp;
    }

    public void setFp(FichePari fp) {
        this.fp = fp;
    }

    public Match getM() {
        return m;
    }

    public void setM(Match m) {
        this.m = m;
    }

    public Pari() {
        this.fp = new FichePari();
        this.m = new Match();
        this.tf = new TextField("");
        this.gain=new Label("");
        
        
    }
    
    public Pari(String a,String b,Float cote,String tf,Label gain,int id){
        this.gain = new Label();
        this.fp = new FichePari();
        this.m = new Match();
        this.setNom1(a);
        this.setNom2(b);
        this.cote=cote;
        this.gain=gain;
        this.tf = new TextField(tf);
        this.getTf().setText(tf);
        this.id=id;
        //System.out.println(this.getTf().getText());
       
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCote() {
        return cote;
    }

    public void setCote(float cote) {
        this.cote = cote;
    }
    public String toString(){
        return "        "+this.getM().getE1().getNom() +"      "+this.getM().getE2().getNom();
    }
   
    
}
