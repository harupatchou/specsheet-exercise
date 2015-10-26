package com.example.management.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/js/**", "/css/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/","/flowError").permitAll(); //全ユーザーアクセス可
		http.authorizeRequests().antMatchers("/flowMenu","/spec/registIndex","/detail/","/userRegist/","/userRegist/flowConfirm",
				"/userRegist/create/","/userEdit/","/userEdit/flowConfirm","/userEdit/update").hasAnyRole("USER","ADMIN") //ユーザー・管理者ともにアクセス可
		.antMatchers("/search/","/search/searchSpec","/system/","/system/editLanguage", "/system/editOs").hasRole("ADMIN") //管理者のみアクセス可
		.anyRequest().authenticated();
		http.formLogin().loginProcessingUrl("/login").loginPage("/")
		.failureUrl("/flowError").defaultSuccessUrl("/flowMenu",true).usernameParameter("staffId").passwordParameter("password").and();
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/userLogout")).logoutSuccessUrl("/");
		http.exceptionHandling().accessDeniedPage("/flowErrorPage"); //権限がない場合エラーページへ
		
	}
	
	@Configuration
	static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter{
		@Autowired
		private UserDetailsService userDetailsService;
		
//		@Bean
//		PasswordEncoder passwordEncoder(){
//			return new BCryptPasswordEncoder();
//		}
		
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception{
			auth.userDetailsService(userDetailsService);  //.passwordEncoder(passwordEncoder());
		}
	
	}
}
