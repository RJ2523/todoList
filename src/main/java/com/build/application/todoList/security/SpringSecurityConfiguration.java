package com.build.application.todoList.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
    

    private UserDetails createNewUser(String username, String password){
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).
                                            username(username).password(password)
                                            .roles("USER", "ADMIN").build();
        // UserDetails userDetails = User.withDefaultPasswordEncoder()
        //                             .username("admin").password("admin")
        //                             .roles("USER", "ADMIN").build();
        return userDetails;
    }
    @Bean
    public InMemoryUserDetailsManager createUserDetails(){
        
        UserDetails userDetails = createNewUser("admin", "admin");
        UserDetails userDetails2 = createNewUser("giza", "admin");

        return new InMemoryUserDetailsManager(userDetails, userDetails2);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(auth->
            auth.anyRequest().authenticated());
        httpSecurity.formLogin(withDefaults());
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
        return httpSecurity.build();  
    }
}
