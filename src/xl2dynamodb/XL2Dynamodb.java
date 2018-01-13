/**
 *@fileoverview Main class
 * @author amlan
 */
package xl2dynamodb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author amlan
 */
public class XL2Dynamodb extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("loginui.fxml"));
        stage.resizableProperty().setValue(Boolean.FALSE);
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
