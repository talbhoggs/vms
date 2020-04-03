package ph.outlook.amperca.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
   
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http
            .authorizeRequests()
            .antMatchers("/api/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and().formLogin().loginPage("/login");
    }
    
    @Override
    protected UserDetailsService userDetailsService() {
        // TODO Auto-generated method stub
        
        UserDetails amperca = User.builder().username("amperca").password("passord").roles("VOTER").build();
        
        
        return new InMemoryUserDetailsManager(amperca);
    }

}
