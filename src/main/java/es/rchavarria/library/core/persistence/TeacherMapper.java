package es.rchavarria.library.core.persistence;

import java.util.List;

import es.rchavarria.library.core.domain.Teacher;

public interface TeacherMapper {

    public List<Teacher> list();

    public Teacher findById(long idTeacher);
}
