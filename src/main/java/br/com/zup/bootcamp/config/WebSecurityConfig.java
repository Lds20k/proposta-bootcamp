package br.com.zup.bootcamp.config;

import br.com.zup.bootcamp.resource.proposal.ProposalResource;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

// Configurado apenas para aceitar request sem autorização
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequest -> authorizeRequest
                .antMatchers(
                        HttpMethod.GET,
                        "/actuator/**"
                ).permitAll()

                .antMatchers(
                        HttpMethod.GET,
                        "/api/**"
                ).hasAuthority("SCOPE_proposta:read")
                .antMatchers(
                        HttpMethod.POST,
                        "/api/**"
                ).hasAuthority("SCOPE_proposta:write")
                .anyRequest().authenticated()
        ).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }
}
