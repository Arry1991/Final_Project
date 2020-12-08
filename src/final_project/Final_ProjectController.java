/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
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

    private LineTo line1;
    private LineTo line2;
    private LineTo line3;
    private LineTo line4;

    private PathTransition pathTransition;

    private RotateTransition rotateTransition;
    
    private String Rectangle1 = "NULL";
    private String Rectangle2 = "NULL";
    private String Rectangle3 = "NULL";
    private String Rectangle4 = "NULL";

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
    
    private boolean isPaused = true;
    @FXML
    private AnchorPane anchorPane;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     *
     * @param event
     */
    @FXML
    private void arrowDrag(MouseEvent event) {
        offsetX = event.getSceneX() - orgSceneX;
        offsetY = event.getSceneY() - orgSceneY;

        newTranslateX = orgTranslateX + offsetX;
        newTranslateY = orgTranslateY + offsetY;

        ((Rectangle) (event.getSource())).setTranslateX(newTranslateX);
        ((Rectangle) (event.getSource())).setTranslateY(newTranslateY);

    }

    @FXML
    private void arrowPress(MouseEvent event) {

        orgSceneX = event.getSceneX();
        orgSceneY = event.getSceneY();

        orgTranslateX = ((Rectangle) (event.getSource())).getTranslateX();
        orgTranslateY = ((Rectangle) (event.getSource())).getTranslateY();
       
    }

    @FXML
    private void arrowRelease(MouseEvent event) {

    }

    /**
     * A method to allow a user to "right click" on a rectangle to make a
     * movement selection (up, down, left, or right).
     *
     * @param event the event represents the user using the right click on their
     * mouse or trackpad.
     */
    @FXML
    private void rightClickRectangle1(MouseEvent event) {
        System.out.println("Rectangle 1 clicked");
        
        ContextMenu contextMenu = new ContextMenu();
               
         menuItem1 = new MenuItem("Left");        
         menuItem2 = new MenuItem("Right");  
         menuItem3 = new MenuItem("Up");
         menuItem4 = new MenuItem("Down");
        
        contextMenu.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4);
        
         menuItem1.setOnAction((ActionEvent e) -> {
         Rectangle1 = "Left";
         System.out.println("Left");
         Rectangle r = new Rectangle();
         r.setX(20);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/LeftArrowButton.jpg");
         r.setFill(new ImagePattern(img));
         r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
        menuItem2.setOnAction((ActionEvent e) -> {
         Rectangle1 = "Right";
         System.out.println("Right");
         Rectangle r = new Rectangle();
         r.setX(20);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/RightArrowButton.jpg");
         r.setFill(new ImagePattern(img));
         r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
        menuItem3.setOnAction((ActionEvent e) -> {
         Rectangle1 = "Up";
         System.out.println("Up");
         Rectangle r = new Rectangle();
         r.setX(20);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/UpArrowButton.jpg");
         r.setFill(new ImagePattern(img));
   r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
        menuItem4.setOnAction((ActionEvent e) -> {
         Rectangle1 = "Down";
         System.out.println("Down");
         Rectangle r = new Rectangle();
         r.setX(20);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/DownArrowButton.jpg");
         r.setFill(new ImagePattern(img));
         r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
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
        
        menuItem1.setOnAction((ActionEvent e) -> {
         Rectangle2 = "Left";
         System.out.println("Left");
         Rectangle r = new Rectangle();
         r.setX(172);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/LeftArrowButton.jpg");
         r.setFill(new ImagePattern(img));
         r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
        menuItem2.setOnAction((ActionEvent e) -> {
         Rectangle2 = "Right";
         System.out.println("Right");
         Rectangle r = new Rectangle();
         r.setX(172);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/RightArrowButton.jpg");
         r.setFill(new ImagePattern(img));
         r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
        menuItem3.setOnAction((ActionEvent e) -> {
         Rectangle2 = "Up";
         System.out.println("Up");
         Rectangle r = new Rectangle();
         r.setX(172);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/UpArrowButton.jpg");
         r.setFill(new ImagePattern(img));
   r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
        menuItem4.setOnAction((ActionEvent e) -> {
         Rectangle2 = "Down";
         System.out.println("Down");
         Rectangle r = new Rectangle();
         r.setX(172);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/DownArrowButton.jpg");
         r.setFill(new ImagePattern(img));
         r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
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
        
        System.out.println("Rectangle 1 is " + Rectangle1);
        System.out.println("Rectangle 2 is " + Rectangle2);
        System.out.println("Rectangle 3 is " + Rectangle3);
        System.out.println("Rectangle 4 is " + Rectangle4);
        if ( Rectangle1 == "Down" && Rectangle2 == "Right" && Rectangle3 == "Up" && Rectangle4 == "Right")
        {
            Rectangle r = new Rectangle();
         r.setX(800);
         r.setY(15);
         r.setWidth(175);
         r.setHeight(175);
         Image img = new Image("final_project/correctButton.jpg");
         r.setFill(new ImagePattern(img));
         r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
         FadeTransition ft = new FadeTransition(Duration.millis(3000), r);
     ft.setFromValue(1.0);
     ft.setToValue(0.0);
     ft.setCycleCount(1);
     ft.setAutoReverse(false);
 
     ft.play();

        if (isPaused == true) {
            
            path = new Path();

            moveTo = new MoveTo(0, 0);

            line1 = new LineTo(0, 300);

            line2 = new LineTo(414, 300);

            line3 = new LineTo(410, 0);

            line4 = new LineTo(832, 0);

            path.getElements().add(moveTo);

            path.getElements().addAll(line1, line2, line3, line4);

            pathTransition = new PathTransition();

            pathTransition.setDuration(Duration.millis(10000));

            pathTransition.setNode(player);

            pathTransition.setPath(path);

            rotateTransition = new RotateTransition(new Duration(10000), player);
            rotateTransition.setFromAngle(0);
            rotateTransition.setToAngle(180);

            pathTransition.play();
            rotateTransition.play();
            
            isPaused = false;

        } else {
            pathTransition.play();
            rotateTransition.play();

        }

    }
        
        else
        {
            System.out.println("INCORRECT!!");
            
            Rectangle r = new Rectangle();
         r.setX(800);
         r.setY(15);
         r.setWidth(175);
         r.setHeight(175);
         Image img = new Image("final_project/xButton.jpg");
         r.setFill(new ImagePattern(img));
         r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
         FadeTransition ft = new FadeTransition(Duration.millis(3000), r);
     ft.setFromValue(1.0);
     ft.setToValue(0.0);
     ft.setCycleCount(1);
     ft.setAutoReverse(false);
 
     ft.play();
        }
    }
        

    /**
     * A method to allow a user to "right click" on a rectangle to make a
     * movement selection (up, down, left, or right).
     *
     * @param event the event represents the user using the right click on their
     * mouse or trackpad.
     */
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
        
         menuItem1.setOnAction((ActionEvent e) -> {
         Rectangle3 = "Left";
         System.out.println("Left");
         Rectangle r = new Rectangle();
         r.setX(319);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/LeftArrowButton.jpg");
         r.setFill(new ImagePattern(img));
         r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
        menuItem2.setOnAction((ActionEvent e) -> {
         Rectangle3 = "Right";
         System.out.println("Right");
         Rectangle r = new Rectangle();
         r.setX(319);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/RightArrowButton.jpg");
         r.setFill(new ImagePattern(img));
         r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
        menuItem3.setOnAction((ActionEvent e) -> {
         Rectangle3 = "Up";
         System.out.println("Up");
         Rectangle r = new Rectangle();
         r.setX(319);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/UpArrowButton.jpg");
         r.setFill(new ImagePattern(img));
   r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
        menuItem4.setOnAction((ActionEvent e) -> {
         Rectangle3 = "Down";
         System.out.println("Down");
         Rectangle r = new Rectangle();
         r.setX(319);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/DownArrowButton.jpg");
         r.setFill(new ImagePattern(img));
         r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
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
        
         menuItem1.setOnAction((ActionEvent e) -> {
         Rectangle4 = "Left";
         System.out.println("Left");
         Rectangle r = new Rectangle();
         r.setX(475);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/LeftArrowButton.jpg");
         r.setFill(new ImagePattern(img));
         r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
        menuItem2.setOnAction((ActionEvent e) -> {
         Rectangle4 = "Right";
         System.out.println("Right");
         Rectangle r = new Rectangle();
         r.setX(475);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/RightArrowButton.jpg");
         r.setFill(new ImagePattern(img));
         r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
        menuItem3.setOnAction((ActionEvent e) -> {
         Rectangle4 = "Up";
         System.out.println("Up");
         Rectangle r = new Rectangle();
         r.setX(475);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/UpArrowButton.jpg");
         r.setFill(new ImagePattern(img));
         r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
        menuItem4.setOnAction((ActionEvent e) -> {
         Rectangle4 = "Down";
         System.out.println("Down");
         Rectangle r = new Rectangle();
         r.setX(475);
         r.setY(39);
         r.setWidth(120);
         r.setHeight(120);
         Image img = new Image("final_project/DownArrowButton.jpg");
         r.setFill(new ImagePattern(img));
         r.setMouseTransparent(true);
         anchorPane.getChildren().add(r);
      });
        
       position4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent> () { // used to add the ability to righ click in the rectangle (normally isn't possible)
            @Override
            public void handle(MouseEvent t) {
                if (t.getButton() == MouseButton.SECONDARY) { // secondary means right click on the mouse wheel or mouse pad
                    contextMenu4.show(position4, t.getScreenX(), t.getScreenY()); // show the context menu on the rectangle, where the person right clicked. 
                }
            }
       });
       
      
    }
        
    private void pausePlayer(MouseEvent event) {

        pathTransition.pause();

        rotateTransition.pause();

    }

    @FXML
    private void resetPlayer(MouseEvent event) {
        pathTransition.pause();

        rotateTransition.pause();
    }

}
