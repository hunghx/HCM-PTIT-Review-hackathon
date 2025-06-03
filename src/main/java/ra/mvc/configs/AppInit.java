package ra.mvc.configs;

import jakarta.servlet.FilterRegistration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext){
        // Cấu hình Root Context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Cấu hình DispatcherServlet Context
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebConfig.class);

        // Đăng ký DispatcherServlet
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        // --- Cấu hình CharacterEncodingFilter cho UTF-8 ---
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);

        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
        encodingFilter.addMappingForUrlPatterns(null, false, "/*"); // Áp dụng cho tất cả các URL
    }
}
