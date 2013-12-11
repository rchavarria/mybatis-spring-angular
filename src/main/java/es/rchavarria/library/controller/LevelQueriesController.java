package es.rchavarria.library.controller;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.rchavarria.library.domain.CourseLevel;
import es.rchavarria.library.rest.domain.Level;
import es.rchavarria.library.rest.domain.SimpleTeacher;
import es.rchavarria.library.service.LevelService;

@Controller
@RequestMapping("/levels")
public class LevelQueriesController {

    private static Logger LOGGER = LoggerFactory.getLogger(LevelQueriesController.class);

    @Autowired
    private LevelService levelService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Level> getAllLevels() {
        LOGGER.info("all levels will be returned");
        List<Level> levels = new LinkedList<Level>();
        
        for(CourseLevel level : levelService.requestAllCourseLevels().getCourseLevels()) {
            levels.add(Level.fromCourseLevel(level));
        }
        
        return levels;
    }

}
