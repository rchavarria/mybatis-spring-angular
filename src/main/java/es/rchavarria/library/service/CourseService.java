package es.rchavarria.library.service;

import es.rchavarria.library.core.event.AllCoursesEvent;
import es.rchavarria.library.core.event.CreateDetailedCourseEvent;
import es.rchavarria.library.core.event.DetailedCourseCreatedEvent;

public interface CourseService {

    public AllCoursesEvent requestAllCourses();

    public DetailedCourseCreatedEvent createDetailedCourse(CreateDetailedCourseEvent event);
}
