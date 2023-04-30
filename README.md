# KAIBURR
Task - 1 

LOCAL SETUP

1. Install Maven, Java and JDK17.
2. Install MongoDb.
3. Run MongoDb on port 27017

ENDPOINTS

1. GET SERVER BY ID
URL- localhost:8080/servers?id=11(id as query param)
Sample Response-  
[
{
"id": "11",
"name": "my centos",
"language": "java",
"framework": "spring boot"
}
]

2. POST SERVER
URL- localhost:8080/id(id as path param)
Sample Body-
   {
   "name":"my centos",
   "id": "11",
   "language": "java",
   "framework": "spring boot"
   }
Sample Response-
   {
   "name":"my centos",
   "id": "11",
   "language": "java",
   "framework": "spring boot"
   }

3. DELETE SERVER
URL- localhost:8080/servers/id(id as path param)

4. GET BY NAME
URL- localhost:8080/servers/search?name=my centos(name as query param)
   [
   {
   "id": "11",
   "name": "my centos",
   "language": "java",
   "framework": "spring boot"
   }
   ]
