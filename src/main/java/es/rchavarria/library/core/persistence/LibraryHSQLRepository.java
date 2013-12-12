package es.rchavarria.library.core.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.rchavarria.library.core.domain.DetailedCourse;
import es.rchavarria.library.core.domain.DetailedTeacher;

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
        return courseMapper.listActiveCourses();
    }
    
    public DetailedCourse saveDetailedCourse(DetailedCourse course) {
        courseMapper.save(course);
        return course;
    }
    
    public List<DetailedTeacher> listTeachers() {
        return teacherMapper.list();
    }

    public DetailedTeacher findTeacher(long idTeacher) {
        return teacherMapper.findById(idTeacher);
    }

}
