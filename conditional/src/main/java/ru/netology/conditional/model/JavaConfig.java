package ru.netology.conditional.model;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties("dev")
public class JavaConfig {
 
   
   @Bean
   @ConditionalOnProperty(
           prefix = "netology.profile",
           name = "dev",
           havingValue = "true"
   )
    public SystemProfile devProfile() {
        return new DevProfile();
    }
    
    @Bean
    @ConditionalOnProperty(
            prefix = "netology.profile",
            name = "dev",
            havingValue = "false"
    )
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
    
}
