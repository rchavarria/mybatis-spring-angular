package es.rchavarria.library.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import es.rchavarria.library.domain.Course;

public interface CourseMapper {

//    @Select("SELECT idCourse, title, courses.idTeacher, level, hoursLong, active FROM courses INNER JOIN teachers ON teachers.idTeacher = courses.idCourse")
    public List<Course> list();
}
