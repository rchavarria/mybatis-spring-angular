package es.rchavarria.library.core.persistence;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.rchavarria.library.config.CoreConfig;
import es.rchavarria.library.core.domain.DetailedTeacher;
import es.rchavarria.library.core.persistence.TeacherMapper;
  
@SuppressWarnings("restriction")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CoreConfig.class })  
public class TeacherMapperIntegrationTest {  
  
    @Resource  
    TeacherMapper teacherMapper;  
    
    @Test
    public void testListAllTeachers() {
        List<DetailedTeacher> teachers = teacherMapper.list();
        assertEquals("test-data.sql insterts 5 teachers", 5, teachers.size());
    }  
    
    @Test
    public void testAllTeachersData() {
        List<DetailedTeacher> teachers = teacherMapper.list();
        
        for(int i = 0; i < teachers.size(); i++) {
            DetailedTeacher teacher = teachers.get(i);
            assertEquals(i, teacher.getIdTeacher());
            assertEquals("Teacher " + (i + 1), teacher.getName());
        }
    }
    
    @Test
    public void testFindTeacherById() {
        assertEquals("Teacher 1", teacherMapper.findById(0).getName());
        assertEquals("Teacher 5", teacherMapper.findById(4).getName());
    }

}