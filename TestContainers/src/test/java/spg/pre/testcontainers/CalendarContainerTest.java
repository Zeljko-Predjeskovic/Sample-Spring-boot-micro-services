package spg.pre.testcontainers;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.builder.ImageFromDockerfile;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
public class CalendarContainerTest {

    @ClassRule
    public static GenericContainer<?> calendarContainer =
            new GenericContainer(
                    new ImageFromDockerfile()
                            .withDockerfileFromBuilder(builder ->
                                    builder
                                            .from("tomcat:9.0.55-jdk17-corretto")
                                            .add("C:\\Users\\Zeljko Predjeskovic\\Desktop\\PosJava\\Predjeskovic_Microservice\\Pre" +
                                                    "djeskovic_Microservice_Calendar\\target\\Predjeskovic_Microservice_Calendar-1.0-SNAPSHOT.war",
                                                    "./webapps")
                                            .cmd("./bin/catalina.sh","run")
                                            .build()))
                    .withExposedPorts(8080);

    @Test
    public void AssertContainerExists(){
        Assertions.assertTrue(calendarContainer.isCreated() && calendarContainer.isRunning());
    }
}
