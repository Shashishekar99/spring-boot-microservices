# JDK JRE
FROM java:8
EXPOSE 8761:8761
# copy JAR into image
ADD target/discovery-service.jar discovery-service.jar
# run application with this command line 
ENV JAVA_OPTS=""
ENTRYPOINT [ "/bin/sh", "-c", "java -jar discovery-service.jar" ]
