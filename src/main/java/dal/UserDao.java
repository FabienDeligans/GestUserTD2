/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import modeles.*;

/**
 *
 * @author Fabien
 */
public class UserDao {
    public boolean connecter(User user){
        boolean ok = false; 
        if((user.getLogin().equals("auchon")) && (user.getPwd().equals("paul"))){
            user.setAdresse("15, rue du vieux bourg, 69126 Brindas"); 
            user.setIdCategorie(1);
            user.setNom("Auchon");
            user.setPrenom("Paul");
            ok = true; 
        }
        return ok; 
    }
    
}
