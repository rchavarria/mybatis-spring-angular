package es.rchavarria.library.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import es.rchavarria.library.domain.Course;

public interface CourseMapper {

    @Select("SELECT idCourse, title, level,hoursLong, active FROM courses")
    public List<Course> list();
}
