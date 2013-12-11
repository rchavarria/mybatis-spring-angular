package es.rchavarria.library.service;

import es.rchavarria.library.event.AllCoursesEvent;
import es.rchavarria.library.event.CreateDetailedCourseEvent;
import es.rchavarria.library.event.DetailedCourseCreatedEvent;

public interface CourseService {

    public AllCoursesEvent requestAllCourses();

    public DetailedCourseCreatedEvent createDetailedCourse(CreateDetailedCourseEvent event);
}
