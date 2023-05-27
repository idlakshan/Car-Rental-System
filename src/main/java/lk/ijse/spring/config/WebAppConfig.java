package lk.ijse.spring.config;

import lk.ijse.spring.controller.AdminController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses = {AdminController.class})
@EnableWebMvc
public class WebAppConfig {

}
