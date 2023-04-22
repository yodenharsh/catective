package ai.petthinq.catectivesbackend.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {
	

	public void addCorsMappings(CorsRegistry registry) {
		final long MAX_AGE_SECS = 3600;

		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
				.allowedHeaders("*")
				.maxAge(MAX_AGE_SECS);
	}
}
