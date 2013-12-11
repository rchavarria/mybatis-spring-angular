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

}
