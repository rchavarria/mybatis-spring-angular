package es.rchavarria.library.rest.controller;

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

import es.rchavarria.library.core.service.CourseService;
import es.rchavarria.library.rest.domain.Course;

@Controller
@RequestMapping("/courses")
public class CourseQueriesController {

    private static Logger LOGGER = LoggerFactory.getLogger(CourseQueriesController.class);

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Course> getAllCourses() {
        LOGGER.info("all courses will be returned");
        return courseService.requestAllCourses().getCourses();
    }

}
