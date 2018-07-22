/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Departement;
import bean.Matiere;
import helper.ProfFxHelper;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import service.DepartementFacade;
import service.MatiereFacade;
import service.ProfFacade;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class RechercheProfController implements Initializable {

    @FXML
    private TextField nom ;
    @FXML
    private ComboBox<Departement> departement = new ComboBox<>() ;
    @FXML
    private TableView profs = new TableView();
    
    private ProfFxHelper profFxHelper ;
    private ProfFacade profFacade = new ProfFacade();
    private MatiereFacade matiereFacade = new MatiereFacade();
    private DepartementFacade departementFacade = new DepartementFacade();
    
     public void initComboBox(){
        departement.setItems(FXCollections.observableArrayList(departementFacade.findAll()));
    }
     
     public void goRecherche(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "Recherche.fxml", this.getClass());
    }
    
     
     public  void initHelper(){
         profFxHelper = new ProfFxHelper(profs);
     }
     
    
    
    public void findProf(ActionEvent actionEvent){
        profFxHelper.setList(profFacade.FindProf(nom.getText(), departement.getValue()));
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComboBox();
        initHelper();
        // TODO
    }    
    
}
