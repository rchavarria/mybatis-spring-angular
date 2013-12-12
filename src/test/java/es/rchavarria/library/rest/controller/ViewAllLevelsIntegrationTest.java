package es.rchavarria.library.rest.controller;

import static es.rchavarria.library.rest.controller.fixture.RESTDataFixture.allLevels;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import es.rchavarria.library.core.domain.CourseLevel;
import es.rchavarria.library.core.service.LevelService;
import es.rchavarria.library.rest.controller.LevelQueriesController;

public class ViewAllLevelsIntegrationTest {
  
    MockMvc mockMvc;

    @InjectMocks
    LevelQueriesController controller;

    @Mock
    LevelService levelService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = standaloneSetup(controller)
            .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }

    @Test
    public void testRequestAllLevelsUsesHttpOK() throws Exception {
        when(levelService.requestAllCourseLevels()).thenReturn(allLevels());

        this.mockMvc.perform(get("/levels")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void testRequestAllLevelsRendersOkAsJSON() throws Exception {
        when(levelService.requestAllCourseLevels()).thenReturn(allLevels());

        this.mockMvc.perform(get("/levels")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(jsonPath("$[0].level").value(CourseLevel.BASIC.toString()))
            .andExpect(jsonPath("$[1].level").value(CourseLevel.INTERMEDIATE.toString()))
            .andExpect(jsonPath("$[2].level").value(CourseLevel.ADVANCED.toString()));
    }
}
