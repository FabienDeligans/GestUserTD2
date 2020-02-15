/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import modeles.Categorie;

/**
 *
 * @author Fabien
 */
public class CategorieDao {

    public List<Categorie> listeCategories() {
        Categorie categorie;
        List<Categorie> lCategories = new ArrayList<Categorie>();
        
        categorie = new Categorie();
        categorie.setIdCategorie(1);
        categorie.setLibCategorie("Particulier");
        lCategories.add(categorie);
        
        categorie = new Categorie();
        categorie.setIdCategorie(2);
        categorie.setLibCategorie("Entreprise");
        lCategories.add(categorie);
        
        categorie = new Categorie();
        categorie.setIdCategorie(3);
        categorie.setLibCategorie("Association");
        lCategories.add(categorie);
        
        categorie = new Categorie();
        categorie.setIdCategorie(4);
        categorie.setLibCategorie("Administration");
        lCategories.add(categorie);
        
        return (lCategories);
    }
}
