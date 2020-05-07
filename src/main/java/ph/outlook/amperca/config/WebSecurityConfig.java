package ph.outlook.amperca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/**").hasRole("ADMIN")
            .anyRequest()
            .authenticated()
            //.and().formLogin().loginPage("/login");
            .and().formLogin().loginPage("/login").permitAll();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        // TODO Auto-generated method stub
        UserDetails amperca = User.builder().
                            username("amperca").
                            password(passwordEncouEncoder().encode("password")).
                            roles("VOTER").build();
        UserDetails joy = User.builder().
                username("amperca").
                password(passwordEncouEncoder().encode("password")).
                roles("VOTER").build();
        UserDetails admin = User.builder().
                                username("admin").
                                password(passwordEncouEncoder().encode("password")).
                                roles("ADMIN").build();
        return new InMemoryUserDetailsManager(amperca, admin, joy);
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
      return authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncouEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/**/*.html", "/**/*.css", "/**/*.js",
          "/**/*.{png,jpg,jpeg,svg.ico}");

    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
      return new BCryptPasswordEncoder();
    }
}
