package com.zhangyingwei.solid.springboot.demo;

import com.github.zhangyingwei.solid.config.FileTemplateResourceLoader;
import com.github.zhangyingwei.solid.config.SolidConfiguration;
import com.github.zhangyingwei.solid.spring.SprintSolidTemplateResolver;
import com.github.zhangyingwei.solid.template.TemplateResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean(name = "solidConfiguration")
    public SolidConfiguration templateBuilder(ApplicationContext ctx) {
        SolidConfiguration configuration = new SolidConfiguration(
                new FileTemplateResourceLoader("src/main/resources/templates/tale")
        );
        return configuration;
    }

    @Bean
    public SprintSolidTemplateResolver getViewResolver(@Qualifier("solidConfiguration") SolidConfiguration configuration) {
        TemplateResolver templateResolver = new TemplateResolver(configuration);
        templateResolver.setSuffix(".html");
//        templateResolver.setPrefix("templates/tale");
        return new SprintSolidTemplateResolver(templateResolver);
    }
}