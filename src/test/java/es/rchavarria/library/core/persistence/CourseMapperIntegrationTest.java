package es.rchavarria.library.core.persistence;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.rchavarria.library.config.CoreConfig;
import es.rchavarria.library.core.domain.CourseLevel;
import es.rchavarria.library.core.domain.DetailedCourse;
import es.rchavarria.library.core.persistence.CourseMapper;
import es.rchavarria.library.rest.controller.fixture.RESTDataFixture;
  
@SuppressWarnings("restriction")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CoreConfig.class })  
public class CourseMapperIntegrationTest {  

    @Resource  
    CourseMapper courseMapper;  

    @Test
    public void testListAllCourses() {
        List<DetailedCourse> courses = courseMapper.listActiveCourses();
        assertEquals("test-data.sql inserts 10 active courses, 5 inactive", 10, courses.size());
    }

    @Test
    public void testFirstCourseData() {
        DetailedCourse course = courseMapper.findById(0);
        
        assertEquals(0, course.getIdCourse());
        assertEquals("Title 1", course.getTitle());
        assertEquals("Teacher 1", course.getTeacher().getName());
        assertEquals(CourseLevel.BASIC, course.getLevel());
        assertEquals(12.5, course.getHoursLong(), 0.1);
        assertEquals(true, course.isActive());
    }

    @Test
    public void testIntermediateLevelCourse() {
        DetailedCourse course = courseMapper.findById(2);
        assertEquals(CourseLevel.INTERMEDIATE, course.getLevel());
    }

    @Test
    public void testAdvancedLevelCourse() {
        DetailedCourse course = courseMapper.findById(5);
        assertEquals(CourseLevel.ADVANCED, course.getLevel());
    }

    @Test
    public void testIntegersHoursLong() {
        DetailedCourse course = courseMapper.findById(9);
        assertEquals(10.0, course.getHoursLong(), 0.1);
    }
    
    @Test
    public void testCourse13thHasTeacher4th() {
        DetailedCourse course = courseMapper.findById(13);
        assertEquals("Teacher 4", course.getTeacher().getName());
    }
    
    @Test
    public void testSaveCourse() {
        DetailedCourse course = RESTDataFixture.createDetailedCourse(100);
        course.getTeacher().setIdTeacher(0);

        int oldNumberOfRecords = courseMapper.listActiveCourses().size();
        courseMapper.save(course);
        int newNumberOfRecords = courseMapper.listActiveCourses().size();
        
        assertEquals(newNumberOfRecords, oldNumberOfRecords + 1);
    }

}