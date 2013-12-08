package es.rchavarria.library.persistence;

import java.util.List;

import es.rchavarria.library.domain.DetailedCourse;

public interface LibraryRepository {

    public List<DetailedCourse> list();

}
