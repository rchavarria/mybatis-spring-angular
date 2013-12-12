package es.rchavarria.library.core.persistence;

import java.util.List;

import es.rchavarria.library.core.domain.DetailedTeacher;

public interface TeacherMapper {

    public List<DetailedTeacher> list();

    public DetailedTeacher findById(long idTeacher);
}
