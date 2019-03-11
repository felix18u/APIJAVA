FROM openjdk:8
VOLUME /tmp
ADD target/Lebonsandwich-0.0.1-SNAPSHOT.jar Lebonsandwich.jar
RUN bash -c 'touch /restservice.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/Lebonsandwich.jar"]