package es.rchavarria.library.controller;

import static es.rchavarria.library.controller.fixture.RESTDataFixture.allCourses;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import es.rchavarria.library.service.CourseService;

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

//  @Test
//  public void thatViewOrderUsesHttpNotFound() throws Exception {
//
//    when(courseService.requestOrderDetails(any(RequestOrderDetailsEvent.class))).thenReturn(
//            orderDetailsNotFound(key));
//
//    this.mockMvc.perform(
//            get("/aggregators/orders/{id}",  key.toString())
//                    .accept(MediaType.APPLICATION_JSON))
//            .andDo(print())
//            .andExpect(status().isNotFound());
//  }

  @Test
  public void thatViewOrderUsesHttpOK() throws Exception {
    when(courseService.requestAllCourses()).thenReturn(allCourses());

    this.mockMvc.perform(
            get("/library/courses")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

//  @Test
//  public void thatViewOrderRendersCorrectly() throws Exception {
//
//    when(courseService.requestOrderDetails(any(RequestOrderDetailsEvent.class))).thenReturn(
//            orderDetailsEvent(key));
//
//    this.mockMvc.perform(
//            get("/aggregators/orders/{id}", key.toString())
//                    .accept(MediaType.APPLICATION_JSON))
//            .andExpect(jsonPath("$.items['" + YUMMY_ITEM + "']").value(12))
//            .andExpect(jsonPath("$.key").value(key.toString()));
//  }
}
