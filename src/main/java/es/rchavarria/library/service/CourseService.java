package es.rchavarria.library.service;

import es.rchavarria.library.event.AllCoursesEvent;

public interface CourseService {

    public AllCoursesEvent requestAllCourses();
}
