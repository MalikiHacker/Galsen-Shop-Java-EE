/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.maliki.galsenshop.beans;

import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import sn.maliki.galsenshop.entities.Categorie;
import sn.maliki.galsenshop.facadePattern.CategorieFacade;

/**
 *
 * @author DMC
 */
@Singleton
@Startup
public class InitCategorie {

    public InitCategorie() {
    }

    // Add business logic below. (Right-click in editor and choose
    @EJB
    private CategorieFacade categories;

    // "Insert Code > Add Business Method")
    @PostConstruct
    public void init() {
        Categorie[] newCategories = new Categorie[4];

        newCategories[0] = new Categorie("BSE", "biens sociaux essentiels", "les matières premières de base, "
                + "les biens d’équipement et les intrants spécifiques.", new BigDecimal(0.00));
        newCategories[1] = new Categorie("BPN", "biens de première nécessité", "les médicaments, "
                + "appareils médico-chirurgicaux, le papier journal, les livres, les journaux, les fauteuils "
                + "roulants, certains engrais etc.", new BigDecimal(0.05));
        newCategories[2] = new Categorie("IPI", "intrants et produits intermédiaires", "", new BigDecimal(0.10));
        newCategories[3] = new Categorie("BCF", "biens de consommation finale", "catégorie par défaut", new BigDecimal(0.20));

        System.out.println(" nombre de categories = " + categories.count());
         for (Categorie cat : newCategories) {

            if (!categories.findAll().contains(cat)) {
                System.out.println("Enregistrement de  " + cat);
                categories.create(cat);

            }

        }
         System.out.println("");
    }

//    @PreDestroy
//    public void destruct() {
//        categories.close();
//    }

}
