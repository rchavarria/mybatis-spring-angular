package es.rchavarria.library.service;

import java.util.List;

import es.rchavarria.library.domain.DetailedCourse;
import es.rchavarria.library.event.AllCoursesEvent;
import es.rchavarria.library.persistence.LibraryRepository;

public class CourseRequestsHandler implements CourseService {

    private final LibraryRepository repository;
    
    public CourseRequestsHandler(LibraryRepository repository) {
        this.repository = repository;
    }
    
    public AllCoursesEvent requestAllCourses() {
        List<DetailedCourse> courses = repository.list();
        return new AllCoursesEvent(courses);
    }

}
