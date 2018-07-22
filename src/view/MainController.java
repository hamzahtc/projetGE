/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import helper.DepartementFxHelper;
import helper.MatiereFxHelper;
import helper.ProfFxHelper;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import service.DepartementFacade;
import service.MatiereFacade;
import service.ProfFacade;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class MainController implements Initializable {
    

    @FXML 
    private TableView matieres = new TableView();
    @FXML 
    private TableView profs = new TableView();
    @FXML 
    private TableView departements = new TableView();

    private ProfFxHelper profFxHelper ;
    private DepartementFxHelper departementFxHelper;
    private MatiereFxHelper matiereFxHelper;
    
    private ProfFacade profFacade = new ProfFacade();
    private DepartementFacade departementFacade = new DepartementFacade();
    private MatiereFacade matiereFacade = new MatiereFacade();

    public ProfFacade getProfFacade() {
        return profFacade;
    }

    public void setProfFacade(ProfFacade profFacade) {
        this.profFacade = profFacade;
    }

    public DepartementFacade getDepartementFacade() {
        return departementFacade;
    }

    public void setDepartementFacade(DepartementFacade departementFacade) {
        this.departementFacade = departementFacade;
    }

    public MatiereFacade getMatiereFacade() {
        return matiereFacade;
    }

    public void setMatiereFacade(MatiereFacade matiereFacade) {
        this.matiereFacade = matiereFacade;
    }
    
    

    public ProfFxHelper getProfFxHelper() {
        return profFxHelper;
    }

    public void setProfFxHelper(ProfFxHelper profFxHelper) {
        this.profFxHelper = profFxHelper;
    }

    public DepartementFxHelper getDepartementFxHelper() {
        return departementFxHelper;
    }

    public void setDepartementFxHelper(DepartementFxHelper departementFxHelper) {
        this.departementFxHelper = departementFxHelper;
    }

    public MatiereFxHelper getMatiereFxHelper() {
        return matiereFxHelper;
    }

    public void setMatiereFxHelper(MatiereFxHelper matiereFxHelper) {
        this.matiereFxHelper = matiereFxHelper;
    }
    
    
    public TableView getMatieres() {
        return matieres;
    }

    public void setMatieres(TableView matieres) {
        this.matieres = matieres;
    }

    public TableView getProfs() {
        return profs;
    }

    public void setProfs(TableView profs) {
        this.profs = profs;
    }

    public TableView getDepartements() {
        return departements;
    }

    public void setDepartements(TableView departements) {
        this.departements = departements;
    }
    
     
    public void initHelper(){
        profFxHelper = new ProfFxHelper(profs, profFacade.findAll());
        departementFxHelper = new DepartementFxHelper(departements, departementFacade.findAll());
        matiereFxHelper = new MatiereFxHelper(matieres, matiereFacade.findAll());
    }
    
    public void addProf(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "AddProfs.fxml", this.getClass());
    }
    public void addDepartement(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "AddDepartement.fxml", this.getClass());
    }
    public void addMatiere(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "AddMatiere.fxml", this.getClass());
    }
    public void editProf(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "EditProf.fxml", this.getClass());
    }
    public void editDepartement(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "EditDepartement.fxml", this.getClass());
    }
    public void editMatiere(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "EditMatiere.fxml", this.getClass());
    }
    public void deleteProf(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "DeleteProf.fxml", this.getClass());
    }
    public void deleteDepartement(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "DeleteDepartement.fxml", this.getClass());
    }
    public void deleteMatiere(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "DeleteMatiere.fxml", this.getClass());
    }
    public void recherche(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "Recherche.fxml", this.getClass());
    }
    @FXML
    public void goEmail(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "SendEmail.fxml", this.getClass());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initHelper();
        // TODO
    }    
    
}
