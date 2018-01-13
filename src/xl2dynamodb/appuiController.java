/**
 *@fileoverview Controller file for the select file UI
 * @author amlan
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
    
   
    
    private String accskyidstr="";
    private String scrtaccskeystr="";
    private String regionstr="";
    private String tblnme="";
    
    @FXML
    private void browsefilebtn(ActionEvent event) {
        
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

        excelfunctions xlobj=new excelfunctions();
        boolean fleexists=false;
        try {
            if(addrtxt.getText() == null || addrtxt.getText().trim().isEmpty()){
                throw new Exception("Please select a file..");
            }
            fleexists=true;
            String fileaddr=addrtxt.getText();
            List xllist=xlobj.readxl(fileaddr.toString());
            dynamodbfunctions dynaobj=new dynamodbfunctions();
            dynaobj.insertItemtodb(accskyidstr,scrtaccskeystr,regionstr,xllist,tblnme);
            infoBox1("Completed inserting items in DB..", "Success",null);
            addrtxt.setText("");
        } catch (Exception ex) {
            if(!fleexists){
                infoBox1(ex.getMessage(), "Error",null);
            }else{
                infoBox1("Error encountered..Please try again..Error is:"+ex.getMessage(), "Error",null);
            }
            Logger.getLogger(appuiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void getcredentials(String accskyid,String seckey,String rgnstr,String tbnme) {
        accskyidstr=accskyid;
        scrtaccskeystr=seckey;
        regionstr=rgnstr;
        tblnme=tbnme;
    }    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
