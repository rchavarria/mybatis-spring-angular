package es.rchavarria.library.service;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.rchavarria.library.persistence.LibraryRepository;

public class CourseRequestsHandlerTest {

    private CourseRequestsHandler handler;
    @Mock
    private LibraryRepository repository;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        handler = new CourseRequestsHandler(repository);
    }
    
    @Test
    public void testRequestAllCoursesUsesRepository() {
        handler.requestAllCourses();
        
        verify(repository).listDetailedCourses();
    }

}
