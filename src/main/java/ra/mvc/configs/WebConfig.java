package ra.mvc.configs;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan(basePackages = "ra.mvc") // Scan for components in the specified package
@EnableWebMvc // Enable Spring MVC features
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/views/"); // Directory where views are located
        resolver.setSuffix(".jsp"); // File extension for views
        return resolver;
    }
    @Bean
    MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }


    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("message"); // Base name for message properties files
        messageSource.setDefaultEncoding("UTF-8"); // Set default encoding for messages
        return messageSource;
    }
    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        validatorFactoryBean.setValidationMessageSource(messageSource());
        return validatorFactoryBean;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }
}
