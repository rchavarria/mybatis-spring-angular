package es.rchavarria.library.rest.domain;

import es.rchavarria.library.domain.Teacher;

public class SimpleTeacher {

    private long idTeacher;
    private String name;

    public long getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(long idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static SimpleTeacher fromTeacher(Teacher teacher) {
        SimpleTeacher t = new SimpleTeacher();
        
        t.idTeacher = teacher.getIdTeacher();
        t.name = teacher.getName();
        
        return t;
    }
    
}