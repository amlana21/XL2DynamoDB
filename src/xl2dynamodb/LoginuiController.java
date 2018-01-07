/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xl2dynamodb;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author amlan
 */
public class LoginuiController implements Initializable {

    
    @FXML
    private TextField accskyidtxt;
     @FXML
    private TextField scaccskytxt;
     @FXML
    private TextField regiontxt;
     
     
    @FXML
    private Button loginawsbtn;
    
    @FXML
    private void loginbtnaction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("appui.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        //((event.getSource())).getScene().getWindow().hide();
        getWindow(loginawsbtn).hide();
        
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
