package be.pxl.huizenjacht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HuizenjachtApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuizenjachtApplication.class, args);
	}

}
