package es.rchavarria.library.core.event;

import java.util.List;

import es.rchavarria.library.core.domain.DetailedTeacher;

public class AllTeachersEvent {

    private final List<DetailedTeacher> teachers;

    public AllTeachersEvent(List<DetailedTeacher> teachers) {
        super();
        this.teachers = teachers;
    }

    public List<DetailedTeacher> getTeachers() {
        return teachers;
    }

}
