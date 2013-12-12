package es.rchavarria.library.service;

import java.util.Arrays;

import es.rchavarria.library.core.domain.CourseLevel;
import es.rchavarria.library.core.event.AllCourseLevelsEvent;

public class LevelRequestHandler implements LevelService {

	public AllCourseLevelsEvent requestAllCourseLevels() {
		return new AllCourseLevelsEvent(Arrays.asList(CourseLevel.values()));
	}

}
