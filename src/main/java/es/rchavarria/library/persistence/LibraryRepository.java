package es.rchavarria.library.persistence;

import java.util.List;

import es.rchavarria.library.domain.DetailedCourse;
import es.rchavarria.library.domain.Teacher;

public interface LibraryRepository {

    public List<DetailedCourse> listDetailedCourses();

    public DetailedCourse saveDetailedCourse(DetailedCourse course);
    
    public List<Teacher> listTeachers();
    
    public Teacher findTeacher(long teacher);

}
