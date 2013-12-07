package es.rchavarria.library.config;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.rchavarria.library.event.AllCoursesEvent;
import es.rchavarria.library.service.CourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CoreConfig.class })
public class CoreConfigIntegrationTest {

    @Autowired
    CourseService orderService;

    @Test
    public void addANewOrderToTheSystem() {
        AllCoursesEvent event = orderService.requestAllCourses();
        assertEquals(1, event.getCourses().size());
    }
}