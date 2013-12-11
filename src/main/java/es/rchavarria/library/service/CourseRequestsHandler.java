package es.rchavarria.library.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import es.rchavarria.library.domain.DetailedCourse;
import es.rchavarria.library.event.AllCoursesEvent;
import es.rchavarria.library.persistence.LibraryRepository;

public class CourseRequestsHandler implements CourseService {

    @Autowired
    private final LibraryRepository repository;
    
    public CourseRequestsHandler(LibraryRepository repository) {
        this.repository = repository;
    }
    
    public AllCoursesEvent requestAllCourses() {
        List<DetailedCourse> courses = repository.listDetailedCourses();
        return new AllCoursesEvent(courses);
    }

}
