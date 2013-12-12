package es.rchavarria.library.event;

import java.util.List;

import es.rchavarria.library.core.domain.DetailedCourse;

public class AllCoursesEvent {

    private final List<DetailedCourse> courses;

    public AllCoursesEvent(List<DetailedCourse> courses) {
        super();
        this.courses = courses;
    }

    public List<DetailedCourse> getCourses() {
        return courses;
    }

}
