/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.Publication;
import java.util.List;

/**
 *
 * @author Ghassen
 */
public interface IServicePublication {
        public void create(Publication e) ;
        public void create(Publication e,int id_user) ;
        public List<Publication> retrieve();
        public List<Publication> retrieveIdUser(int id_user);
        public List<Publication> retrieveGalerie();
        public List<Publication> retrieveArticle();
        public void update(Publication e) ;
        public void delete(Publication e) ;
        public int count();
        public int countGalerie();
        public int countArticle();
}
