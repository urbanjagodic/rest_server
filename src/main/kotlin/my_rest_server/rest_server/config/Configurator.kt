package my_rest_server.rest_server.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import java.lang.Exception


@Configuration
class SpringBootSecurityConfiguration : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    public override fun configure(auth: AuthenticationManagerBuilder) {
    }

    @Throws(Exception::class)
    public override fun configure(http: HttpSecurity) {
        http
            .httpBasic().disable()
            .csrf().disable()

//        http
//            .authorizeRequests()
//            .antMatchers("/", "/**").permitAll()
//            .anyRequest().authenticated()
    }
}