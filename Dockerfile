FROM gradle:7.2.0-jdk11
COPY . /periwee
cd periwee
RUN ./gradlew clean build
EXPOSE 8080
#COPY ./build/libs/api-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8080
ENTRYPOINT ["java","-jar","./build/libs/api-0.0.1-SNAPSHOT.jar"]

#FROM gradle:7.2.0-jdk11 AS TEMP_BUILD_IMAGE
#ENV APP_HOME=/usr/app/
#WORKDIR $APP_HOME
#COPY  .gradle.kts $APP_HOME
#
#COPY gradle $APP_HOME/gradle
#COPY --chown=gradle:gradle . /home/gradle/src
#USER root
#RUN chown -R gradle /home/gradle/src
#
#COPY . .
#RUN gradle clean build
#
#FROM openjdk:11
#ENV ARTIFACT_NAME=auth-0.0.1-SNAPSHOT.jar
#ENV APP_HOME=/usr/app/
#COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]