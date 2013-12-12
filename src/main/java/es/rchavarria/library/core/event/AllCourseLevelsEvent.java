package es.rchavarria.library.core.event;

import java.util.List;

import es.rchavarria.library.rest.domain.Level;

public class AllCourseLevelsEvent {

    private final List<Level> levels;

    public AllCourseLevelsEvent(List<Level> levels) {
        super();
        this.levels = levels;
    }

    public List<Level> getCourseLevels() {
        return levels;
    }

}
