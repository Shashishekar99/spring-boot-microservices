# JDK JRE
FROM java:8
EXPOSE 9002:9002
# copy JAR into image
ADD target/user-service.jar user-service.jar
# run application with this command line 
ENV JAVA_OPTS=""
ENTRYPOINT [ "/bin/sh", "-c", "java -jar user-service.jar" ]
