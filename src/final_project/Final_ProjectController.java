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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class Final_ProjectController implements Initializable {
    
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    double newTranslateX, newTranslateY;
    double tempTranslateX, tempTranslateY;
    double finalTranslateX, finalTranslateY;
    double offsetX, offsetY;

    @FXML
    private ImageView grassBackgroundImage; // used for the grass in the background
    @FXML
    private ImageView woodenBackgroundImage; // used for the wood in the background to show the actions that the user chose
    @FXML
    private ImageView greyRectangleBackground; // used for the grey rectangle in the background to either play the actions that the chose or to stop
    @FXML
    private ImageView goldenRectangleBackground; // used for the rectangle to display possible directions that the character can move 
    @FXML
    private Rectangle position1;
    @FXML
    private Rectangle position11;
    @FXML
    private Button startButton;
    @FXML
    private Rectangle blueBlock;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
       
    }    

    @FXML
    private void arrowDrag(MouseEvent event) {
        offsetX = event.getSceneX() - orgSceneX;
        offsetY = event.getSceneY() - orgSceneY;
        newTranslateX = orgTranslateX + offsetX;
        newTranslateY = orgTranslateY + offsetY;
        ((Rectangle)(event.getSource())).setTranslateX(newTranslateX);
        ((Rectangle)(event.getSource())).setTranslateY(newTranslateY);
        
        
        
        
        
        
    }

    @FXML
    private void arrowPress(MouseEvent event) {
        
        orgSceneX = event.getSceneX();
        orgSceneY = event.getSceneY();
        orgTranslateX = ((Rectangle)(event.getSource())).getTranslateX();
        orgTranslateY = ((Rectangle)(event.getSource())).getTranslateY();
        
    }

    @FXML
    private void arrowRelease(MouseEvent event) {

       
       
    }
    

}