/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Util.TextFXPutUtil;
import bean.Departement;
import helper.DepartementFxHelper;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import service.DepartementFacade;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class AddDepartementController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TableView departement = new TableView();
    @FXML
    private Label erreur;
    
         
    
    private DepartementFxHelper departementFxHelper;
    DepartementFacade departementFacade = new DepartementFacade();
    TextFXPutUtil textFXPutUtil = new TextFXPutUtil();
    boolean test = false;
    
    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }


    public DepartementFxHelper getDepartementFxHelper() {
        return departementFxHelper;
    }

    public void setDepartementFxHelper(DepartementFxHelper departementFxHelper) {
        this.departementFxHelper = departementFxHelper;
    }
    

    public DepartementFacade getDepartementFacade() {
        return departementFacade;
    }

    public void setDepartementFacade(DepartementFacade departementFacade) {
        this.departementFacade = departementFacade;
    }
    
    
    
    
    

    public TextField getNom() {
        return nom;
    }

    public void setNom(TextField nom) {
        this.nom = nom;
    }
    
    public void initHelper() {
        departementFxHelper = new DepartementFxHelper(departement,departementFacade.findAll());
    }
    
    
    
    public void createDep(ActionEvent actionEvent) throws IOException {
        
        if (textFXPutUtil.onlyLetters(nom.getText()) == false) {
            erreur.setText("(Erreur 'Nom') un des champs n'a pas bien remplit !");
        }
        else{
        Departement dep = new Departement(nom.getText());
        departementFacade.create(dep);
        
        departementFxHelper.getTable().getItems().add(dep);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Le Département a été créer ! ");
            alert.showAndWait();
            ViewLauncher.forward(actionEvent, "AddDepartement.fxml", this.getClass());
        }
        
    }
    
   public void goMenu(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "Main.fxml", this.getClass());
    }
    
   
    
//    @FXML
//    public void findDepartement(Event event) {
//        Departement departement = departementFxHelper.getSelected();
//        departementFxHelper.setList(departementFacade.findAll());
//    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initHelper();
        // TODO
    }    
    
}
