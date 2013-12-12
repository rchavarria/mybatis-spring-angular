package es.rchavarria.library.core.event;

import java.util.List;

import es.rchavarria.library.rest.domain.Course;

public class AllCoursesEvent {

    private final List<Course> courses;

    public AllCoursesEvent(List<Course> courses) {
        super();
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

}
