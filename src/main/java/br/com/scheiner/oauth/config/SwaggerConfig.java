package br.com.scheiner.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.In;

@Configuration
public class SwaggerConfig {
	
	private static final String ACCESS_TOKEN_URI = "http://localhost:9090/oauth2/token";

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(
						new Components().addSecuritySchemes("security_auth",
						new SecurityScheme()
			            .in(In.HEADER)
			            .bearerFormat("JWT")
			            .scheme("bearer")
						.type(SecurityScheme.Type.OAUTH2)
						.description("Api OAUTH2")
					    .flows(getOAuthFlows()))
				)
				.info(new Info().title("App API JWT").version("0.0.1"))
				.addSecurityItem(new SecurityRequirement().addList("security_auth"));
	}
	
	private OAuthFlows getOAuthFlows() {
		
		return new OAuthFlows()
				.clientCredentials(
						new OAuthFlow().tokenUrl(ACCESS_TOKEN_URI)
						.scopes(new Scopes()
								.addString("usuarios.read", "ler usuarios")));
		
	}
	
	

}
