package es.rchavarria.library.persistence;

import java.util.List;

import es.rchavarria.library.domain.Teacher;

public interface TeacherMapper {

    public List<Teacher> list();

    public Teacher findById(long idTeacher);
}
