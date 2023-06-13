package org.mnotario.angular;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
 
/**
 * @author Marcos Notario, Feliz Perez, Miroslav Zhelev
 */
/**
 * La clase EventifyApp es la clase principal de la aplicacion Spring Boot. Contiene el metodo main que inicia la aplicacion.
 * Ademas, la clase define un bean corsFilter() que configura un filtro CORS para permitir solicitudes cruzadas entre dominios. 
 * El filtro se configura para permitir solicitudes desde http://localhost:4200 y se definen los encabezados y metodos permitidos.
 */
@SpringBootApplication
public class EventifyApp {
	
	/**
	* Punto de entrada de la aplicación EventifyApp.
	* @param args Los argumentos de la línea de comandos.
	*/
	public static void main(String[] args) {
		SpringApplication.run(EventifyApp.class, args);
	}


    /**
     * Configura un filtro CORS para permitir solicitudes cruzadas entre dominios.
     * @return CorsFilter - El filtro CORS configurado.
     */
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
