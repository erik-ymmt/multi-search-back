FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/multi-search-back-0.0.1-SNAPSHOT.jar multi-search-back.jar
COPY src/main/java/com/dev/multi_search_back/data src/main/java/com/dev/multi_search_back/data
EXPOSE 8080
ENTRYPOINT ["java","-jar","/multi-search-back.jar"]