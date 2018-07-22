/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;



import bean.Prof;
import java.util.List;
import javafx.scene.control.TableView;

/**
 *
 * @author 
 */
public class ProfFxHelper extends AbstractFxHelper<Prof> {

    private static AbstractFxHelperItem[] titres;

    static {
        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("Nom", "nom"),
            new AbstractFxHelperItem("Prénom", "prenom"),
            new AbstractFxHelperItem("Adresse", "adresse"),
            new AbstractFxHelperItem("E-mail", "email"),
            new AbstractFxHelperItem("Téléphone", "tel"),
            new AbstractFxHelperItem("Département", "departement")
            
    };
}   

public ProfFxHelper(TableView<Prof> table, List<Prof> list) {
        super(titres,table,list);
    }
public ProfFxHelper(TableView<Prof> table) {
        super(titres, table);
    }
    
}
