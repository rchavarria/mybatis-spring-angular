package es.rchavarria.library.service;

import java.util.Arrays;

import es.rchavarria.library.domain.CourseLevel;
import es.rchavarria.library.event.AllCourseLevelsEvent;

public class LevelRequestHandler implements LevelService {

	public AllCourseLevelsEvent requestAllCourseLevels() {
		return new AllCourseLevelsEvent(Arrays.asList(CourseLevel.values()));
	}

}
