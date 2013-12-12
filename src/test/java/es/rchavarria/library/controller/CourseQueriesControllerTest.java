package es.rchavarria.library.controller;

import static es.rchavarria.library.controller.fixture.RESTDataFixture.allCourses;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.rchavarria.library.core.controller.CourseQueriesController;
import es.rchavarria.library.service.CourseService;

public class CourseQueriesControllerTest {

    @InjectMocks
    CourseQueriesController controller;

    @Mock
    CourseService courseService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCoursesUsesCourseService() throws Exception {
        when(courseService.requestAllCourses()).thenReturn(allCourses());

        controller.getAllCourses();

        verify(courseService, times(1)).requestAllCourses();
    }

}
