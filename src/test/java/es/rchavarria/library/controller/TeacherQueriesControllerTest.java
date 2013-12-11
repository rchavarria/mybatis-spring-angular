package es.rchavarria.library.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static es.rchavarria.library.controller.fixture.RESTDataFixture.allTeachers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.rchavarria.library.service.TeacherService;

public class TeacherQueriesControllerTest {

    @InjectMocks
    TeacherQueriesController controller;

    @Mock
    TeacherService teacherService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllTeachersUsesTeacherService() throws Exception {
        when(teacherService.requestAllTeachers()).thenReturn(allTeachers());

        controller.getAllTeachers();

        verify(teacherService, times(1)).requestAllTeachers();
    }

}
