import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Áp dụng cho tất cả các route
            .allowedOrigins("http://localhost:3000") // Chỉ cho phép từ React frontend
            .allowedMethods("GET", "POST", "PUT", "DELETE") // Các phương thức HTTP được phép
            .allowedHeaders("*"); // Cho phép tất cả các header
    }
}
