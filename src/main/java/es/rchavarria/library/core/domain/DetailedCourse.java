package es.rchavarria.library.core.domain;

import es.rchavarria.library.rest.domain.CreatingCourseData;

public class DetailedCourse {

    private long idCourse;
    private String title;
    private DetailedTeacher teacher;
    private CourseLevel level;
    private float hoursLong;
    private boolean active;
    
    public long getIdCourse() {
        return idCourse;
    }
    public void setIdCourse(long idCourse) {
        this.idCourse = idCourse;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public DetailedTeacher getTeacher() {
        return teacher;
    }
    public void setTeacher(DetailedTeacher teacher) {
        this.teacher = teacher;
    }
    public CourseLevel getLevel() {
        return level;
    }
    public void setLevel(CourseLevel level) {
        this.level = level;
    }
    public float getHoursLong() {
        return hoursLong;
    }
    public void setHoursLong(float hoursLong) {
        this.hoursLong = hoursLong;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    
    public static DetailedCourse fromCreatingCourseData(CreatingCourseData courseData,
                                                        DetailedTeacher teacher,
                                                        CourseLevel level) {
        DetailedCourse detailedCourse = new DetailedCourse();
        
        detailedCourse.title = courseData.getTitle();
        detailedCourse.teacher = teacher;
        detailedCourse.level = level;
        detailedCourse.hoursLong = courseData.getHoursLong();
        detailedCourse.active = courseData.isActive();
        
        return detailedCourse;
    }

}
