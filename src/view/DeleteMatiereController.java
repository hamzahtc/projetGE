/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Departement;
import bean.Matiere;
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

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class DeleteMatiereController implements Initializable {

    @FXML
    private ComboBox<Departement> departements = new ComboBox<>();
    @FXML
    private ComboBox<Matiere> matieres = new ComboBox<>();
    @FXML
    private Label erreur ;
    
    private MatiereFacade matiereFacade = new MatiereFacade();
    private DepartementFacade departementFacade = new DepartementFacade();
    
    public void initComboBox(){
        departements.setItems(FXCollections.observableArrayList(departementFacade.findAll()));
    }
    
    
    public void goMenu(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "Main.fxml", this.getClass());
    }
    
    @FXML
    public void findMatiereByDep(ActionEvent actionEvent){
        Departement dep = departements.getSelectionModel().getSelectedItem();
        matieres.setItems(FXCollections.observableArrayList(matiereFacade.findMatiereByDep(dep)));
    }
    
    
    
    public void deleteMatiere(ActionEvent actionEvent) throws IOException{
        if(departements.getValue()==null){
            erreur.setText("(Erreur 'Département') Vous devez choisir un département !");
        }else if(matieres.getValue()==null){
            erreur.setText("(Erreur 'Matière') Vous devez choisir une matière !");
        }else{
            matiereFacade.deleteMatiere(matieres.getValue());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("La Matière a été supprimer ! ");
            alert.showAndWait();
            ViewLauncher.forward(actionEvent, "DeleteMatiere.fxml", this.getClass());
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
