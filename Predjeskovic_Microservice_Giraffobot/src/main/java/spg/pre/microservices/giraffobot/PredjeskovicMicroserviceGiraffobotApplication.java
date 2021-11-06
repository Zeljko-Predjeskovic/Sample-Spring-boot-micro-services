package spg.pre.microservices.giraffobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PredjeskovicMicroserviceGiraffobotApplication {

	public static void main(String[] args) {
		SpringApplication.run(PredjeskovicMicroserviceGiraffobotApplication.class, args);
	}

}
