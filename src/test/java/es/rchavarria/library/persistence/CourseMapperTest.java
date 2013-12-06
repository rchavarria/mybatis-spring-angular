package es.rchavarria.library.persistence;

import static org.junit.Assert.*;  

import java.util.List;

import javax.annotation.Resource;  
  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import es.rchavarria.library.domain.Course;
  
@SuppressWarnings("restriction")
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:/test-mybatis-app-config.xml" })  
public class CourseMapperTest {  
  
    @Resource  
    CourseMapper personaMapper;  
  
    @Test  
    public void testListAllCourses() {
        List<Course> courses = personaMapper.list();
        assertEquals("only one course should exist", 1, courses.size());
    }  
  
}