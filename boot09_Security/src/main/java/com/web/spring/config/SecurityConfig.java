package com.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class SecurityConfig {

	//인증관련 설정은 ...SecurityFilterChain
	//SecurityFilterChain을 빈으로 지정... 
	//members/... 인증여부
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		//여기다가 http 요청에 대한 인증과 권한관련 인증관련된 인가정책을 등록..7버전 부터는 모든 코드를 람다형식으로 작성하도록 규정...
		http
			.authorizeHttpRequests(auth->auth.anyRequest().authenticated())//어떤 요청에도 인증을 받겠다.
			.formLogin(Customizer.withDefaults());//디폴트 방식인 로그인 폼으로 인증 받겠다.
		return http.build();
		
	}
	
	//UserDetailsService빈을 등록하고.. 디비 연결했다 치고.. id,password 정보를 InMemory하겠다.
	//properties설정파일에도 User정보를 등록했다.. 우선 순위가 높은 것은  UserDetailsService이다.
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("security")
								.password("{noop}7777")
								.roles("USER").build();
		
		
		return new InMemoryUserDetailsManager(user);
		
	}
}
