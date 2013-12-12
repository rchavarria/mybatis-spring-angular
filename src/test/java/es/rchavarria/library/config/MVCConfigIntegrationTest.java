package es.rchavarria.library.config;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { CoreConfig.class, MVCConfig.class })
public class MVCConfigIntegrationTest {

  @Autowired
  WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
  }

  @Test
  public void testRequestAllCourses() throws Exception  {
    this.mockMvc.perform(get("/courses")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].title").value("Title 1"))
            .andExpect(jsonPath("$[5].title").value("Title 4 - Teacher 2"))
            .andExpect(jsonPath("$[9].title").value("Title 5 - Teacher 5"));
  }

  @Test
  public void testRequestAllTeachers() throws Exception  {
    this.mockMvc.perform(get("/teachers")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value("Teacher 1"))
            .andExpect(jsonPath("$[4].name").value("Teacher 5"));
  }

  @Test
  public void testRequestAllLevels() throws Exception  {
    this.mockMvc.perform(get("/levels")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].level").value("BASIC"))
            .andExpect(jsonPath("$[1].level").value("INTERMEDIATE"))
            .andExpect(jsonPath("$[2].level").value("ADVANCED"));
  }
}
