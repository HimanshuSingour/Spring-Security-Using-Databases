package com.HSSS.Spring.security.SpringSecurity.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .csrf()
                .disable()
                .authorizeHttpRequests()

                .requestMatchers("/check/v1/employee/save")
                .permitAll()

                .requestMatchers("/check/v1/employee/get/id/")
                .hasAuthority("USER")
                
                .requestMatchers("/check/v1/employee/get/all")
                .hasAuthority("ADMIN")

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService getUserDetailsService(){
        return new CustomUserDetailsService();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(getUserDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

}









//      @Bean
//      public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
////
////          UserDetails user1 = User.withUsername("himanshu")
////                  .password(passwordEncoder.encode("muskan"))
////                  .roles("ADMIN")
////                  .build();
////
////
////          return new InMemoryUserDetailsManager(user1 );
//
//          return new CustomUserDetailService();
//      }
