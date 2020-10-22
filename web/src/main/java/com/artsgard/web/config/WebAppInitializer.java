package com.artsgard.web.config;

import com.artsgard.core.config.AppConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@Configuration
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        AnnotationConfigWebApplicationContext webContext
                = new AnnotationConfigWebApplicationContext();
        webContext.setConfigLocations("com.artsgard.core");
        webContext.register(WebConfig.class);
        
        container.addListener(new ContextLoaderListener(webContext));
        webContext.setServletContext(container);
        DispatcherServlet ds = new DispatcherServlet(webContext); 
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", ds);
        servlet.setInitParameter("dispatchOptionsRequest", "true");
        servlet.setAsyncSupported(true);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
    
    //@Override
    public void onStartup2(ServletContext container) {
        AnnotationConfigApplicationContext rootContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        //rootContext.setConfigLocations("com.artsgard.core");
        
        AnnotationConfigWebApplicationContext webContext
                = new AnnotationConfigWebApplicationContext();
        webContext.register(WebConfig.class);
        container.addListener(new ContextLoaderListener((WebApplicationContext) rootContext));
        
        webContext.setServletContext(container);
        DispatcherServlet sc = new DispatcherServlet(webContext);
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", sc);
        servlet.setInitParameter("dispatchOptionsRequest", "true");
        servlet.setAsyncSupported(true);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}