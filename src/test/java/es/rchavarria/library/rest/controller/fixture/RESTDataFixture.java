package es.rchavarria.library.rest.controller.fixture;

import java.util.ArrayList;
import java.util.List;

import es.rchavarria.library.core.domain.CourseLevel;
import es.rchavarria.library.core.domain.DetailedCourse;
import es.rchavarria.library.core.domain.DetailedTeacher;
import es.rchavarria.library.core.event.AllCourseLevelsEvent;
import es.rchavarria.library.core.event.AllCoursesEvent;
import es.rchavarria.library.core.event.AllTeachersEvent;
import es.rchavarria.library.core.event.CreateCourseEvent;
import es.rchavarria.library.core.event.DetailedCourseCreatedEvent;
import es.rchavarria.library.rest.domain.Course;
import es.rchavarria.library.rest.domain.CreatingCourseData;
import es.rchavarria.library.rest.domain.Level;
import es.rchavarria.library.rest.domain.Teacher;

public class RESTDataFixture {

    public static AllCoursesEvent allCourses() {
        List<Course> courses = new ArrayList<Course>(3);
        
        courses.add(createCourse(1));
        courses.add(createCourse(3));
        courses.add(createCourse(5));
        
        return new AllCoursesEvent(courses);
    }

    public static DetailedCourse createDetailedCourse(long id) {
        DetailedCourse course = new DetailedCourse();
        
        course.setIdCourse(id);
        course.setTitle("Title " + id);
        course.setTeacher(createDetailedTeacher(id));
        course.setLevel(CourseLevel.BASIC);
        course.setHoursLong(12.5f);
        course.setActive(true);
        
        return course;
    }

    public static Course createCourse(long id) {
        return Course.fromDetailedCourse(createDetailedCourse(id));
    }

    public static AllTeachersEvent allTeachers() {
        List<Teacher> teachers = new ArrayList<Teacher>(3);
        
        teachers.add(Teacher.fromTeacher(createDetailedTeacher(0)));
        teachers.add(Teacher.fromTeacher(createDetailedTeacher(1)));
        teachers.add(Teacher.fromTeacher(createDetailedTeacher(2)));
        
        return new AllTeachersEvent(teachers);
    }
    
    private static DetailedTeacher createDetailedTeacher(long id) {
        DetailedTeacher teacher = new DetailedTeacher();
        
        teacher.setIdTeacher(id);
        teacher.setName("Teacher " + id);
        
        return teacher;
    }

    public static AllCourseLevelsEvent allLevels() {
        List<Level> levels = new ArrayList<Level>(CourseLevel.values().length);
        
        for(CourseLevel level : CourseLevel.values()) {
            levels.add(Level.fromCourseLevel(level));
        }
        
        return new AllCourseLevelsEvent(levels);
    }
    
    public static DetailedCourseCreatedEvent courseCreated(long id) {
        return new DetailedCourseCreatedEvent(createDetailedCourse(id));
    }

    public static String standardCourseJSON(long id) {
        return "{ \"title\": \"Title " + id + "\" }";
    }
    
    public static CreateCourseEvent createDetailedCourseEvent(long idTeacher) {
        return new CreateCourseEvent(createCreatingCourseData(idTeacher));
    }

    private static CreatingCourseData createCreatingCourseData(long idTeacher) {
        CreatingCourseData data = new CreatingCourseData();
        
        data.setTitle("Title 1");
        data.setTeacher(idTeacher);
        data.setLevel("BASIC");
        data.setHoursLong(12.5f);
        data.setActive(true);
        
        return data;
    }
}
