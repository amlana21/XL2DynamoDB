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
import com.amazonaws.services.dynamodbv2.document.Item;
import java.util.List;

/**
 *
 * @author amlan
 */
public class dynamodbfunctions {
    public void insertItemtodb(String acckeystr,String seckeystr,List inparry) throws Exception{
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
        
        
        //------------------get column names-------
        
        
        AmazonDynamoDB dynamoDB;
        dynamoDB = AmazonDynamoDBClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .withRegion("us-east-1")
            .build();
        int n=0;
        Item item = new Item().withPrimaryKey("id", 120);
        item.withString("name", "Book 120 Title");
        
    }
}
