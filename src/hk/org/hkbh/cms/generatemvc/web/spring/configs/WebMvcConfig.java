package hk.org.hkbh.cms.generatemvc.web.spring.configs;

import java.util.concurrent.TimeUnit;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.CacheControl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "hk.org.hkbh.cms.generatemvc.web"})
public class WebMvcConfig implements WebMvcConfigurer {
	   @Bean
	   public InternalResourceViewResolver resolver() {
	      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	      resolver.setViewClass(JstlView.class);
	      resolver.setPrefix("/WEB-INF/views/");
	      resolver.setSuffix(".jsp");
	      return resolver;
	   }
	    @Override
	    public void addResourceHandlers( ResourceHandlerRegistry registry )
	    {
	        // Register resource handler for CSS and JS
//	        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/", "/css/")
//	              .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	        // Register resource handler for images
	        registry.addResourceHandler("/css/**").addResourceLocations("/css/")
	              .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	        // Register resource handler for images
	        registry.addResourceHandler("/javascript/**").addResourceLocations("/javascript/")
	              .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	        registry.addResourceHandler("/image/**").addResourceLocations("/image/")
            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	    }	 
	   @Bean
	   public MessageSource messageSource() {
	      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	      source.setBasename("messages");
	      return source;
	   }
	 
	   @Override
	   public Validator getValidator() {
	      LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
	      validator.setValidationMessageSource(messageSource());
	      return validator;
	   }
}
