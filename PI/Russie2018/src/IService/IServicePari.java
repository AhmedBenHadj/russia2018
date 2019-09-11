/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.Pari;

/**
 *
 * @author skanderbejaoui
 */
public interface IServicePari {
    public void ajouterPari(Pari p);
    public void annulerPari(Pari p);
    public void modifierPari(Pari p);
    public Pari afficherPari(int id);
    public Pari rechercherPari(int id);
}
