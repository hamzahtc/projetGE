/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Util.TextFXPutUtil;
import bean.Departement;
import bean.Matiere;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.DepartementFacade;
import service.MatiereFacade;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class EditMatiereController implements Initializable {

    @FXML
    private ComboBox<Departement> departement = new ComboBox<>();
    @FXML
    private ComboBox<Matiere> matiere = new ComboBox<>();
    @FXML
    private TextField nom ;
    @FXML
    private ComboBox<Departement> departementm = new ComboBox<>();
    @FXML
    private Label erreur;
    
    private DepartementFacade departementFacade = new DepartementFacade();
    private MatiereFacade matiereFacade = new MatiereFacade();
    TextFXPutUtil textFXPutUtil = new TextFXPutUtil();
    boolean test = false;
    
    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }
    
    public void initComboBox(){
        departement.setItems(FXCollections.observableArrayList(departementFacade.findAll()));
        departementm.setItems(FXCollections.observableArrayList(departementFacade.findAll()));
    }
    
    public void goMenu(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "Main.fxml", this.getClass());
    }
    
    
    @FXML
    public void findMatiereByDep(ActionEvent actionEvent){
        Departement dep = departement.getSelectionModel().getSelectedItem();
        matiere.setItems(FXCollections.observableArrayList(matiereFacade.findMatiereByDep(dep)));
    }
    
    public void editMatiere(ActionEvent actionEvent) throws IOException{
        if (departement.getValue()==null) {
            erreur.setText("(Erreur 'Département') un des champs n'a pas bien remplit !");
        }
        else if (matiere.getValue()==null) {
            erreur.setText("(Erreur 'Matière') un des champs n'a pas bien remplit !");
        }
        else if (textFXPutUtil.onlyLetters(nom.getText()) == false) {
            erreur.setText("(Erreur 'Nom') un des champs n'a pas bien remplit !");
        } 
        else if (departementm.getValue()==null) {
            erreur.setText("(Erreur 'Département') un des champs n'a pas bien remplit !");
        }
        else{
            matiereFacade.editMatiere(matiere.getValue(), departementm.getValue(), nom.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("La Matière a été modifier ! ");
            alert.showAndWait();
            ViewLauncher.forward(actionEvent, "EditMatiere.fxml", this.getClass());
        }
        
        
    }
    
    public void remplirMatiere(Event event){
        nom.setText(matiere.getValue().getNom());
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComboBox();
        // TODO
    }    
    
}
