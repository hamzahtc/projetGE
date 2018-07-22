/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Util.TextFXPutUtil;
import bean.Departement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import service.DepartementFacade;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class DeleteDepartementController implements Initializable {

    @FXML
    private ComboBox<Departement> departement = new ComboBox<>();
    @FXML
    private Label erreur;
    
    private DepartementFacade departementFacade = new DepartementFacade();
    
    
    public void initComboBox(){
        departement.setItems(FXCollections.observableArrayList(departementFacade.findAll()));
    }
    
    public void goMenu(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "Main.fxml", this.getClass());
    }
    
    
    public void deleteDepartement(ActionEvent actionEvent) throws IOException{
        if(departement.getValue()==null){
            erreur.setText("(Erreur 'Département') Vous devez choisir un département !");
        }
        else{
            departementFacade.deleteDepartement(departement.getValue());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Le Département a été supprimer ! ");
            alert.showAndWait();
            ViewLauncher.forward(actionEvent, "DeleteDepartement.fxml", this.getClass());
        }
        
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
