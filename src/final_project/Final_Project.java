/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.util.HashSet;
import java.util.Set;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Larkin Gustavson, Archit Shah, and Damiano Di Cocco
 * @version 1.0
 * This the driver class for the Kodable game.
   It features a start method and a main method
   The start method loads the FXML file and 
   displays what is on screen. 
   The main method launches command line arguments.
   * 
 * @see Final_ProjectController
 */
public class Final_Project extends Application {

    /**
     * The main method of the application 
     * 
     * @author Larkin Gustavson, Archit Shah, and Damiano Di Cocco
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
      launch(args);
    }
     
    /**
     * 
     * @param stage the "window" of the application, the screen with what the user will see. 
     *                  
     * @throws Exception if the application is not able to load in the window.
     */
    @Override
    public void start(Stage stage) throws Exception {
     
     Parent group = FXMLLoader.load(getClass().getResource("Final_Project.fxml")); // load the FXML file
     
     Scene scene = new Scene(group); // create the scene, comprised of the group
     
     stage.setScene(scene);
     
     stage.setResizable(false); // not allowing the user to resize the screen
     
     stage.sizeToScene(); // setting the size of the stage to be the scene 
     
     stage.setTitle("Kodable");    
     
     stage.show();
    
    }
    
}
