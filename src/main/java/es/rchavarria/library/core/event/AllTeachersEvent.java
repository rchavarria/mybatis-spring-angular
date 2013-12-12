package es.rchavarria.library.core.event;

import java.util.List;

import es.rchavarria.library.rest.domain.Teacher;

public class AllTeachersEvent {

    private final List<Teacher> teachers;

    public AllTeachersEvent(List<Teacher> teachers) {
        super();
        this.teachers = teachers;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

}
