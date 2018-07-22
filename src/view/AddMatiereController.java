/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Util.TextFXPutUtil;
import bean.Departement;
import bean.Matiere;
import helper.MatiereFxHelper;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import service.DepartementFacade;
import service.MatiereFacade;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class AddMatiereController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TableView matieres = new TableView();
    @FXML
    private ComboBox<Departement> departement = new ComboBox<>();
    @FXML
    private Label erreur;
    
    
    private MatiereFxHelper matiereFxHelper;
    MatiereFacade matiereFacade = new MatiereFacade();
    DepartementFacade departementFacade = new DepartementFacade();
    TextFXPutUtil textFXPutUtil = new TextFXPutUtil();
    boolean test = false;
    
    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }
    
    public void goMenu(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "Main.fxml", this.getClass());
    }
    

    public TextField getNom() {
        return nom;
    }

    public void setNom(TextField nom) {
        this.nom = nom;
    }

    public TableView getMatieres() {
        return matieres;
    }

    public void setMatieres(TableView matieres) {
        this.matieres = matieres;
    }

    public ComboBox<Departement> getDepartement() {
        return departement;
    }

    public void setDepartement(ComboBox<Departement> departement) {
        this.departement = departement;
    }

    public MatiereFxHelper getMatiereFxHelper() {
        return matiereFxHelper;
    }

    public void setMatiereFxHelper(MatiereFxHelper matiereFxHelper) {
        this.matiereFxHelper = matiereFxHelper;
    }

    public MatiereFacade getMatiereFacade() {
        return matiereFacade;
    }

    public void setMatiereFacade(MatiereFacade matiereFacade) {
        this.matiereFacade = matiereFacade;
    }
    
    public void initComboBox() {
        departement.setItems(FXCollections.observableArrayList(departementFacade.findAll()));
    }
    
    public void initHelper(){
        matiereFxHelper = new MatiereFxHelper(matieres, matiereFacade.findAll());
    }
    
    public void createMatiere(ActionEvent actionEvent) throws IOException{
        if (textFXPutUtil.onlyLetters(nom.getText()) == false) {
            erreur.setText("(Erreur 'Nom') un des champs n'a pas bien remplit !");
        }
        else if (departement.getValue() == null){
            erreur.setText("(Erreur 'Département') un des champs n'a pas bien remplit !");
        }
        else{
            Matiere matiere = new Matiere(nom.getText(), departement.getValue());

            matiereFacade.create(matiere);
            matiereFxHelper.getTable().getItems().add(matiere);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("La Matière a été créer ! ");
            alert.showAndWait();
            
            ViewLauncher.forward(actionEvent, "AddMatiere.fxml", this.getClass());
        }
        
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
