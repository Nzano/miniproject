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
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author Crisp
 */
public class Staff extends Application{
    Stage staffStage = new Stage();
    	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		Text namelbl = new Text("Name:");
		Text idlbl = new Text("Id");
		Text deptlbl = new Text("Department");
		Text rolelbl= new Text("Role");
		Text contactlbl = new Text("Contact");
		TextField nameTf = new TextField();
		TextField idTf = new TextField();
		TextField deptTf = new TextField();
		TextField contactTf = new TextField();
		ChoiceBox role = new ChoiceBox();
		role.getItems().addAll("Vet", "Nurse","Cleaner", "guard");
		Button saveBtn = new Button("Save");
		Button deleteBtn = new Button("Delete");
		
		grid.setMinSize(600, 400);
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		grid.add(namelbl, 0, 0);
		grid.add(nameTf, 1, 0);
		grid.add(idlbl, 0, 1);
		grid.add(idTf, 1, 1);
		grid.add(contactlbl, 0, 2);
		grid.add(contactTf, 1, 2);
		grid.add(deptlbl, 0, 3);
		grid.add(deptTf, 1, 3);
		grid.add(rolelbl, 0, 4);
		grid.add(role, 1, 4);
		grid.add(saveBtn, 0, 5);
		grid.add(deleteBtn, 1, 5);
		
		
		saveBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				String name = nameTf.getText();
				String id = idTf.getText();
				String dept = deptTf.getText();
				String contact = contactTf.getText();
				String roles = (String)role.getValue();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/miniproject","root","");
					Statement st = con.createStatement();
					String mySQL_st = "INSERT INTO `tbl_staffmembers`(`staff_name`,`staff_id`,`staff_tellno`,`staff_dept`,`staffrole`) VALUES("+"'"+name+"'"+","+"'"+id+"'"+","+"'"+contact+"'"+","+"'"+dept+"'"+","+"'"+role+"'"+")";                       
					st.execute(mySQL_st);
					con.close();
					nameTf.setText("Saving Succesful");
		
				}catch(Exception ee){
					System.out.println(ee);nameTf.setText("Saving Unsuccesful");;
						
				}
			}
		});
		
		Stage stage = new Stage();
		Scene scene = new Scene(grid);
		stage.setScene(scene);
		stage.setTitle("STAFF MEMBERS");
		stage.show();
		
		
	}
}

	


