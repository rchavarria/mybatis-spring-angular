package es.rchavarria.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.rchavarria.library.domain.CourseLevel;
import es.rchavarria.library.domain.DetailedCourse;
import es.rchavarria.library.domain.Teacher;
import es.rchavarria.library.event.AllCoursesEvent;
import es.rchavarria.library.event.CreateDetailedCourseEvent;
import es.rchavarria.library.event.DetailedCourseCreatedEvent;
import es.rchavarria.library.persistence.LibraryRepository;
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
        Teacher teacher = repository.findTeacher(courseData.getTeacher());
        CourseLevel level = CourseLevel.valueOf(courseData.getLevel());
        
        DetailedCourse course = DetailedCourse.fromCreatingCourseData(courseData, teacher, level);
        DetailedCourse saved = repository.saveDetailedCourse(course);
        
        return new DetailedCourseCreatedEvent(saved);
    }

}
