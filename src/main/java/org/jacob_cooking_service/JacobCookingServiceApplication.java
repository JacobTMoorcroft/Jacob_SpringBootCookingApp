package org.jacob_cooking_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class JacobCookingServiceApplication {


	@Bean
	public CommonsRequestLoggingFilter logger(){
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludeHeaders(true);
		filter.setIncludePayload(true);
		filter.setIncludeClientInfo(true);
		filter.setIncludeQueryString(true);

		return filter;
	}

	public static void main(String[] args) {
		SpringApplication.run(JacobCookingServiceApplication.class, args);
	}

}
