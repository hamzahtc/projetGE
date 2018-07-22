/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Departement;
import bean.Prof;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import service.DepartementFacade;
import service.ProfFacade;
import service.Sendemailo;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class SendEmailController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ComboBox<Departement> departement = new ComboBox<>();
    @FXML
    private TextArea mssg;
    
    ProfFacade profFacade = new ProfFacade();
    DepartementFacade departementFacade = new DepartementFacade();
    Sendemailo sendemailo = new Sendemailo();

    @FXML
    public void sendmssg(ActionEvent actionEvent){
        List<Prof> profs= profFacade.findProfByDep(departement.getValue());
        for (int i = 0; i < profs.size(); i++) {
            Prof profo = profs.get(i);
            sendemailo.Sendemaila(profo.getEmail(),mssg.getText());
            
        }
        
    }
    public ComboBox<Departement> getDepartement() {
        return departement;
    }

    public void setDepartement(ComboBox<Departement> departement) {
        this.departement = departement;
    }
        
    
    public DepartementFacade getDepartementFacade() {
        return departementFacade;
    }

    public void setDepartementFacade(DepartementFacade departementFacade) {
        this.departementFacade = departementFacade;
    }
    @FXML
    public void goMenu(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "Main.fxml", this.getClass());
    }
    public void initComboBox(){
        departement.setItems(FXCollections.observableArrayList(departementFacade.findAll()));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initComboBox();
    }    
    
}
