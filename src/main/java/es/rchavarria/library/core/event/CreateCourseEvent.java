package es.rchavarria.library.core.event;

import es.rchavarria.library.rest.domain.CreatingCourseData;

public class CreateCourseEvent {

    private final CreatingCourseData course;
    
    public CreateCourseEvent(CreatingCourseData course) {
        this.course = course;
    }
    
    public CreatingCourseData getCourseData() {
        return course;
    }

}
