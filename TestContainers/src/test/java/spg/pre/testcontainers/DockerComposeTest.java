package spg.pre.testcontainers;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.DockerComposeContainer;

import java.io.File;

@SpringBootTest
public class DockerComposeTest {

    @ClassRule
    public static DockerComposeContainer environment =
            new DockerComposeContainer(new File("C:\\Users\\Zeljko Predjeskovic\\Desktop\\PosJava\\Predjeskovic_Microservice\\docker-compose.yml"));

    @Test
    public void AssertVerifyExists(){
        boolean erg = environment.getServiceHost("service-registry",8761)=="localhost";

        Assertions.assertTrue(erg);

    }

}
