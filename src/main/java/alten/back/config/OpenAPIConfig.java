package alten.back.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
@SecurityScheme(
	    name = "basicAuth",
	    type = SecuritySchemeType.HTTP,
	    scheme = "basic"
	)
public class OpenAPIConfig {

  private String devUrl = "http://localhost:8080";

  @Bean
  public OpenAPI myOpenAPI() {
    Server server = new Server();
    server.setUrl(devUrl);
    server.setDescription("Server URL in Development environment");

    return new OpenAPI().servers(List.of(server));
  }
}
