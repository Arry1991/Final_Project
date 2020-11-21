/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Larkin Gustavson, Archit Shah, and Damiano Di Cocco
 * @version 1.0
 * 
 */
public class Final_ProjectController implements Initializable {

    @FXML
    private ImageView grassBackgroundImage; // used for the grass in the background
    @FXML
    private ImageView woodenBackgroundImage; // used for the wood in the background to show the actions that the user chose
    @FXML
    private ImageView greyRectangleBackground; // used for the grey rectangle in the background to either play the actions that the chose or to stop
    @FXML
    private ImageView goldenRectangleBackground; // used for the rectangle to display possible directions that the character can move 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
       
    }    
    
}
