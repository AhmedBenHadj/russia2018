/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.Commentaire;
import java.util.List;

/**
 *
 * @author Ghassen
 */
public interface IServiceCommentaire {
    public void create(Commentaire e,int id_publication,int id_user);
    public List<Commentaire> retrieve();
    public List<Commentaire> retrieve(int id_publication);
    public List<Commentaire> retrieveIdUser(int id_user);
    //public Commentaire retrievePublication(int id_publication);
    public void update(Commentaire e);
    public void delete(Commentaire e);
    public int count();
}
