## Project Name & Pitch
Team-GA-Redback

This is a software project of subject COMP90082 at The University of Melbourne. Through this project, a user with a Garmin watch can receive a workout via the CoachingMate platform. When they complete their workout, they are able to send the data from the watch to the Dashboard for viewing by themselves and their coach. In this project, our team mainly has two tasks: the frontend part and the backend part.

The backend part synchronic the data from Garmin Connect, retrieving data reflecting the status of athlete daily life, built with Springboot framework. Our main task is responsible for fixing the old version bug, as well as integrating more features into existing code. Data collected in Garmin Connect is acquired through Garmin wearable. Data will be displayed on the frontend part.

The frontend part is mainly about the development of the dashboard. We need to design better user interfaces based on human-computer interaction theory. Visualize the data collected by the backend and present them to the user.

## Project Status

This project is currently in development.
1. user is able to create an account, synchronizing the data retrieve from Garmin connect.
2. user’s data saved in the MongoDB database in a standard way, which is convenient for future development.
3. user can view all his activity data, under viewing of the list.
4. completely fix the bug of the old version
5. data collected by the backend has been visualised.

## Backend:
## Backend Project structure
The backend built with Springboot framework, it including following function
Garmin Part
1) synchronic data from garmin connect
2) store in mongodb database

Web part
1) Connect user with garmin connect
2) Store user info in mongodb database
3) Giving user visulization on his exercise history

### Components diagram:

<img width="545" alt="Screen Shot 2022-04-26 at 14 44 56" src="https://user-images.githubusercontent.com/39297807/170637351-246450ea-a90f-42a9-b0df-415c83ef31c7.png">


### Spring structure:

![image](https://user-images.githubusercontent.com/39297807/164958759-e5c0b907-d2b2-470f-b15f-60d63b4ca117.png)


The project adopts the development mode of sub-modules according to functions, and the structure is as follows
*	coachingmateanalytics.coachingmate.controller: Front controller layer
*	coachingmateanalytics.coachingmate.entity: Data entity class
*	coachingmateanalytics.coachingmate.dao : Data interface access layer
*	coachingmateanalytics.coachingmate.service : Data service interface layer
*	coachingmateanalytics.coachingmate.service.serviceImpl : Data service interface implementation layer
*	coachingmateanalytics.coachingmate.utils : Tool library
*	coachingmateanalytics.coachingmate.intercepter : used to set the response header for all request
*	resources/application.yml : Project profile resources/static/ : Static resource directory

## Backend Database structure

All project data store in cloud mogodb(please adjust to your own mogodb cloud account), which has multiple collections:
User profile aspect(<type> org.bson.Document)
*	requestToken: entity/RequestToken
*	user: entity/RequestToken

 User data aspect (<type> org.bson.Document)
*	epho: controller/GarminPushController/saveEpoch
*	activity: controller/GarminPushController/saveActivity
*	activityDetails: controller/GarminPushController/ saveActivityDetails
 
![image](https://user-images.githubusercontent.com/39297807/164958386-b93b837a-8c71-4c09-830e-bfa54a089840.png)

##  Development Environment Instructions
#### 1. Install IDEA from this [location](https://www.jetbrains.com/idea/).

#### 2. Install maven from this [location](https://maven.apache.org/download.cgi).
Reference blog: 
https://toolsqa.com/maven/how-to-install-maven-on-windows/

#### 3. Install Mongodb from this [location](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-os-x/).
Reference blog: 
https://medium.com/@LondonAppBrewery/how-to-download-install-mongodb-on-windows-4ee4b3493514

#### 4. Install git version control in IDEA
Reference video:
https://www.youtube.com/watch?v=mM_drNdss4c

## Installation and Setup Instructions

### 1. install JDK
[Official tutorial for JDK installation](https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-macos.htm#JSJIG-GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE)

### 2. install maven
[Official tutorial for Maven installation](http://maven.apache.org/install.html)<br>
take mac os for example
- download 	apache-maven-3.6.3-bin.tar.gz
- tar xzvf apache-maven-3.6.3-bin.tar.gz
 * Alternatively use your preferred archive extraction tool.
 * Add the bin directory of the created directory apache-maven-3.6.3 to the PATH environment variable
 * Confirm with mvn -v in a new shell. The result should look similar to
```
Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: /opt/apache-maven-3.6.3
Java version: 1.8.0_45, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.8.5", arch: "x86_64", family: "mac"
```
### 3. install MongoDB
[Official tutorial for mongoDB installation](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-os-x/)

```
brew install mongodb-community@4.4
```

### 4. install git environment
- linux install
```
yum install git
```
- mac install
```
brew install git
```
- Before you can use Git for version management, you need to configure Git by telling git your **username** and your **email account**
```
//configuration
[root@localhost ~]# git config --global user.name flymegoc
[root@localhost ~]# git config --global user.email 343672271@qq.com

//Check the configuration
[root@localhost ~]# git config --list
user.name=flymegoc
user.email=343672271@qq.com
```

### 5. Run this project locally
Clone down this repository. You will need `maven` and `JDK1.8` installed globally on your machine.  

`git clone https://github.com/COMP90082SM12022/GA-Redback`

Modify configuration file:
[application-dev.properties](https://github.com/agogear/coaching-mate/blob/master/src/main/resources/application-dev.properties)

1. create your mongodb database with {database name} manually on your local environment
```
spring.data.mongodb.database={database name}
spring.data.mongodb.port=27017
```
2. export data from cloud database:
[cloud mongodb database](mongodb+srv://admin:unimelb0121@cluster0.2qpx8.mongodb.net/coachingMate?retryWrites=true&w=majority)
3. import data to your local mongodb database


Installation:

`cd coachingmate` <br>
`mvn install`  

To Start Server:

`java -jar ./target/coachingmate-0.0.1-SNAPSHOT.jar`  

To login App:

`localhost:8080/login?username={username}&password={password}` 
 
## Deployment guidelines
#### There are three places’s variable should be replaced by yours
* MongoDB
* Garmin app api
* Garmin app api portal

### MongoDB: 
#### Using gmail account create a free cloud space, and Replace the url.
#### 1. 
![image](https://user-images.githubusercontent.com/39297807/164959299-042b1a32-c7fd-452c-803f-911607080778.png)
#### 2.
![image](https://user-images.githubusercontent.com/39297807/164959301-a12caad6-3491-4f12-954b-8bea3974c88d.png)
#### 3.
![image](https://user-images.githubusercontent.com/39297807/164959310-044be9ee-1816-4938-b713-91a1fc460d48.png)
#### 4.
![image](https://user-images.githubusercontent.com/39297807/164959315-0a5196cb-a202-4085-92e2-b526efddeeb0.png)
#### 5.
![image](https://user-images.githubusercontent.com/39297807/164959318-7d4c58ae-b98d-498b-b8b7-54b6753c3bd3.png)
#### 6.Replace the url with your copy one
 ![image](https://user-images.githubusercontent.com/39297807/164959383-e1cbe0b9-c044-4bb4-8bd1-6631f92a5082.png)

 
### Garmin app api: 
#### 1. You need to create a new app in the developer portal of garmin.
https://developerportal.garmin.com/
 ![image](https://user-images.githubusercontent.com/39297807/164959564-9fec2399-93c9-4da5-94a6-650567b3544c.png)
#### 2. Then you need to write down the consumerkey and consumerSececret
![image](https://user-images.githubusercontent.com/39297807/164959578-1aa82c99-1254-4b25-9fc1-cbf4da237120.png)
#### After that process, you own api key and secret. That info should be included in your apps, replaced those vars with yours.
 ![image](https://user-images.githubusercontent.com/39297807/164959592-cc818b90-1212-4c2c-9308-b6b2de7aae2b.png)

 
### Garmin app api portal:
#### You need to upload your project to github, then connect the github repository with heroku.
(Be careful, the Heroku free trial is limited to 500 hours, you can deploy to another groupmate account!!!)
#### 1. create a new application on heroku
![image](https://user-images.githubusercontent.com/39297807/164959624-0c1bc5a6-0187-4692-9065-a8385bd49d24.png)
#### 2. text our app name and region
 ![image](https://user-images.githubusercontent.com/39297807/164959631-bc20db40-7ecb-44d4-9d5b-ab520f979391.png)
#### 3. fork this repository to your own repository
#### 4. Select Github and find this forked project in your own repository
![image](https://user-images.githubusercontent.com/39297807/164959637-f8e35982-0d85-4b2c-a402-9351f27396d5.png)
#### 5. connect successfully
 ![image](https://user-images.githubusercontent.com/39297807/164959642-430d4d6b-a4d5-42ff-834b-25ff32e888b7.png)
#### 6. find our app and click the Open app button
 ![image](https://user-images.githubusercontent.com/39297807/164959652-10a31d28-2b9b-4d7c-8866-232574dd7710.png)
#### 7. find our URL in the build log
 ![image](https://user-images.githubusercontent.com/39297807/164959657-ffad70d1-88fb-4c98-83bd-a2f0fccb0a7a.png)
#### Finally, replace the garmin developer url as the heroku app + path
![image](https://user-images.githubusercontent.com/39297807/164959664-14cd3a3c-4799-413a-a0c0-24d5430ae3ae.png)
![image](https://user-images.githubusercontent.com/39297807/164959668-c42c70c3-e849-4057-981f-31b6b92259f5.png)
![image](https://user-images.githubusercontent.com/39297807/164959671-716a3b04-a7f2-4452-b320-8d9ba93fdd44.png)
![image](https://user-images.githubusercontent.com/39297807/164959673-179c7d58-74d8-4220-a8e0-ef26efdd52b9.png)
![image](https://user-images.githubusercontent.com/39297807/164959674-d7603000-eb00-41e3-906e-923eb5ea4045.png)  
  
&emsp;
&emsp;
## Frontend:
# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).
 
## EditorConfig
 
If you want to change the backend host or the backend host is no longer available, you have to change the URL in the `.env` EditorConfig file. 

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can't go back!**

If you aren't satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you're on your own.

You don't have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn't feel obligated to use this feature. However we understand that this tool wouldn't be useful if you couldn't customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved here: [https://facebook.github.io/create-react-app/docs/code-splitting](https://facebook.github.io/create-react-app/docs/code-splitting)

### Analyzing the Bundle Size

This section has moved here: [https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size](https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size)

### Making a Progressive Web App

This section has moved here: [https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app](https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app)

### Advanced Configuration

This section has moved here: [https://facebook.github.io/create-react-app/docs/advanced-configuration](https://facebook.github.io/create-react-app/docs/advanced-configuration)

### Deployment

This section has moved here: [https://facebook.github.io/create-react-app/docs/deployment](https://facebook.github.io/create-react-app/docs/deployment)

### `npm run build` fails to minify

This section has moved here: [https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify](https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify)
