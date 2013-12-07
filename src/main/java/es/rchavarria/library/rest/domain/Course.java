package es.rchavarria.library.rest.domain;

import es.rchavarria.library.domain.CourseLevel;
import es.rchavarria.library.domain.DetailedCourse;

public class Course {

    private String title;
    private CourseLevel level;
    private float hoursLong;
    
    public String getTitle() {
        return title;
    }
    public CourseLevel getLevel() {
        return level;
    }
    public float getHoursLong() {
        return hoursLong;
    }
    
    public static Course fromDetailedCourse(DetailedCourse detailedCourse) {
        Course course = new Course();
        
        course.title = detailedCourse.getTitle();
        course.level = detailedCourse.getLevel();
        course.hoursLong = detailedCourse.getHoursLong();
        
        return course;
    }

}
