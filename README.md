This project includes Spring Web MVC containerized with Docker and ReactJS bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## ReactJS Development
development directory: /react-unity

'npm run-script build' is scripted to build and auto deploy to webapps/WEB-INF directory of spring application
package.json.homepage variable is set to: "/". This sets all relative files imported within react js app to start with "/"
package.json.proxy variable is set to: "http://localhost"

Refer to react-unity README file for more command information

## Spring Development

### 'docker-compose up'

Launches and runs the environment necessary to launch the spring application using docker

This launches Nginx, Maven, Tomcat, and Sybase into individual containers within thier own composed environment

## Production Deployment

When deploying for production, a production build of react is built then moved into the webapps/WEB-INF directory within the spring application 
Maven then compiles the spring application into a war file which is then deployed within wildfly

'npm run-script build'
'maven clean package'

Resulting war file name: unity

# Sepcifications
JVM Version: OpenJDK 11