# syntax=docker/dockerfile:experimental
FROM openjdk:11 as build
WORKDIR /workspace/app

#copy root files
COPY ../../mvnw .
COPY ../../.mvn .mvn
COPY ../../pom.xml .
#COPY src src

#copy sub modules
#COPY mvnw .
COPY ./core/utils/pom.xml ./core/utils/
COPY ./core/utils/src ./core/utils/src

COPY ./microservices/crm-service/pom.xml ./microservices/crm-service/
COPY ./microservices/crm-service/src ./microservices/crm-service/src




#to cache mvn
RUN --mount=type=cache,target=/root/.m2 ./mvnw clean package
#RUN mvn clean package
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:11
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/microservices/crm-service/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["mvn", "clean", "install" , "java","-cp","app:app/lib/*","com.example.lj.demospringdockermultilayer.DemoSpringDockerMultiLayerApplication"]
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.multimodule.crmservice.App"]