package mc.shane.library.init

import mc.shane.library.data.BookRowMapper
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages="mc.shane.library")
class Application {
	static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(new DriverManagerDataSource(
			driverClassName:"org.postgresql.Driver",
			url:"jdbc:postgresql://localhost:5432/library",
			username:"library_admin",
			password:"12345"
			)
		);
	}

	@Bean
	public BookRowMapper bookRowMapper() {
		return new BookRowMapper();
	}
	
	@Bean 
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		return new RequestMappingHandlerAdapter(
			messageConverters:[new MappingJackson2HttpMessageConverter()]	
		)
	}
}
