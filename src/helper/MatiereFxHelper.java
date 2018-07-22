/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Departement;
import bean.Matiere;
import java.util.List;
import javafx.scene.control.TableView;

/**
 *
 * @author 
 */
public class MatiereFxHelper extends AbstractFxHelper<Matiere> {

    private static AbstractFxHelperItem[] titres;

    static {
        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("Nom de la Matière", "nom"),
            new AbstractFxHelperItem("Nom du Département", "departement")
            
    };
}   

public MatiereFxHelper(TableView<Matiere> table, List<Matiere> list) {
        super(titres,table,list);
    }
public MatiereFxHelper(TableView<Matiere> table) {
        super(titres, table);
    }
    
}
