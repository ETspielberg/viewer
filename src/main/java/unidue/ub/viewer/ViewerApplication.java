package unidue.ub.viewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
@EnableEurekaClient
public class ViewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViewerApplication.class, args);
	}

	@Configuration
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.httpBasic()
					.and()
					.authorizeRequests().anyRequest().permitAll()
					.and()
					.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		}
	}
}
