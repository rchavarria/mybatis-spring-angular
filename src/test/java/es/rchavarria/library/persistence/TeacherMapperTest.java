package es.rchavarria.library.persistence;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.rchavarria.library.domain.Teacher;
  
@SuppressWarnings("restriction")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/test-mybatis-app-config.xml" })  
public class TeacherMapperTest {  
  
    @Resource  
    TeacherMapper teacherMapper;  
    
    @Test
    public void testListAllCourses() {
        List<Teacher> teachers = teacherMapper.list();
        assertEquals("only one teacher should exist", 1, teachers.size());
    }  
    
    @Test
    public void testFirstCourseData() {
        Teacher teacher = teacherMapper.list().get(0);
        
        assertEquals(1, teacher.getIdTeacher());
        assertEquals("Teacher 1", teacher.getName());
    }  
  
}