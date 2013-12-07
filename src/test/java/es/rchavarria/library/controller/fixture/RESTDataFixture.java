package es.rchavarria.library.controller.fixture;

import java.util.ArrayList;
import java.util.List;

import es.rchavarria.library.domain.Course;
import es.rchavarria.library.domain.CourseLevel;
import es.rchavarria.library.domain.Teacher;
import es.rchavarria.library.event.AllCoursesEvent;

public class RESTDataFixture {

    public static AllCoursesEvent allCourses() {
        List<Course> courses = new ArrayList<Course>(3);
        
        courses.add(createCourse(1));
        courses.add(createCourse(3));
        courses.add(createCourse(5));
        
        return new AllCoursesEvent(courses);
    }

    private static Course createCourse(long id) {
        Course course = new Course();
        
        course.setIdCourse(id);
        course.setTitle("Title 1");
        course.setTeacher(createTeacher(id));
        course.setLevel(CourseLevel.BASIC);
        course.setHoursLong(12.5f);
        course.setActive(true);
        
        return course;
    }

    private static Teacher createTeacher(long id) {
        Teacher teacher = new Teacher();
        
        teacher.setIdTeacher(id);
        teacher.setName("Teacher " + id);
        
        return teacher;
    }
}
