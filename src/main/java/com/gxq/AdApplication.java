package com.gxq;

import com.gxq.config.EfanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@EnableConfigurationProperties({EfanConfig.class,})

public class AdApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdApplication.class, args);
	}
}
