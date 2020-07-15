package demo.springboot.swagger.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	// https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          //.apis(RequestHandlerSelectors.any())
          .apis(RequestHandlerSelectors.basePackage("demo.springboot.swagger.employee"))
          .paths(PathSelectors.any())                          
          .build().apiInfo(getApiInfo());
        
    }
	
	@SuppressWarnings("deprecation")
	private ApiInfo getApiInfo() {
		
		Contact contact = new Contact();
		contact.setEmail("email@email.com");
		contact.setName("Testing");
		contact.setUrl("https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api");
		
        return new ApiInfo(
        		"REST API : Spring boot Swagger",
                "Documentation for Others",
                "1.0",
                "Terms of service for using Spring boot with Swagger",
                "email@email.com",
                "License:",
                "https://opensource.org/licenses/MIT"                
        );
    }

}
