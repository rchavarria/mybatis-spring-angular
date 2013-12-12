package es.rchavarria.library.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import es.rchavarria.library.core.domain.CourseLevel;

public class LevelRequestHandlerTest {

    @InjectMocks
    private LevelRequestHandler handler;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testRequestAllLevelsReturnsAllEnumValues() {
        List<CourseLevel> courseLevels = handler.requestAllCourseLevels().getCourseLevels();
        
        assertTrue(courseLevels.contains(CourseLevel.BASIC));
        assertTrue(courseLevels.contains(CourseLevel.INTERMEDIATE));
        assertTrue(courseLevels.contains(CourseLevel.BASIC));
    }
    
}
