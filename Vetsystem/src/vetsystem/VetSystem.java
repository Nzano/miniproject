/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetsystem;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Crisp
 */
public class VetSystem extends Application {
    
    @Override
   public void start(Stage primaryStage) {
                Button button1 = new Button("Training");
		Button button2 = new Button("Special Training ");
                Button button3 = new Button("Treatment");
                Button button4 = new Button("Staff");
                Button button5 = new Button("");
                Button button6 = new Button("");
           
                
                GridPane gridPane = new GridPane();
		gridPane.setMinSize(600, 400);
		gridPane.setPadding(new Insets(10,10,10,10));
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		gridPane.setAlignment(Pos.CENTER);
                
		gridPane.add(button1, 0, 1);
                gridPane.add(button2, 0, 2);
                gridPane.add(button3, 2, 1);
                gridPane.add(button4, 2, 2);
                gridPane.add(button5, 3, 1);
                gridPane.add(button6, 3, 2);
             
                
                
                
                primaryStage.setTitle("Vet System");
                Scene scene = new Scene(gridPane);
                primaryStage.setScene(scene);
                primaryStage.show();
                 //Event handling 
                 
        button1.setOnMouseClicked((new EventHandler<MouseEvent>(){
            
            
        
           public void handle(MouseEvent event){
               //Assume the username && password are joe and 12345 respectively
                
         
               Training hpxyz = new Training();
            
                   hpxyz.start(hpxyz.trainingStage);
                   System.out.println("fhfhfghfgfgnfcgnc");
               
               
          
               }
           
        }));

         button4.setOnMouseClicked((new EventHandler<MouseEvent>(){
            
            
        
           public void handle(MouseEvent event){
               //Assume the username && password are joe and 12345 respectively
                
         
               Staff hpxyz = new Staff();
            
                   hpxyz.start(hpxyz.staffStage);
                   System.out.println("fhfhfghfgfgnfcgnc");
               
               
          
               }
           
        }));
              button3.setOnMouseClicked((new EventHandler<MouseEvent>(){
            
            
        
           public void handle(MouseEvent event){
               //Assume the username && password are joe and 12345 respectively
                
         
               Treatment hpxyz = new Treatment();
            
                   hpxyz.start(hpxyz.treatmentStage);
                   System.out.println("fhfhfghfgfgnfcgnc");
               
               
          
               }
           
        }));
         
        
        button2.setOnMouseClicked((new EventHandler<MouseEvent>(){
            
            
        
           public void handle(MouseEvent event){
               //Assume the username && password are joe and 12345 respectively
                
         
               Specialtraining hpxyz = new Specialtraining();
            
                   hpxyz.start(hpxyz.specialtrainingStage);
                   System.out.println("fhfhfghfgfgnfcgnc");
               
               
          
               }
           
        }));
     
   
    
     
    
    }
    
   
      

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}





