package com.yuewan.paper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
@MapperScan("com.yuewan.paper.mapper")
public class PaperApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaperApplication.class, args);
	}

}
