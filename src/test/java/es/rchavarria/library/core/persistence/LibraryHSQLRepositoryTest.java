package es.rchavarria.library.core.persistence;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.rchavarria.library.core.domain.DetailedCourse;
import es.rchavarria.library.core.persistence.CourseMapper;
import es.rchavarria.library.core.persistence.LibraryHSQLRepository;
import es.rchavarria.library.core.persistence.TeacherMapper;

public class LibraryHSQLRepositoryTest {

    @InjectMocks
    private LibraryHSQLRepository repository;
    @Mock
    private CourseMapper courseMapper;
    @Mock
    private TeacherMapper teacherMapper;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testListCoursesUsesCourseMapper() {
        repository.listDetailedCourses();
        verify(courseMapper).listActiveCourses();
    }
    
    @Test
    public void testSaveCourseUsesCourseMapper() {
        DetailedCourse dc = new DetailedCourse();
        repository.saveDetailedCourse(dc);
        verify(courseMapper).save(any(DetailedCourse.class));
    }
    
    @Test
    public void testListTeachersUsesTeacherMapper() {
        repository.listTeachers();
        verify(teacherMapper).list();
    }
    
    @Test
    public void testFindTeacherByIdUsesTeacherMapper()  {
        repository.findTeacher(12345);
        verify(teacherMapper).findById(12345);
    }

}
