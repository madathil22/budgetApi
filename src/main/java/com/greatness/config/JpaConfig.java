package com.greatness.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditor")
public class JpaConfig {
	
	@Bean
	public AuditorAware<String> auditor(){
		return () -> Optional.ofNullable("tobin");
	}

}
