/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Util.TextFXPutUtil;
import bean.Departement;
import bean.Matiere;
import bean.Prof;
import helper.MatiereFxHelper;
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
public class AddProfsController implements Initializable {

     @FXML
    private TextField cin;
     @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField adresse;
    @FXML
    private TextField email;
    @FXML
    private TextField tel;
    @FXML
    private ComboBox<Departement> departements = new ComboBox<>();
    @FXML
    private ComboBox<Matiere> matieres = new ComboBox<>();
    @FXML
    private TableView listMatiere = new TableView();
    @FXML
    private Label erreur;
    
    ProfFacade profFacade = new ProfFacade();
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
    
    
    private MatiereFxHelper matiereFxHelper;
    
    public void goMenu(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "Main.fxml", this.getClass());
    }
    
    
    public void createProf(ActionEvent actionEvent) throws IOException{
        if (textFXPutUtil.onlyLetters(nom.getText()) == false) {
            erreur.setText("(Erreur 'Nom') un des champs n'a pas bien remplit !");
        } else if (textFXPutUtil.onlyLetters(prenom.getText()) == false) {
            erreur.setText("(Erreur 'Prenom') un des champs n'a pas bien remplit !");
        } else if (adresse.getText().equals("")) {
            erreur.setText("(Erreur 'Adresse') un des champs n'a pas bien remplit !");
        }else if (textFXPutUtil.isEmailAdresse(email.getText()) == false) {
            erreur.setText("(Erreur 'Email') un des champs n'a pas bien remplit !");
        }else if (textFXPutUtil.isTel(tel.getText()) == false) {
            erreur.setText("(Erreur 'Téléphone') un des champs n'a pas bien remplit !");
        }else if (departements.getValue() == null) {
            erreur.setText("(Erreur 'Département') un des champs n'a pas bien remplit !");
        }else {
            Prof prof = new Prof(cin.getText(), nom.getText(), prenom.getText(), adresse.getText(), email.getText(), Integer.parseInt(tel.getText()), departements.getValue());
            profFacade.save(prof, matiereFxHelper.getTable().getItems());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("L'enseignant a été créer ! ");
            alert.showAndWait();
            ViewLauncher.forward(actionEvent, "AddProfs.fxml", this.getClass());
            
        }
        
    }
    
    @FXML
    public void saveMatiere(ActionEvent actionEvent) {
        if (departements.getValue() == null) {
            erreur.setText("(Erreur 'Département') un des champs n'a pas bien remplit !");
        }else if (matieres.getValue() == null) {
            erreur.setText("(Erreur 'Matière') un des champs n'a pas bien remplit !");
        }else {
            Matiere matiere = matieres.getValue();
            
            matiereFxHelper.getTable().getItems().add(matiere);
        }
        
    }
    
    @FXML
    public void deleteMatiere(ActionEvent actionEvent){
        
        int matiere = this.listMatiere.getSelectionModel().getSelectedIndex();
        matiereFxHelper.getTable().getItems().remove(matiere);
        
    }
    
    
    public void initComboBox(){
        departements.setItems(FXCollections.observableArrayList(departementFacade.findAll()));
    }
    
    public void initHelper(){
        matiereFxHelper = new MatiereFxHelper(listMatiere);
    }
    
    @FXML
    public void findMatiereByDep(Event event){
        Departement dep = departements.getSelectionModel().getSelectedItem();
        matieres.setItems(FXCollections.observableArrayList(matiereFacade.findMatiereByDep(dep)));
    }

    public TextField getNom() {
        return nom;
    }

    public void setNom(TextField nom) {
        this.nom = nom;
    }

    public TextField getPrenom() {
        return prenom;
    }

    public void setPrenom(TextField prenom) {
        this.prenom = prenom;
    }

    public TextField getAdresse() {
        return adresse;
    }

    public void setAdresse(TextField adresse) {
        this.adresse = adresse;
    }

    public TextField getEmail() {
        return email;
    }

    public void setEmail(TextField email) {
        this.email = email;
    }

    public TextField getTel() {
        return tel;
    }

    public void setTel(TextField tel) {
        this.tel = tel;
    }

    public ComboBox<Departement> getDepartements() {
        return departements;
    }

    public void setDepartements(ComboBox<Departement> departements) {
        this.departements = departements;
    }

    public ComboBox<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(ComboBox<Matiere> matieres) {
        this.matieres = matieres;
    }

    public TableView getListMatiere() {
        return listMatiere;
    }

    public void setListMatiere(TableView listMatiere) {
        this.listMatiere = listMatiere;
    }

    public ProfFacade getProfFacade() {
        return profFacade;
    }

    public void setProfFacade(ProfFacade profFacade) {
        this.profFacade = profFacade;
    }

    public MatiereFacade getMatiereFacade() {
        return matiereFacade;
    }

    public void setMatiereFacade(MatiereFacade matiereFacade) {
        this.matiereFacade = matiereFacade;
    }

    public DepartementFacade getDepartementFacade() {
        return departementFacade;
    }

    public void setDepartementFacade(DepartementFacade departementFacade) {
        this.departementFacade = departementFacade;
    }

    public MatiereFxHelper getMatiereFxHelper() {
        return matiereFxHelper;
    }

    public void setMatiereFxHelper(MatiereFxHelper matiereFxHelper) {
        this.matiereFxHelper = matiereFxHelper;
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initHelper();
        initComboBox();
        // TODO
    }    
}
