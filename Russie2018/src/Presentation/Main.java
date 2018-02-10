/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author eloss
 */
public class Main extends Application {
    
   //This is our PrimaryStage (It contains everything)
    private Stage primaryStage;
 
    //This is the BorderPane of RootLayout
    private AnchorPane rootLayout;
 
    @Override
    public void start(Stage primaryStage) {
        //1) Declare a primary stage (Everything will be on this stage)
        this.primaryStage = primaryStage;
 
        //Optional: Set a title for primary stage
        this.primaryStage.setTitle("Russia 2018");
 
        //2) Initialize RootLayout
        initRootLayout();
 
        //3) Display the EmployeeOperations View
        //showEmployeeOperationsView();
    }
 
    //Initializes the root layout.
    public void initRootLayout() {
        try {
            //First, load root layout from RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("acceuil.fxml"));
            rootLayout =(AnchorPane) loader.load();
 
            //Second, show the scene containing the root layout.
            Scene scene = new Scene(rootLayout); //We are sending rootLayout to the Scene.
            primaryStage.setScene(scene); //Set the scene in primary stage.
 
            //Third, show the primary stage
            primaryStage.show(); //Display the primary stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    //Shows the employee operations view inside the root layout.
    /*public void showEmployeeOperationsView() {
        try {
            //First, load EmployeeOperationsView from EmployeeOperations.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/test_1/view/Employee.fxml"));  
            AnchorPane employeeOperationsView = (AnchorPane) loader.load();
 
            // Set Employee Operations view into the center of root layout.
            rootLayout.setCenter(employeeOperationsView);
            //rootLayout.setBorder(employeeOperationsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
 
    public static void main(String[] args) {
        launch(args);
    }
    
}
