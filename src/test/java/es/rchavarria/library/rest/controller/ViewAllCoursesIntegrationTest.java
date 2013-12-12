package es.rchavarria.library.rest.controller;

import static es.rchavarria.library.rest.controller.fixture.RESTDataFixture.allCourses;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import es.rchavarria.library.core.service.CourseService;
import es.rchavarria.library.rest.controller.CourseQueriesController;

public class ViewAllCoursesIntegrationTest {
  
    MockMvc mockMvc;

    @InjectMocks
    CourseQueriesController controller;

    @Mock
    CourseService courseService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = standaloneSetup(controller)
                .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }

    @Test
    public void testRequestAllCoursesUsesHttpOK() throws Exception {
        when(courseService.requestAllCourses()).thenReturn(allCourses());

        this.mockMvc.perform(get("/courses")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void testRequestAllCoursesRendersOkAsJSON() throws Exception {
        when(courseService.requestAllCourses()).thenReturn(allCourses());

        this.mockMvc.perform(get("/courses")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(jsonPath("$[0].title").value("Title 1"))
            .andExpect(jsonPath("$[0].level").value("BASIC"))
            .andExpect(jsonPath("$[0].hoursLong").value(12.5))
            .andExpect(jsonPath("$[1].title").value("Title 3"))
            .andExpect(jsonPath("$[2].title").value("Title 5"));
    }
}
