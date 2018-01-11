/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xl2dynamodb;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 *
 * @author amlan
 */
public class appuiController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Label seclbl;
    
    @FXML
    private Button browsebtn;
    
    @FXML
    private TextField addrtxt;
    
    @FXML
    private Button sbmtbtn;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //System.out.println("You clicked me!");
        //label.setText("Hello World!");
    }
    
    private String accskyidstr="";
    private String scrtaccskeystr="";
    private String regionstr="";
    
    @FXML
    private void browsefilebtn(ActionEvent event) {
        //infoBox1("Please use brackets for multiple conditions in WHERE", "Error",null);
        FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All Files", "*.*");
                fileChooser.getExtensionFilters().add(extFilter);
                fileChooser.getExtensionFilters().addAll(
                //new FileChooser.ExtensionFilter(),//"TXT files (*.txt)", "*.txt"
                new FileChooser.ExtensionFilter("XLSX", "*.xlsx"),
                new FileChooser.ExtensionFilter("XLS", "*.xls")
            );
                fileChooser.setInitialDirectory(
            new File(System.getProperty("user.home"))
        );
                File file = fileChooser.showOpenDialog(getWindow(browsebtn));
                addrtxt.setText(file.toString());
                System.out.println(file);
                
    }
    
    public static void infoBox1(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
    
    private Window getWindow(Node node)
{
	Window window = null;

	Scene scene = node.getScene();

	if (scene != null)
	{
		window = scene.getWindow();
	}

	return window;
}
    
    
    @FXML
    private void submitButtonAction(ActionEvent event) {
        //System.out.println("You clicked me!");
        //label.setText("Hello World!");
        //LoginuiController.
        
        
        excelfunctions xlobj=new excelfunctions();
        try {
            String fileaddr=addrtxt.getText();
            List xllist=xlobj.readxl(fileaddr.toString());
            dynamodbfunctions dynaobj=new dynamodbfunctions();
            dynaobj.insertItemtodb(accskyidstr,scrtaccskeystr,regionstr,xllist);
            infoBox1("Completed inserting items in DB..", "Success",null);
        } catch (Exception ex) {
            Logger.getLogger(appuiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void getcredentials(String accskyid,String seckey,String rgnstr) {
        // TODO
        //seclbl.setText(seckey);
        accskyidstr=accskyid;
        scrtaccskeystr=seckey;
        regionstr=rgnstr;
    }    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
