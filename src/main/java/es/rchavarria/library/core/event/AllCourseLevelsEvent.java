package es.rchavarria.library.core.event;

import java.util.List;

import es.rchavarria.library.core.domain.CourseLevel;

public class AllCourseLevelsEvent {

    private final List<CourseLevel> levels;

    public AllCourseLevelsEvent(List<CourseLevel> levels) {
        super();
        this.levels = levels;
    }

    public List<CourseLevel> getCourseLevels() {
        return levels;
    }

}
