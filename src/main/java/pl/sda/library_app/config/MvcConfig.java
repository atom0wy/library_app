package pl.sda.library_app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/account").setViewName("account");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/catalog").setViewName("catalog");
        registry.addViewController("/shelf").setViewName("shelf");
        registry.addViewController("/handing").setViewName("handing");
        registry.addViewController("/inventory").setViewName("inventory");
    }

}
