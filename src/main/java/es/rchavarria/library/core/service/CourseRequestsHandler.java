package es.rchavarria.library.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.rchavarria.library.core.domain.CourseLevel;
import es.rchavarria.library.core.domain.DetailedCourse;
import es.rchavarria.library.core.domain.DetailedTeacher;
import es.rchavarria.library.core.event.AllCoursesEvent;
import es.rchavarria.library.core.event.CreateDetailedCourseEvent;
import es.rchavarria.library.core.event.DetailedCourseCreatedEvent;
import es.rchavarria.library.core.persistence.LibraryRepository;
import es.rchavarria.library.rest.domain.CreatingCourseData;

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

    public DetailedCourseCreatedEvent createDetailedCourse(CreateDetailedCourseEvent event) {
        CreatingCourseData courseData = event.getCourseData();
        DetailedTeacher teacher = repository.findTeacher(courseData.getTeacher());
        CourseLevel level = CourseLevel.valueOf(courseData.getLevel());
        
        DetailedCourse course = DetailedCourse.fromCreatingCourseData(courseData, teacher, level);
        DetailedCourse saved = repository.saveDetailedCourse(course);
        
        return new DetailedCourseCreatedEvent(saved);
    }

}
