package es.rchavarria.library.domain;

public class Course {

    private String title;
    private String teacher;
    private String level;
    private float hoursLong;
    private boolean active;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
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
