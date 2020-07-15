# springboot-swagger

  Depdendencies:

    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
        <version>2.9.2</version>
    </dependency>

    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.9.2</version>
    </dependency>
    

  Configuration:
  
    @Configuration
    @EnableSwagger2
    public class SwaggerConfig {

      @Bean
        public Docket api() { 
            return new Docket(DocumentationType.SWAGGER_2)  
              .select()                                  
              //.apis(RequestHandlerSelectors.any())
              .apis(RequestHandlerSelectors.basePackage("demo.springboot.swagger.employee"))
              .paths(PathSelectors.any())                          
              .build().apiInfo(getApiInfo());

        }
        ...
  }
  
  URL to check:
    
    /v2/api-docs
    /swagger-ui.html

> Reference:
  https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
