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
    private void loginbtnaction(ActionEvent event){
        
        String homedir=System.getProperty("user.home");
        try{
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
        Item item = new Item().withPrimaryKey("id", 120)
                .withString("name", "Book 120 Title")
                .withString("status", "120-1111111111")
                .withString("type", "type_code1")
                ;
            table.putItem(item);
         //----------------------test put item-----------------
        }
        catch (Exception ex1) {
            
            System.out.println(ex1.getMessage());
        }
        /*
        Parent root = FXMLLoader.load(getClass().getResource("appui.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        //((event.getSource())).getScene().getWindow().hide();
        getWindow(loginawsbtn).hide();
        */
        String n="";
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
