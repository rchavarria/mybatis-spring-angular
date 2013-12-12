package es.rchavarria.library.rest.controller;

import static es.rchavarria.library.rest.controller.fixture.RESTDataFixture.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import es.rchavarria.library.core.event.CreateCourseEvent;
import es.rchavarria.library.core.service.CourseService;
import es.rchavarria.library.rest.controller.CourseCommandsController;
import es.rchavarria.library.rest.domain.Course;
import es.rchavarria.library.rest.domain.CreatingCourseData;

public class CourseCommandsControllerTest {

    @InjectMocks
    private CourseCommandsController controller;

    @Mock
    private CourseService courseService;

    @Mock
    private CreatingCourseData course;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCoursesUsesCourseService() throws Exception {
        when(courseService.createDetailedCourse(any(CreateCourseEvent.class)))
            .thenReturn(courseCreated(12345));

        ResponseEntity<Course> response = controller.createCourse(course, null);

        verify(courseService, times(1)).createDetailedCourse(any(CreateCourseEvent.class));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

}
