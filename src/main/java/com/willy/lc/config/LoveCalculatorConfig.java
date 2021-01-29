package com.willy.lc.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.willy.lc.formatter.PhoneNumberFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.willy.lc.controllers, com.willy.lc.api",
		"com.willy.lc.Validator, com.willy.lc.service" })
@PropertySource("classpath:email.properties")
public class LoveCalculatorConfig implements WebMvcConfigurer {

	@Autowired
	private org.springframework.core.env.Environment env;

	@Bean // this is the view resolver
	InternalResourceViewResolver ViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages"); // this is the name of the properties file "messagers.properties in java
												// resource folder

		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());

		return localValidatorFactoryBean;
	}

	@Bean
	public JavaMailSender getJavaMailSender() {

		System.out.println(env.getProperty("mail.host"));

		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(env.getProperty("mail.host"));
		javaMailSenderImpl.setUsername(env.getProperty("mail.userName"));
		javaMailSenderImpl.setPassword(env.getProperty("mail.password"));

		// 2 ways to do this
//		javaMailSenderImpl.setPort(Integer.parseInt(env.getProperty("mail.port")));
		javaMailSenderImpl.setPort(getIntProperty("mail.port"));

		// this needs to be used for GMAIL since security is tight.
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		javaMailSenderImpl.setJavaMailProperties(mailProperties);

		return javaMailSenderImpl;

	}

	public int getIntProperty(String key) {

		String property = env.getProperty(key);

		return Integer.parseInt(property);
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {

		System.out.println("inside addFormters method");
		registry.addFormatter(new PhoneNumberFormatter());
	}

//	@Override
//	public Validator getValidator() {
//
//		return validator();
//	}

}
