# spring-boot-couchbase-with-file

This Project,Spring Boot Couchbase with File Saved


## Installation


- First, open couchbase-setup.sh and configure on your couchbase settings


![couchbase-setup](https://user-images.githubusercontent.com/80245013/135096162-5888c0d8-0190-42b1-a785-bd0fbb46d172.png)



- docker-compose up -d


- Connect localhost:8091 && If you don't have a cluster,Press Start a new cluster


![Couchbase-UI](https://user-images.githubusercontent.com/80245013/135094986-afa110be-6c4a-4e2d-ab8c-05b3bd912975.png)

- Please enter ClusterName(Required bucket name)
- Username:Docker-Compose-Couchbase username
- Password:Docker-Compose-Couchbase password


![Couchbase-Cluster](https://user-images.githubusercontent.com/80245013/135095013-9aefe199-bb74-4b83-80c1-e244587eaccd.png)



- If you are using Couchbase for the first time, check the Finish Default option.


![Couchbase-Terms](https://user-images.githubusercontent.com/80245013/135095546-ce0b0ef2-d5e1-435d-933e-3625297e0f2c.png)




- Click Buckets and Press 'Add Bucket' and Enter Buckets name in application.properties


![Couchbase-Bucket](https://user-images.githubusercontent.com/80245013/135095755-64414c97-8edb-4dc8-8834-cdc4369efaca.png)



- Last Click Query and Create an Index for Your buckets



![Couchbase-Query](https://user-images.githubusercontent.com/80245013/135095909-bea2a5e6-fb3c-4d52-ac9c-734a7816cb62.png)


CREATE INDEX `your-index` ON `Your bucketname`(`_class`)
    WHERE (`_class` = "Your Model Class package.YourModelname")
    (


## Owner
[Muharrem Koç](https://github.com/muharremkoc)

     Java Developer
