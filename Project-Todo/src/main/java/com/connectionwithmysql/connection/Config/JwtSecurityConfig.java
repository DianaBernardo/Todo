package com.connectionwithmysql.connection.Config;

import com.connectionwithmysql.connection.Security.JwtAuthenticationEntryPoint;
import com.connectionwithmysql.connection.Security.JwtAuthenticationProvider;
import com.connectionwithmysql.connection.Security.JwtAuthenticationTokenFilter;
import com.connectionwithmysql.connection.Security.JwtSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {


  @Autowired
  private JwtAuthenticationProvider authenticationProvider;
  @Autowired
  private JwtAuthenticationEntryPoint entryPoint;

  @Bean
  public AuthenticationManager authenticationManager() {
    return new ProviderManager(Collections.singletonList(authenticationProvider));
  }

  @Bean
  public JwtAuthenticationTokenFilter authenticationTokenFilter() {
    JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
    filter.setAuthenticationManager(authenticationManager());
    filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
    return filter;
  }


  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.csrf().disable()
        .authorizeRequests().antMatchers("/api").authenticated()
        .and()
        .exceptionHandling().authenticationEntryPoint(entryPoint)
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    http.headers().cacheControl();
  }


  //with predefined users
  @Autowired
  public void configureInMemory(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("diana").password("{noop}password").roles("USER");
  }
}