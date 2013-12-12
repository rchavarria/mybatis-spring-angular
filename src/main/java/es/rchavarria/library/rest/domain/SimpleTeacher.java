package es.rchavarria.library.rest.domain;

import es.rchavarria.library.core.domain.DetailedTeacher;

public class SimpleTeacher {

    private long idTeacher;
    private String name;

    public long getIdTeacher() {
        return idTeacher;
    }

    public String getName() {
        return name;
    }

    public static SimpleTeacher fromTeacher(DetailedTeacher teacher) {
        SimpleTeacher t = new SimpleTeacher();
        
        t.idTeacher = teacher.getIdTeacher();
        t.name = teacher.getName();
        
        return t;
    }
    
}
