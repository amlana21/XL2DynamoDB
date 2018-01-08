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
