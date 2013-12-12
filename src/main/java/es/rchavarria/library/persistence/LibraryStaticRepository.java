package es.rchavarria.library.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.rchavarria.library.domain.CourseLevel;
import es.rchavarria.library.domain.DetailedCourse;
import es.rchavarria.library.domain.Teacher;

public class LibraryStaticRepository implements LibraryRepository {

    public List<DetailedCourse> listDetailedCourses() {
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

    public List<Teacher> listTeachers() {
        return Collections.emptyList();
    }

    public Teacher findTeacher(long idTeacher) {
        Teacher teacher = new Teacher();
        
        teacher.setIdTeacher(idTeacher);
        teacher.setName("Teacher " + idTeacher);
        
        return teacher;
    }

    public DetailedCourse saveDetailedCourse(DetailedCourse course) {
        return createDetailedCourse();
    }

}
