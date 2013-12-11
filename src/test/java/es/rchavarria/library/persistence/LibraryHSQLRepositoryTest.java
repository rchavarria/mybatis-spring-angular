package es.rchavarria.library.persistence;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;

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
        
        verify(courseMapper).list();
    }
    
    @Test
    public void testListTeachersUsesTeacherMapper() {
        repository.listTeachers();
        
        verify(teacherMapper).list();
    }

}
