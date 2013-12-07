package es.rchavarria.library.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import es.rchavarria.library.domain.Teacher;

public interface TeacherMapper {

//    @Select("SELECT * FROM teachers")
    public List<Teacher> list();
}
