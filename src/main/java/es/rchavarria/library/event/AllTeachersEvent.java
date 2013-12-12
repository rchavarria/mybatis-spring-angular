package es.rchavarria.library.event;

import java.util.List;

import es.rchavarria.library.core.domain.Teacher;

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
