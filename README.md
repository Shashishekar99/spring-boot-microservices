# spring-boot-microservices

1. Docker sample.
2. Eureka client and server.
3. Sample Authentication Service and UserService, with (in mem cache)
4. API calls using WebClient - (spring boot resttemplate is going to be deprecated so).


Some Docker commands

docker image deletion--

----> docker rmi -f <fd484f19954f/Image id>

to view docker images 

----> docker images 

to view docker info 

----> docker info

to view version docker 

----> docker version

to build image file 

----> docker build -f <Dockerfile> -t <tag name any name> .

to run docker 

----> docker run -p 8080:8080 <image name>

to view list of docker container 
----> docker container ls

to stop docker 

-----> docker stop <image id>

to pull image from repositories

-----> docker pull <account_name>/dockertest:firsttry

to push docker to repositories

-----> docker tag bb38976d03cf <account_name>/dockertest:firsttry
-----> docker push <account_name>/dockertest:firsttry

To save a Docker image after you have pulled, 
committed or built it you use the docker save command. 
For example, lets save a local copy of the verse_gapminder docker image we made:

----->docker save dockertest > dockertest.tar

If we want to load that Docker container from the archived tar file in the future, we can use the docker load command:

-----> docker load --input dockertest.tar

url ref ---> https://ropenscilabs.github.io/r-docker-tutorial/04-Dockerhub.html
