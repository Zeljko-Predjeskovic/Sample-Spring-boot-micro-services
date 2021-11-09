package spg.pre.microservices.musicmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PredjeskovicMicroserviceMusicManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PredjeskovicMicroserviceMusicManagerApplication.class, args);
    }

}
