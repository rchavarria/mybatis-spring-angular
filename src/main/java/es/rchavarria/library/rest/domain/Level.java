package es.rchavarria.library.rest.domain;

import es.rchavarria.library.core.domain.CourseLevel;

public class Level {

    private String level;
    
    public String getLevel() {
        return level;
    }
    
    public static Level fromCourseLevel(CourseLevel courseLevel) {
        Level level = new Level();

        level.level = courseLevel.toString();

        return level;
    }

}
