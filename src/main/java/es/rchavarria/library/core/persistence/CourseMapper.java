package es.rchavarria.library.core.persistence;

import java.util.List;

import es.rchavarria.library.core.domain.DetailedCourse;

public interface CourseMapper {

    public List<DetailedCourse> listActiveCourses();
    
    public DetailedCourse findById(long idCourse);

    public void save(DetailedCourse course);
}
