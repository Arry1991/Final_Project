/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Larkin Gustavson, Archit Shah, and Damiano Di Cocco
 * @version 1.0
 * 
 */
public class Final_ProjectController implements Initializable {
    
    private double orgSceneX;
    private double orgSceneY;
    
    private double orgTranslateX;
    private double orgTranslateY;
    
    private double newTranslateX;
    private double newTranslateY;
    
    private double tempTranslateX;
    private double tempTranslateY;
    
    private double finalTranslateX;
    private double finalTranslateY;
    
    private double offsetX; 
    private double offsetY;
    
    private Path path;
        
        private MoveTo moveTo;

        private LineTo line1 ;
        
        private LineTo line2 ;
        
        private LineTo line3 ;
        
        private LineTo line4;
        

     
        public PathTransition pathTransition = new PathTransition();
        
      
        
        private int loop = 0;
        
        
        
      
    
    
    // for "locking" the rectangle into position
    // when the rectangle gets to a desired position, change the background color to blue
    // or in the empty placeholder, hover or select (highlight and put focus) and then move to the source subwindow and select the direction 
    // 
    
    // for using multiple animations
    // use animation set, to determine the order for animation
        
    // 
    // use some if statements to verify the correct position before it gets moved?
    // keep the correct path simple, ~4 units to get to the end 

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
    private Button startButton;
    @FXML
    private Rectangle blueBlock;
    @FXML
    private Circle player;
    @FXML
    private Rectangle bottomRectangle;
    @FXML
    private Rectangle bottomRightRectangle;
    @FXML
    private Rectangle topLeftRectangle;
    @FXML
    private Rectangle endingPoint;
    @FXML
    private Rectangle position2;
    @FXML
    private Rectangle position3;
    @FXML
    private Rectangle position4;

    private MenuItem menuItem1;
    private MenuItem menuItem2;
    private MenuItem menuItem3;
    private MenuItem menuItem4;
    @FXML
    private Button resetButton;
    @FXML
    private Rectangle startingPoint;


    
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

    @FXML
    private void rightClickRectangle1(MouseEvent event) {
        System.out.println("Rectangle 1 clicked");
        
        ContextMenu contextMenu = new ContextMenu();
               
         menuItem1 = new MenuItem("Left");        
         menuItem2 = new MenuItem("Right");  
         menuItem3 = new MenuItem("Up");
         menuItem4 = new MenuItem("Down");
        
        contextMenu.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4);
        
       position1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent> () { // used to add the ability to righ click in the rectangle 
            @Override
            public void handle(MouseEvent t) {
                if (t.getButton() == MouseButton.SECONDARY) { // secondary means right click on the mouse wheel or mouse pad
                    contextMenu.show(position1, t.getScreenX(), t.getScreenY()); // show the context menu on the rectangle, where the person right clicked. 
                }
            }
       });
        
        
       
    }

    @FXML
    private void rightClickRectangle2(MouseEvent event) {
        System.out.println("Rectangle 2 clicked");
        
        ContextMenu contextMenu2 = new ContextMenu(); // adding the context menu
        
        // adding the items that appear in the context menu, they will represent
        // directions that the user can choose
        
         menuItem1 = new MenuItem("Left");        
         menuItem2 = new MenuItem("Right");  
         menuItem3 = new MenuItem("Up");
         menuItem4 = new MenuItem("Down");
        
        contextMenu2.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4); // add all of the menu items to the context menu
        
       position2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent> () { // used to add the ability to righ click in the rectangle (normally isn't possible)
            @Override
            public void handle(MouseEvent t) {
                if (t.getButton() == MouseButton.SECONDARY) { // secondary means right click on the mouse wheel or mouse pad
                    contextMenu2.show(position2, t.getScreenX(), t.getScreenY()); // show the context menu on the rectangle, where the person right clicked. 
                }
            }
       });
    }
    @FXML
    private void movePlayer(MouseEvent event) {
        
     if (loop == 0)
     {
         path = new Path();
        
          moveTo = new MoveTo(0,0); 

       line1 = new LineTo(0,300); 
        
        line2 = new LineTo(400,300);
        
       line3 = new LineTo(400,0);
        
        line4= new LineTo (825,0);


        path.getElements().add(moveTo);
        path.getElements().addAll(line1,line2,line3,line4);
        
       pathTransition = new PathTransition();
        
        pathTransition.setDuration(Duration.millis(10000));
        
        pathTransition.setNode(player);
        
        pathTransition.setPath(path);
        
        loop = 1;
        
        pathTransition.play();
     }
     
     else
     { 
        pathTransition.play();
     }
        
        
        
        
        
    
        
        
       
        
       
        
    }

    @FXML
    private void rightClickRectangle3(MouseEvent event) {
     System.out.println("Rectangle 3 clicked");
        
        ContextMenu contextMenu3 = new ContextMenu(); // adding the context menu
        
        // adding the items that appear in the context menu, they will represent
        // directions that the user can choose
        
         menuItem1 = new MenuItem("Left");        
         menuItem2 = new MenuItem("Right");  
         menuItem3 = new MenuItem("Up");
         menuItem4 = new MenuItem("Down");
        
        contextMenu3.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4); // add all of the menu items to the context menu
        
        position3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent> () { // used to add the ability to righ click in the rectangle (normally isn't possible)
            @Override
            public void handle(MouseEvent t) {
                if (t.getButton() == MouseButton.SECONDARY) { // secondary means right click on the mouse wheel or mouse pad
                    contextMenu3.show(position3, t.getScreenX(), t.getScreenY()); // show the context menu on the rectangle, where the person right clicked. 
                }
            }
       });
        
    }

    @FXML
    private void rightClickRectangle4(MouseEvent event) {
      System.out.println("Rectangle 4 clicked");
        
        ContextMenu contextMenu4 = new ContextMenu(); // adding the context menu
        
        // adding the items that appear in the context menu, they will represent
        // directions that the user can choose
        
         menuItem1 = new MenuItem("Left");        
         menuItem2 = new MenuItem("Right");  
         menuItem3 = new MenuItem("Up");
         menuItem4 = new MenuItem("Down");
        
        contextMenu4.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4); // add all of the menu items to the context menu
        
       position4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent> () { // used to add the ability to righ click in the rectangle (normally isn't possible)
            @Override
            public void handle(MouseEvent t) {
                if (t.getButton() == MouseButton.SECONDARY) { // secondary means right click on the mouse wheel or mouse pad
                    contextMenu4.show(position4, t.getScreenX(), t.getScreenY()); // show the context menu on the rectangle, where the person right clicked. 
                }
            }
       });
       
      
    }

    @FXML
    private void resetPlayer(MouseEvent event) {
        
        pathTransition.pause();
        

    
        
           
        
    }
    
}

   
    


