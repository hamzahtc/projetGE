/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class RechercheController implements Initializable {

    
    public void goMenu(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "Main.fxml", this.getClass());
    }
    
    public void goRechercheProfByDep(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "RechercheProf.fxml", this.getClass());
    }
    
    public void goRechercheProfByMat(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "RechercheProfByMatiere.fxml", this.getClass());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
