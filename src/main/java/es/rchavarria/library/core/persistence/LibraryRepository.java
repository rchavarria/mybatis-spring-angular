package es.rchavarria.library.core.persistence;

import java.util.List;

import es.rchavarria.library.core.domain.DetailedCourse;
import es.rchavarria.library.core.domain.Teacher;

public interface LibraryRepository {

    public List<DetailedCourse> listDetailedCourses();

    public DetailedCourse saveDetailedCourse(DetailedCourse course);
    
    public List<Teacher> listTeachers();
    
    public Teacher findTeacher(long teacher);

}
