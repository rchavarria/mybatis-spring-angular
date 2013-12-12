package es.rchavarria.library.core.event;

import es.rchavarria.library.core.domain.DetailedCourse;

public class DetailedCourseCreatedEvent {

    private final DetailedCourse detailedCourse;
    
    public DetailedCourseCreatedEvent(DetailedCourse detailedCourse) {
        this.detailedCourse = detailedCourse;
    }
    
    public DetailedCourse getDetailedCourse() {
        return detailedCourse;
    }

}
