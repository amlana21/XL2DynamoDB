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
import java.util.List;

/**
 *
 * @author amlan
 */
public class dynamodbfunctions {
    public void insertItemtodb(String acckeystr,String seckeystr,String rgnstr,List inparry) throws Exception{
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(acckeystr,seckeystr);
        /*
        //--------------------aws actions working---------------
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
        Item item = new Item().withPrimaryKey("id", 120);
        item.withString("name", "Book 120 Title99");
                item.withString("status", "120-99");
                item.withString("type", "type_991");
            table.putItem(item);
         //----------------------test put item-----------------
        }
        catch (Exception ex1) {
            
            System.out.println(ex1.getMessage());
        }
        
        //--------------------aws actions working---------------
        
        
        */
        
        //------------------get column names-------
        int arrcnt=0;
        //Object[] arr1=inparry[arrcnt];
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
            //.withRegion("us-east-1")
              .withRegion(rgnstr)
            .build();
        DynamoDB dynamoDBtble = new DynamoDB(dynamoDB);
        Table table = dynamoDBtble.getTable("codeaccess");
        while(arrcnt<inparry.size()){
            int colcnt=0;
            Object[] rw=(Object[])inparry.get(arrcnt);
            Double id1=(Double)rw[0];
            int rwid=id1.intValue();
            Item item = new Item().withPrimaryKey(arr1[0].toString(), rwid);
          colcnt=colcnt+1;
          while(colcnt<rw.length){
              String cnme=arr1[colcnt].toString();
              //String cvlue= rw[colcnt].toString();
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
        
        /*AmazonDynamoDB dynamoDB;
        dynamoDB = AmazonDynamoDBClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .withRegion("us-east-1")
            .build();
        int n=0;
        Item item = new Item().withPrimaryKey("id", 120);
        item.withString("name", "Book 120 Title");*/
        
    }
}
