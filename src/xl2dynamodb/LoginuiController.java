/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xl2dynamodb;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author amlan
 */
public class LoginuiController implements Initializable {

    //tempcntrl=
    @FXML
    private TextField accskyidtxt;
     @FXML
    private TextField scaccskytxt;
    // @FXML  
    //private TextField regiontxt;
     @FXML
    private ChoiceBox regionchoice;
     
     @FXML  
    private TextField tblname;
     
    @FXML
    private Button loginawsbtn;
    
    @FXML
    private void loginbtnaction(ActionEvent event){
        
        String homedir=System.getProperty("user.path");
        
        Stage stage = new Stage();
        FXMLLoader nxtloader=new FXMLLoader();
        boolean lgnchk=false;
        boolean valdns=false;
        try {
            
            //-----------------------validations------------
            
        if(accskyidtxt.getText() == null || accskyidtxt.getText().trim().isEmpty()){
            throw new Exception("Access Key ID Mandatory");
        }
        if(scaccskytxt.getText() == null || scaccskytxt.getText().trim().isEmpty()){
            throw new Exception("Secret Access Key is Mandatory");
        }
        if(regionchoice.getSelectionModel().getSelectedItem() == null){
            throw new Exception("Region is Mandatory");
        }
        if(tblname.getText() == null || tblname.getText().trim().isEmpty()){
            throw new Exception("Table Name is Mandatory");
        }
        valdns=true;
        //-----------------------validations------------
            
            
            
            Parent root = nxtloader.load(getClass().getResource("appui.fxml").openStream());
            appuiController appcntrlr=(appuiController)nxtloader.getController();
            //----------check login----------
            
            lgnchk=chklogin(accskyidtxt.getText(),scaccskytxt.getText(),regionchoice.getSelectionModel().getSelectedItem().toString(),tblname.getText());
            
            //----------check login------
            if(lgnchk){
            appcntrlr.getcredentials(accskyidtxt.getText(),scaccskytxt.getText(),regionchoice.getSelectionModel().getSelectedItem().toString());
            Scene scene = new Scene(root);  
            stage.setScene(scene);
        stage.show();
        //((event.getSource())).getScene().getWindow().hide();
        getWindow(loginawsbtn).hide();
            }
        } catch (Exception ex) {
            
            if(!valdns){
                infoBox1(ex.getMessage(), "Error",null);
            }else
            if(!lgnchk){
                infoBox1("Invalid Login..Please try again..", "Error",null);
            }
            
            
            
            Logger.getLogger(LoginuiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        //--------------------aws actions working---------------
        /*try{
        //------------------test aws call-----------
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAJSLUEWDCVJD6BTLQ", "rH4D7vHzRNG3BHYXXazcMjB8qyqk51ClcgBosYEx");
       AmazonDynamoDB dynamoDB;
        dynamoDB = AmazonDynamoDBClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .withRegion("us-east-1")
            .build();
// Describe our new table
            DescribeTableRequest describeTableRequest = new DescribeTableRequest().withTableName("codeaccess");
            TableDescription tableDescription = dynamoDB.describeTable(describeTableRequest).getTable();
            System.out.println("Table Description: " + tableDescription);
        //------------------test aws call-----------
        
        //----------------------test put item-----------------
        DynamoDB dynamoDBtble = new DynamoDB(dynamoDB);
        Table table = dynamoDBtble.getTable("codeaccess");
        Item item = new Item().withPrimaryKey("id", 120);
        item.withString("name", "Book 120 Title99");
                item.withString("status", "120-99");
                item.withString("type", "type_991");
            table.putItem(item);
         //----------------------test put item-----------------
        }
        catch (Exception ex1) {
            
            System.out.println(ex1.getMessage());
        }*/
        
        //--------------------aws actions working---------------
        
        
        /*Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("appui.fxml"));
            Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        //((event.getSource())).getScene().getWindow().hide();
        getWindow(loginawsbtn).hide();
        } catch (IOException ex) {
            Logger.getLogger(LoginuiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        
        String n="";
    }
    
    private boolean chklogin(String accskyid,String scaccsky,String rgn,String tblnme) throws Exception{
        boolean otpt=false;
         BasicAWSCredentials awsCreds1 = new BasicAWSCredentials(accskyid,scaccsky);
         AmazonDynamoDB dynamoDB1;
        dynamoDB1 = AmazonDynamoDBClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds1))
            .withRegion(rgn)
            .build();
        DescribeTableRequest describeTableRequest = new DescribeTableRequest().withTableName(tblnme);
            TableDescription tableDescription1 = dynamoDB1.describeTable(describeTableRequest).getTable();
            otpt=true;
        return otpt;
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
