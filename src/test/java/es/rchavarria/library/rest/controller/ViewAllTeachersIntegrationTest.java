package es.rchavarria.library.rest.controller;

import static es.rchavarria.library.rest.controller.fixture.RESTDataFixture.allTeachers;
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

import es.rchavarria.library.core.service.TeacherService;
import es.rchavarria.library.rest.controller.TeacherQueriesController;

public class ViewAllTeachersIntegrationTest {
  
    MockMvc mockMvc;

    @InjectMocks
    TeacherQueriesController controller;

    @Mock
    TeacherService teacherService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = standaloneSetup(controller)
            .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }

    @Test
    public void testRequestAllTeachersUsesHttpOK() throws Exception {
        when(teacherService.requestAllTeachers()).thenReturn(allTeachers());

        this.mockMvc.perform(get("/teachers")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void testRequestAllTeachersRendersOkAsJSON() throws Exception {
        when(teacherService.requestAllTeachers()).thenReturn(allTeachers());

        this.mockMvc.perform(get("/teachers")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(jsonPath("$[0].idTeacher").value(0))
            .andExpect(jsonPath("$[0].name").value("Teacher 0"));
    }
}
