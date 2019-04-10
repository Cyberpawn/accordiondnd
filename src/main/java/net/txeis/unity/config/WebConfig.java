package net.txeis.unity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "net.txeis.unity" })
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    // @Bean
    // public void addViewControllers (final ViewControllerRegistry registry) { 
    //     registry.addViewController("/index");
    // }

    //Only necessary if configuring views beyond defualt view behavior
    // @Bean
    // public ViewResolver resourceBundleViewResolver() {
    //     ResourceBundleViewResolver bean = new ResourceBundleViewResolver();
    //     bean.setBasename("views");
    //     return bean;
    // }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/react-unity/build/");
        registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/react-unity/build/static/");
    }
}