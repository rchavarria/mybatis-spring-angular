package es.rchavarria.library.core.persistence;

import java.util.List;

import es.rchavarria.library.core.domain.DetailedCourse;
import es.rchavarria.library.core.domain.DetailedTeacher;

public interface LibraryRepository {

    public List<DetailedCourse> listDetailedCourses();

    public DetailedCourse saveDetailedCourse(DetailedCourse course);
    
    public List<DetailedTeacher> listTeachers();
    
    public DetailedTeacher findTeacher(long teacher);

}
