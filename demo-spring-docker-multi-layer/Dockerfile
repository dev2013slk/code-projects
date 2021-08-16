# syntax=docker/dockerfile:experimental
FROM openjdk:11 as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

#to cache mvn
RUN --mount=type=cache,target=/root/.m2 ./mvnw install
#RUN mvn clean package
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:11
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["mvn", "clean", "install" , "java","-cp","app:app/lib/*","com.example.lj.demospringdockermultilayer.DemoSpringDockerMultiLayerApplication"]
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.lj.demospringdockermultilayer.DemoSpringDockerMultiLayerApplication"]