/**
 *@fileoverview Controller file for the select file UI
 * @author amlan
 */

package xl2dynamodb;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import java.util.List;

/**
 *
 * @author amlan
 */
public class dynamodbfunctions {
    public void insertItemtodb(String acckeystr,String seckeystr,String rgnstr,List inparry,String tablnme) throws Exception{
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(acckeystr,seckeystr);
        
        //------------------get column names-------
        int arrcnt=0;
        Object[] arr1=(Object[])inparry.get(arrcnt);
        arrcnt=arrcnt+1;
        //------------------get column names-------
        
        //-----------------get column types-----
        Object[] dtypes=(Object[])inparry.get(arrcnt);
        arrcnt=arrcnt+1;     
        
        //-----------------get column types-----
        
        
        //---------------------update db items-----------------
        AmazonDynamoDB dynamoDB;
        dynamoDB = AmazonDynamoDBClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .withRegion(rgnstr)
            .build();
        DynamoDB dynamoDBtble = new DynamoDB(dynamoDB);
        Table table = dynamoDBtble.getTable(tablnme);
        while(arrcnt<inparry.size()){
            int colcnt=0;
            Object[] rw=(Object[])inparry.get(arrcnt);
            Double id1=(Double)rw[0];
            int rwid=id1.intValue();
            Item item = new Item().withPrimaryKey(arr1[0].toString(), rwid);
          colcnt=colcnt+1;
          while(colcnt<rw.length){
              String cnme=arr1[colcnt].toString();
              if(dtypes[colcnt].toString().equals("S")){
                  String cvlue= rw[colcnt].toString();
                  item.withString(cnme, cvlue);
              }
              else if(dtypes[colcnt].toString().equals("N")){
                  Double cvlue= (Double)rw[colcnt];
                  item.withNumber(cnme, cvlue);
              }
              colcnt=colcnt+1;
          }
            table.putItem(item);
            arrcnt=arrcnt+1;
        }
        
        //---------------------update db items-----------------
        
        
    }
}
