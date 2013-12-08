package es.rchavarria.library.persistence;

import java.util.ArrayList;
import java.util.List;

import es.rchavarria.library.domain.CourseLevel;
import es.rchavarria.library.domain.DetailedCourse;

public class LibraryStaticRepository implements LibraryRepository {

    public List<DetailedCourse> list() {
        List<DetailedCourse> courses = new ArrayList<DetailedCourse>(1);
        
        courses.add(createDetailedCourse());
        
        return courses;
    }

    private DetailedCourse createDetailedCourse() {
        DetailedCourse course = new DetailedCourse();
        
        course.setTitle("Title 1");
        course.setHoursLong(12.5f);
        course.setLevel(CourseLevel.BASIC);
        
        return course;
    }

}
