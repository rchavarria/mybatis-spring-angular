package es.rchavarria.library.service;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;

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

}
