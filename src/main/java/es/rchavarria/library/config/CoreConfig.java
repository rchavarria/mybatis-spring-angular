package es.rchavarria.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.rchavarria.library.persistence.CourseRepository;
import es.rchavarria.library.persistence.CourseStaticRepository;
import es.rchavarria.library.service.CourseRequestsHandler;
import es.rchavarria.library.service.CourseService;

@Configuration
public class CoreConfig {

    @Bean
    public CourseService createCourseService(CourseRepository repository) {
        return new CourseRequestsHandler(repository);
    }
    
    @Bean
    public CourseRepository createCourseRepository() {
        return new CourseStaticRepository();
    }
}
