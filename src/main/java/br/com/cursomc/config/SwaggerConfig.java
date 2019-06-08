package br.com.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.cursomc"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.metaInfo().build());
       
    }

  
	private ApiInfoBuilder metaInfo() {

		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		 
		apiInfoBuilder.title("API's AutoDDr");
		apiInfoBuilder.description("API's AutoDDr");
		apiInfoBuilder.license("Licença - Landmark");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.licenseUrl("https://www.halliburton.com/en-US/default.html");
		apiInfoBuilder.contact(this.contato());
 
		return apiInfoBuilder;
    }
	
	private Contact contato() {
		 
		return new Contact(
				"Landmark",
				null,null);
	}
	
	
}
