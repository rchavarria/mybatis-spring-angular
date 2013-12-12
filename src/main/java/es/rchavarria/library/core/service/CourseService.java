package es.rchavarria.library.core.service;

import es.rchavarria.library.core.event.AllCoursesEvent;
import es.rchavarria.library.core.event.CreateCourseEvent;
import es.rchavarria.library.core.event.DetailedCourseCreatedEvent;

public interface CourseService {

    public AllCoursesEvent requestAllCourses();

    public DetailedCourseCreatedEvent createDetailedCourse(CreateCourseEvent event);
}
