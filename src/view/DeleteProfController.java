/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Departement;
import bean.Matiere;
import bean.Prof;
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
import service.MatiereFacade;
import service.ProfFacade;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class DeleteProfController implements Initializable {

     @FXML
    private ComboBox<Departement> departements = new ComboBox<>();
    @FXML
    private ComboBox<Prof> profs = new ComboBox<>();
    @FXML
    private Label erreur ;
    
    private ProfFacade profFacade = new ProfFacade();
    private DepartementFacade departementFacade = new DepartementFacade();
    
    public void initComboBox(){
        departements.setItems(FXCollections.observableArrayList(departementFacade.findAll()));
    }
    
    public void goMenu(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "Main.fxml", this.getClass());
    }
    
    
    @FXML
    public void findProfByDep(ActionEvent actionEvent) throws IOException{
        
        Departement dep = departements.getSelectionModel().getSelectedItem();
            profs.setItems(FXCollections.observableArrayList(profFacade.findProfByDep(dep)));
        
    }
   
    public void deleteProf(ActionEvent actionEvent) throws IOException{
        if(departements.getValue()==null){
            erreur.setText("(Erreur 'Département') Vous devez choisir un département !");
        }else if(profs.getValue()==null){
            erreur.setText("(Erreur 'Enseigant') Vous devez choisir un enseignant !");
        }else{
            profFacade.deleteProf(profs.getValue());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("L'Enseignant a été supprimer ! ");
            alert.showAndWait();
            ViewLauncher.forward(actionEvent, "DeleteProf.fxml", this.getClass());
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
