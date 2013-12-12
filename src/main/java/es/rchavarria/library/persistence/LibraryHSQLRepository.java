package es.rchavarria.library.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.rchavarria.library.domain.DetailedCourse;
import es.rchavarria.library.domain.Teacher;

public class LibraryHSQLRepository implements LibraryRepository {

    @Autowired
    private final CourseMapper courseMapper;
    @Autowired
    private final TeacherMapper teacherMapper;

    public LibraryHSQLRepository(CourseMapper courseMapper, TeacherMapper teacherMapper) {
        this.courseMapper = courseMapper;
        this.teacherMapper = teacherMapper;
    }

    public List<DetailedCourse> listDetailedCourses() {
        return courseMapper.list();
    }
    
    public List<Teacher> listTeachers() {
        return teacherMapper.list();
    }

    public Teacher findTeacher(long teacher) {
        throw new RuntimeException("not implemented yet");
    }

    public DetailedCourse createDetailedCourse(DetailedCourse course) {
        throw new RuntimeException("not implemented yet");
    }

}
