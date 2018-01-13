<b>Introduction:</b>

XL2Dynamodb enables user to directly load data into AWS DynamoDB from a local excel file. This JAVAFX application simply reads the excel file and creates the rows from the excel file as items in an existing DynamoDB table.

<b>Built With:</b>
-	JAVA 8
-	JAVA FX 8
-	AWS DynamoDB


<b>Libraries Used:</b>
-	Apache POI (under APACHE LICENSE, VERSION 2.0)
-	Apache Commons (under APACHE LICENSE, VERSION 2.0)
-	AWS SDK(under APACHE LICENSE, VERSION 2.0)


<b>Prerequisites:</b>
-	JAVA 8 installed



<b>Get the Source Code:</b>

To get the source code, clone the GIT repository or download the files from above location.





<b>Run the Application:</b>
1.	Download and unzip the Exec.zip to a local folder
2.	Run the JAR file in your system
3.	Enter these below required info in login window:
a.	Secret Access Key
b.	Access Key ID
c.	Region
d.	Table Name
 
4.	Click on Login. If the above details are correct, it will take you to the next file select window. If error, a popup will be shown
5.	In the next window, browse and select the excel data file to be loaded
 
6.	Click on Submit to start the import of data
7.	A final popup shows the data import completion. Any errors are shown as popup


<b>Data File format:</b>
A sample data file format has been attached in repository. The sample file contains instructions in the first tab and a sample data in 2nd tab. The actual data file should only contain a single tab with the data.

 
<b>Points to Note:</b>
-	This works only if the table exists in DynamoDB. It does not create the table
-	Currently it only supports Number and String data in the file. Specify the type based on instructions in the file


<b>Questions and Issues:</b>

Please reach out to me at amlana21@gmail.com for any questions and issues. Feel free to use the source and modify as seen fit.
