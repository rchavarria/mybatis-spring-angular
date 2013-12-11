package es.rchavarria.library.event;

import es.rchavarria.library.domain.DetailedCourse;

public class DetailedCourseCreatedEvent {

    private final DetailedCourse detailedCourse;
    
    public DetailedCourseCreatedEvent(DetailedCourse detailedCourse) {
        this.detailedCourse = detailedCourse;
    }
    
    public DetailedCourse getDetailedCourse() {
        return detailedCourse;
    }

}
