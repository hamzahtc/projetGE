/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Util.TextFXPutUtil;
import bean.Departement;
import bean.Prof;
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
import service.ProfFacade;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class EditprofController implements Initializable {

    @FXML
    private ComboBox<Departement> departement = new ComboBox<>();
    @FXML
    private ComboBox<Prof> prof = new ComboBox<>();
    @FXML
    private TextField nom ;
    @FXML
    private TextField prenom ;
    @FXML
    private TextField adresse ;
    @FXML
    private TextField email ;
    @FXML
    private TextField tel ;
    @FXML
    private Label erreur;
    
    private DepartementFacade departementFacade = new DepartementFacade();
    private ProfFacade profFacade = new ProfFacade();
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
    }
    
    public void goMenu(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "Main.fxml", this.getClass());
    }
    
    
    @FXML
    public void findProfByDep(ActionEvent actionEvent){
        
        Departement dep = departement.getSelectionModel().getSelectedItem();
       prof.setItems(FXCollections.observableArrayList(profFacade.findProfByDep(dep)));
    }
    
    public void remplirField(Event event){
        nom.setText(prof.getValue().getNom());
        prenom.setText(prof.getValue().getPrenom());
        adresse.setText(prof.getValue().getAdresse());
        email.setText(prof.getValue().getEmail());
        tel.setText("0" + prof.getValue().getTel());
    }
    
    public void editProf(ActionEvent actionEvent) throws IOException{
        if (departement.getValue() == null) {
            erreur.setText("(Erreur 'Département') un des champs n'a pas bien remplit !");
        }else if (prof.getValue() == null) {
            erreur.setText("(Erreur 'Enseignant') un des champs n'a pas bien remplit !");
        }
        else if (textFXPutUtil.onlyLetters(nom.getText()) == false) {
            erreur.setText("(Erreur 'Nom') un des champs n'a pas bien remplit !");
        } else if (textFXPutUtil.onlyLetters(prenom.getText()) == false) {
            erreur.setText("(Erreur 'Prenom') un des champs n'a pas bien remplit !");
        } else if (adresse.getText().equals("")) {
            erreur.setText("(Erreur 'Adresse') un des champs n'a pas bien remplit !");
        }else if (textFXPutUtil.isEmailAdresse(email.getText()) == false) {
            erreur.setText("(Erreur 'Email') un des champs n'a pas bien remplit !");
        }else if (textFXPutUtil.isTel(tel.getText()) == false) {
            erreur.setText("(Erreur 'Téléphone') un des champs n'a pas bien remplit !");
        }else {
            profFacade.editProf(prof.getValue(), nom.getText(), prenom.getText(), adresse.getText(), email.getText(), Integer.parseInt(tel.getText()));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("L'enseignant a été modifier ! ");
            alert.showAndWait();
            ViewLauncher.forward(actionEvent, "EditProf.fxml", this.getClass());
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
