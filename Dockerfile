FROM java:8
VOLUME /tmp
COPY target/yunzhang-0.0.1-SNAPSHOT.jar yunzhang.jar
RUN bash -c "touch /demo.jar"
EXPOSE 8085
ENTRYPOINT ["java","-jar","yunzhang.jar"] 
