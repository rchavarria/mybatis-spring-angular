package es.rchavarria.library.event;

import es.rchavarria.library.rest.domain.CreatingCourseData;

public class CreateDetailedCourseEvent {

    private final CreatingCourseData course;
    
    public CreateDetailedCourseEvent(CreatingCourseData course) {
        this.course = course;
    }
    
    public CreatingCourseData getCourseData() {
        return course;
    }

}
