package es.rchavarria.library.persistence;

import static org.junit.Assert.*;  

import java.util.List;

import javax.annotation.Resource;  
  

import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import es.rchavarria.library.domain.Course;
import es.rchavarria.library.domain.CourseLevel;
  
@SuppressWarnings("restriction")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/test-mybatis-app-config.xml" })  
public class CourseMapperTest {  

    @Resource  
    CourseMapper courseMapper;  

    @Test
    public void testListAllCourses() {
        List<Course> courses = courseMapper.list();
        assertEquals("test-data.sql inserts 15 courses", 15, courses.size());
    }

    @Test
    public void testFirstCourseData() {
        Course course = courseMapper.findById(0);
        
        assertEquals(0, course.getIdCourse());
        assertEquals("Title 1", course.getTitle());
        assertEquals("Teacher 1", course.getTeacher().getName());
        assertEquals(CourseLevel.BASIC, course.getLevel());
        assertEquals(12.5, course.getHoursLong(), 0.1);
        assertEquals(true, course.isActive());
    }

    @Test
    public void testIntermediateLevelCourse() {
        Course course = courseMapper.findById(2);
        assertEquals(CourseLevel.INTERMEDIATE, course.getLevel());
    }

    @Test
    public void testAdvancedLevelCourse() {
        Course course = courseMapper.findById(5);
        assertEquals(CourseLevel.ADVANCED, course.getLevel());
    }

    @Test
    public void testIntegersHoursLong() {
        Course course = courseMapper.findById(9);
        assertEquals(10.0, course.getHoursLong(), 0.1);
    }
    
    @Test
    public void testCourse13thHasTeacher4th() {
        Course course = courseMapper.findById(13);
        assertEquals("Teacher 4", course.getTeacher().getName());
    }

}