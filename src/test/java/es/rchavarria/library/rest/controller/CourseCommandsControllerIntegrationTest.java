package es.rchavarria.library.rest.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import static es.rchavarria.library.rest.controller.fixture.RESTDataFixture.courseCreated;
import static es.rchavarria.library.rest.controller.fixture.RESTDataFixture.standardCourseJSON;
import es.rchavarria.library.core.event.CreateCourseEvent;
import es.rchavarria.library.core.service.CourseService;
import es.rchavarria.library.rest.controller.CourseCommandsController;

public class CourseCommandsControllerIntegrationTest {

    private static final int COURSE_ID = 12345;

    MockMvc mockMvc;

    @InjectMocks
    CourseCommandsController controller;

    @Mock
    CourseService courseService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = standaloneSetup(controller)
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .build();

        when(courseService.createDetailedCourse(any(CreateCourseEvent.class)))
                .thenReturn(courseCreated(COURSE_ID));
    }

    @Test
    public void thatCreateCourseUsesHttpCreated() throws Exception {
        this.mockMvc.perform(post("/courses")
                .content(standardCourseJSON(COURSE_ID))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void thatCreateCourseRendersAsJson() throws Exception {
        this.mockMvc.perform(post("/courses")
                .content(standardCourseJSON(COURSE_ID))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("Title " + COURSE_ID));
    }

}