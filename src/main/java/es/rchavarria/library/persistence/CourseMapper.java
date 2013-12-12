package es.rchavarria.library.persistence;

import java.util.List;

import es.rchavarria.library.domain.DetailedCourse;

public interface CourseMapper {

    public List<DetailedCourse> list();
    
    public DetailedCourse findById(long idCourse);

    public void save(DetailedCourse course);
}
