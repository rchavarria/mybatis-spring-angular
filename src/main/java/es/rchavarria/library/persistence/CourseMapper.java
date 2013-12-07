package es.rchavarria.library.persistence;

import java.util.List;

import es.rchavarria.library.domain.Course;

public interface CourseMapper {

    public List<Course> list();
    
    public List<Course> listWithTeachers();
}
