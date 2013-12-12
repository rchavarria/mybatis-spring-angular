package es.rchavarria.library.core.service;

import java.util.ArrayList;
import java.util.List;

import es.rchavarria.library.core.domain.CourseLevel;
import es.rchavarria.library.core.event.AllCourseLevelsEvent;
import es.rchavarria.library.rest.domain.Level;

public class LevelRequestHandler implements LevelService {

	public AllCourseLevelsEvent requestAllCourseLevels() {
	    List<Level> levels = new ArrayList<Level>(CourseLevel.values().length);
        
        for(CourseLevel level : CourseLevel.values()) {
            levels.add(Level.fromCourseLevel(level));
        }
        
		return new AllCourseLevelsEvent(levels);
	}

}
