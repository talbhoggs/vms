package ph.outlook.amperca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
        http
            .authorizeRequests()
            .antMatchers("/")
            .permitAll()
            .anyRequest()
            .authenticated()
            //.and().formLogin().loginPage("/login");
            .and().httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        // TODO Auto-generated method stub
        UserDetails amperca = User.builder().
                            username("amperca").
                            password(passwordEncouEncoder().encode("password")).
                            roles("VOTER").build();
        UserDetails admin = User.builder().
                                username("admin").
                                password(passwordEncouEncoder().encode("password")).
                                roles("ADMIN").build();
        return new InMemoryUserDetailsManager(amperca, admin);
    }

    @Bean
    public PasswordEncoder passwordEncouEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
