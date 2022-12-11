# RestAPISpringBootWithDynamoDb
###Setup:
- Spring Data DynamoDB Version: 5.1.0 (2.1)
- Spring Data Version:          2.1.15.RELEASE
- AWS SDK Version:              1.12.353
- Java Version:                 11.0.15
- Bundled Maven Version:        3.8.1

NoSQL workbench:
https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/workbench.html

Launch local dynamodb: 
https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html#DynamoDBLocal.DownloadingAndRunning.title
- `cd /Users/atkins95/dynamodb_local_latest`
- `java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb`

###Features:
- A REST API built using spring boot with a local running instance of dynamodb serving as the endpoint. 