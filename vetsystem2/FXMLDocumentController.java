/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetsystem2;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Crisp
 */
public class FXMLDocumentController implements Initializable {
    
  @FXML
    private AnchorPane pane_login;

    @FXML
    private TextField txt_staff_name_up;

    @FXML
    private PasswordField txt_staff_password_up;

    @FXML
    private ComboBox staff_role;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    

    @FXML
    private Button btn_login;

    @FXML
    private AnchorPane pane_register;

    @FXML
    private TextField txt_med_name_up;

    @FXML
    private PasswordField txt_med_dose_up;

    @FXML
    private TextField txt_med_id_up;

    @FXML
    private TextField txt_animal_id_up;

    @FXML
    private TextField txt_animal_sickness_up;

    public void LoginpaneShow(){
        pane_login.setVisible(true);
        pane_register.setVisible(false);
    }
    @FXML
    private void Login (ActionEvent event) throws Exception{
        conn = msqlconnect.ConnectDb();
        String sql = "Select * from tbl_staffmembers where staff_name = ? and staff_password = ? and staff_role = ? ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_staff_name_up.getText());
            pst.setString(2, txt_staff_password_up.getText());
            pst.setString(3, staff_role.getValue().toString());
            
            rs = pst.executeQuery();   
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Username And Password is Correct");
            }
            else
                JOptionPane.showMessageDialog(null, "Invalid Username or Pssword");
                
                btn_login.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("CPanel.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        }
        catch (Exception e ){
            
             JOptionPane.showMessageDialog(null, e);
            
        }
    }
    public void RegisterpaneShow(){
        pane_login.setVisible(false);
        pane_register.setVisible(true);
    }
   /* @FXML
    private void Register (ActionEvent event) throws Exception{
        conn = msqlconnect.ConnectDb();*/
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        staff_role.getItems().addAll("Veterinarian", "Nurse","Client");
    }    
    
}
