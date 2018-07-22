/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Departement;
import java.util.List;
import javafx.scene.control.TableView;

/**
 *
 * @author 
 */
public class DepartementFxHelper extends AbstractFxHelper<Departement> {

    private static AbstractFxHelperItem[] titres;

    static {
        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("Nom du Département", "nom")
            
    };
}   

public DepartementFxHelper(TableView<Departement> table, List<Departement> list) {
        super(titres,table,list);
    }
public DepartementFxHelper(TableView<Departement> table) {
        super(titres, table);
    }
    
}
