package es.rchavarria.library.service;

import static es.rchavarria.library.controller.fixture.RESTDataFixture.createCourse;
import static es.rchavarria.library.controller.fixture.RESTDataFixture.createDetailedCourseEvent;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.rchavarria.library.domain.DetailedCourse;
import es.rchavarria.library.event.DetailedCourseCreatedEvent;
import es.rchavarria.library.persistence.LibraryRepository;

public class CourseRequestsHandlerTest {

    @InjectMocks
    private CourseRequestsHandler handler;
    @Mock
    private LibraryRepository repository;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testRequestAllCoursesUsesRepository() {
        handler.requestAllCourses();
        
        verify(repository).listDetailedCourses();
    }
    
    @Test
    public void testCreateCourseUsesRepository() {
        long idCourse = 12345;
        long idTeacher = 112233;
        
        when(repository.createDetailedCourse(any(DetailedCourse.class)))
            .thenReturn(createCourse(idCourse));
        
        DetailedCourseCreatedEvent event = 
                handler.createDetailedCourse(createDetailedCourseEvent(idTeacher));
        
        DetailedCourse created = event.getDetailedCourse();
        assertEquals(12345, created.getIdCourse());
        
        verify(repository, times(1)).findTeacher(idTeacher);
        verify(repository, times(1)).createDetailedCourse(any(DetailedCourse.class));
    }

}
