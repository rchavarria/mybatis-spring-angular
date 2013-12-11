package es.rchavarria.library.rest.domain;

public class CreatingCourseData {

    private long idCourse;
    private String title;
    private long teacher;
    private String level;
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
    public long getTeacher() {
        return teacher;
    }
    public void setTeacher(long teacher) {
        this.teacher = teacher;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
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

}