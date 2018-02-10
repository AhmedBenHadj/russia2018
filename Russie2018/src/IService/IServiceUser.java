/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.User;
import java.util.List;

/**
 *
 * @author Ghassen
 */
public interface IServiceUser {
    public void create(User e);
    public List<User> retrieve();
    public List<String> retrieveLikeUsername(String username);
    public User retrieveId(int id);
    public User retrieveEmail(String email);
    public User retrieveUsername(String username);
    public void update(User e);
    public void delete(User e);
    public int count();
}
