package ra.mvc.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@Configuration
@PropertySource("classpath:application.properties") // Load properties from application.properties file
public class RootConfig {
    @Autowired
    private Environment env;
    // Database
    // security
    // messaging
    // properties
    // env
//    // Cloud config
    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", env.getProperty("cloud.name"),
                "api_key", env.getProperty("api.key"),
                "api_secret",env.getProperty("api.secret")));
    }
}
