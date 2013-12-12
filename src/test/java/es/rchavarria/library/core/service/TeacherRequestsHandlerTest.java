package es.rchavarria.library.core.service;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;

import es.rchavarria.library.core.persistence.LibraryRepository;
import es.rchavarria.library.core.service.TeacherRequestsHandler;

public class TeacherRequestsHandlerTest {

    @InjectMocks
    private TeacherRequestsHandler handler;
    @Mock
    private LibraryRepository repository;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testRequestAllTeachersUsesRepository() {
        handler.requestAllTeachers();
        
        verify(repository).listTeachers();
    }

}
