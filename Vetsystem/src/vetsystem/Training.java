/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Crisp
 */
public class Training extends Application {
    Stage trainingStage = new Stage();
        @Override
   public void start(Stage Stage) {
		Text text1 = new Text("Animal id: ");
		Text text2 = new Text("Animal name: ");
		Text text3 = new Text("Animal type: ");
                Text text4 = new Text("Animal DOB: ");
		TextField textField1 = new TextField();
                TextField textField2 = new TextField();
		TextField textField3 = new TextField();
                TextField textField4 = new TextField();
		ComboBox comboBox = new ComboBox();
		Button button1 = new Button("Save       Pet");
		Button button2 = new Button("Remove pet");
		//customisation 
		GridPane gridPane = new GridPane();
		gridPane.setMinSize(400, 400);
		gridPane.setPadding(new Insets(10,10,10,10));
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		gridPane.setAlignment(Pos.CENTER);
                gridPane.add(text1, 0, 0);
		gridPane.add(textField1, 1, 0);
		gridPane.add(text2, 0, 2);
                gridPane.add(textField2, 1, 2);
                gridPane.add(text3, 0, 3);
                gridPane.add(button1, 1, 4);
                gridPane.add(textField3, 1, 5);
                gridPane.add(text4, 0, 5);
                gridPane.add(textField4, 1, 3);
		gridPane.add(comboBox, 2, 5);
		gridPane.add(button2, 1, 6);
		button1.setStyle("-fx-background-color; darkslateblue; -fx-text-fill; white; -fx-fontsize:13pt;");
		button2.setStyle("-fx-background-color; darkslateblue; -fx-text-fill; white; -fx-fontsize:13pt;");
		text1.setStyle("-fx-font; normal bold 20px 'serif'");
		text2.setStyle("-fx-font; normal bold 20px 'serif'");
                text3.setStyle("-fx-font; normal bold 20px 'serif'");
		gridPane.setStyle("-fx-background-color: BEIGE;");
                
               //Enent Handling
               button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				String text1 = textField1.getText();
				String text2 = textField2.getText();
				String text3 = textField3.getText();
				String text4 = textField4.getText();
			
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/miniproject","root","");
					Statement st = con.createStatement();
					String mySQL_st = "INSERT INTO `tbl_animal`(`animal_id`,`animal_name`,`animal_type`,`animal_dob`) VALUES("+"'"+text1+"'"+","+"'"+text2+"'"+","+"'"+text3+"'"+","+"'"+text4+"'"+")";                       
					st.execute(mySQL_st);
					con.close();
					textField1.setText("Saving Succesful");
		
				}catch(Exception ee){
					System.out.println(ee);textField2.setText("Saving Unsuccesful");;
						
				}
			}
		});
               
                Stage.setTitle("Training");
                Scene scene = new Scene(gridPane);
                Stage.setScene(scene);
                Stage.show();	
                
               /* button2.setOnMouseClicked((new EventHandler<MouseEvent>(){
            
            
        
          // public void handle(MouseEvent event){
               //Assume the username && password are joe and 12345 respectively
                
         
              // Training hpxyz = new Training();
            
                //   hpxyz.start(hpxyz.specialtrainingStage);
                 //  System.out.println("fhfhfghfgfgnfcgnc");
               
               
          
              // }
           
        }));*/
                
                
	}
    
}
    
