package es.rchavarria.library.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import es.rchavarria.library.core.event.CreateDetailedCourseEvent;
import es.rchavarria.library.core.event.DetailedCourseCreatedEvent;
import es.rchavarria.library.rest.domain.Course;
import es.rchavarria.library.rest.domain.CreatingCourseData;
import es.rchavarria.library.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseCommandsController {

    private static Logger LOGGER = LoggerFactory.getLogger(CourseCommandsController.class);

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Course> createCourse(@RequestBody CreatingCourseData course, UriComponentsBuilder builder) {
        LOGGER.info("creating course with title: ", course.getTitle());
        DetailedCourseCreatedEvent courseCreated = courseService.createDetailedCourse(new CreateDetailedCourseEvent(course));

        Course newCourse = Course.fromDetailedCourse(courseCreated.getDetailedCourse());
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Course>(newCourse, headers, HttpStatus.CREATED);
    }

}
