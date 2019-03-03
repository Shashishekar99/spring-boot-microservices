# JDK JRE
FROM java:8
EXPOSE 9000:9000
# copy JAR into image
ADD target/authentication-service.jar authentication-service.jar
# run application with this command line 
ENV JAVA_OPTS=""
ENTRYPOINT [ "/bin/sh", "-c", "java -jar authentication-service.jar" ]
